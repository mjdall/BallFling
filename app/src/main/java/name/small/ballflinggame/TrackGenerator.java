package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import obstacles.Obstacle;
import obstacles.OutOfBoundsObstacle;
import physics.Collider;
import physics.PhysicsState;
import physics.StatusAffect;
import tracksegments.BrokenBridge;
import tracksegments.CastleKeep;
import tracksegments.CastleWalls;
import tracksegments.IceBridge;
import tracksegments.TrackBlueprint;
import tracksegments.TrackSegment;
import tracksegments.WaterBridge;

public class TrackGenerator {
    private final int offScreenHeightGen;
    private final int totalToGen;
    private int heightGenerated;
    private Point screenDims;


    private OutOfBoundsObstacle outOfBoundsObstacle;
    private ArrayList<TrackSegment> trackSegments;
    private ArrayList<TrackBlueprint> blueprints;

    public TrackGenerator (Point screenDims) {
        this.screenDims = screenDims;
        this.trackSegments = new ArrayList<>();
        this.heightGenerated = 0;
        this.offScreenHeightGen = screenDims.y * 2;
        this.totalToGen = screenDims.y + offScreenHeightGen * 2;
        blueprints = new ArrayList<>();
        setBlueprints();
        generateBaseSpawn();
        outOfBoundsObstacle = new OutOfBoundsObstacle(screenDims, screenDims.y * 1.5);
    }

    public void doPhysicsOnObstacles (PhysicsState physics) {
        Log.d("202", String.format("SegmentArraySize: %s", Integer.toString(trackSegments.size())));
        List<TrackSegment> toRemove = new ArrayList<>();
        for (int i = trackSegments.size() -1; i >= 0; i-- ) { // Reverse order to allow removing
            TrackSegment ts = trackSegments.get(i);
            Log.d("202", String.format("Segment loc: x:%s, y:%s", ts.pos.x, ts.pos.y));
            ts.applyPhysics(physics);
            if (ts.getYPos() > offScreenHeightGen) {
                heightGenerated -= ts.getHeight();
                trackSegments.remove(ts);
                regenerate();
            }
        }


        outOfBoundsObstacle.applyPhysics(physics);
    }

    private void regenerate () {
        Random rand = new Random();
        double yPosGen = trackSegments.get(trackSegments.size() - 1).getYPos();
        while (heightGenerated <= totalToGen) {
            TrackBlueprint tb = blueprints.get(rand.nextInt(blueprints.size()));
            yPosGen -= tb.getHeight();
            TrackSegment ts = new TrackSegment(0.0, yPosGen, screenDims, tb );
            trackSegments.add(ts);
            heightGenerated += ts.getHeight();
        }
    }

    public void drawShadow (Canvas canvas) {
        for (int i = trackSegments.size() -1; i >= 0; i-- ) { // Reverse order to get correct draw order
            TrackSegment ts = trackSegments.get(i);
            ts.drawShadow(canvas);
        }

        outOfBoundsObstacle.drawShadow(canvas);
    }

    // Returns null on fatal collision or if bounces is already null
    private PhysicsAffects getListPhysicsAffects(List<Obstacle> obstacles, Ball b, PhysicsState phys, PhysicsAffects affects) {
        if(affects == null) // Propagate previous failure here for cleanliness
            return null;

        // Check if player has gone too far backwards
        if(outOfBoundsObstacle.checkCollision(b) == Collider.CollisionType.Internal)
            return null;

        for (Obstacle o : obstacles) {
            Collider.CollisionType collisionType = o.checkCollision(b);
            if(collisionType != Collider.CollisionType.None) {
                Log.d("202", "Normal Obstacle:" + o.toString());
                if(o.isDeadly()) {
                    // Die if past point of no return
                    if (collisionType == Collider.CollisionType.Internal)
                        return null;
                    else
                        continue;
                }

                StatusAffect statusAffect = o.getStatusAffect();
                if(statusAffect != StatusAffect.NONE) {
                    if(collisionType == Collider.CollisionType.Internal)
                        affects.statusAffects.add(statusAffect);
                    continue;
                }

                Vector2<Integer> bounce = o.getBounceDir(b, phys);
                if(bounce != null) {
                    Log.d("202", "Bounce: " + bounce.x + " " + bounce.y);
                    affects.bounces.add(bounce);
                }
            }
        }
        return affects;
    }

    public class PhysicsAffects {
        public List<Vector2<Integer>> bounces;
        public List<StatusAffect> statusAffects;
    }

    // Returns null on fatal collision
    public PhysicsAffects getPhysicsAffects(Ball b, PhysicsState phys) {
        PhysicsAffects physicsAffects = new PhysicsAffects();
        physicsAffects.bounces = new ArrayList<>();
        physicsAffects.statusAffects = new ArrayList<>();
        for (TrackSegment ts : trackSegments) {
            physicsAffects = getListPhysicsAffects(ts.getObstacles(), b, phys, physicsAffects);
        }

        return physicsAffects;
    }

    public void draw (Canvas canvas) {
        for (int i = trackSegments.size() - 1; i >= 0; i--) { // Reverse order to get correct draw order
            TrackSegment ts = trackSegments.get(i);
            ts.draw(canvas);
        }

        outOfBoundsObstacle.draw(canvas);
    }

    private void setBlueprints () {
        blueprints.add(new WaterBridge(screenDims));
        blueprints.add(new BrokenBridge(screenDims));
        blueprints.add(new IceBridge(screenDims));
        blueprints.add(new CastleKeep(screenDims));
    }

    private void generateBaseSpawn () {
        Random rand = new Random();
        double yPosGen = screenDims.y + offScreenHeightGen;
        Log.d("202", String.format("Total to gen: %s, starting at: %s", Integer.toString(totalToGen), Double.toString(yPosGen)));
        while (heightGenerated <= totalToGen) {
            TrackBlueprint tb = blueprints.get(rand.nextInt(blueprints.size()));

            if(yPosGen >= 0 && !tb.allowInitialSpawn()) {
                // Don't create obstacle that could cause bad spawn position
                continue;
            }

            yPosGen -= tb.getHeight();
            Log.d("202", String.format("Spawning at: %s", yPosGen));
            TrackSegment ts = new TrackSegment(0.0, yPosGen, screenDims, tb);
            trackSegments.add(ts);
            heightGenerated += ts.getHeight();
            Log.d("202", String.format("Generated %s", heightGenerated));
        }
    }

}
