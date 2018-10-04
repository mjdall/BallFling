package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrackGenerator {
    private final int offScreenHeightGen = 5000;
    private final int totalToGen;
    private int heightGenerated;
    private Point screenDims;

    private ArrayList<TrackSegment> trackSegments;
    private ArrayList<TrackBlueprint> blueprints;

    public TrackGenerator (Point screenDims) {
        this.screenDims = screenDims;
        this.trackSegments = new ArrayList<>();
        this.heightGenerated = 0;
        this.totalToGen = screenDims.y + offScreenHeightGen * 2;
        blueprints = new ArrayList<>();
        setBlueprints();
        generateBaseSpawn();
    }

    public void doPhysicsOnObstacles (PhysicsState physics) {
        Log.d("202", String.format("SegmentArraySize: %s", Integer.toString(trackSegments.size())));
        List<TrackSegment> toRemove = new ArrayList<>();
        for (TrackSegment ts : trackSegments) {
            Log.d("202", String.format("Segment loc: x:%s, y:%s", ts.pos.x, ts.pos.y));
            ts.applyPhysics(physics);
            if (ts.getYPos() > offScreenHeightGen) {
                heightGenerated -= ts.getHeight();
                toRemove.add(ts);
            }
        }
        for(TrackSegment ts : toRemove) {
            trackSegments.remove(ts);
        }
        if(!toRemove.isEmpty()) {
            regenerate();
        }
    }

    private void regenerate () {
        Random rand = new Random();
        double yPosGen = trackSegments.get(trackSegments.size() - 1).getYPos();
        while (heightGenerated <= totalToGen) {
            TrackBlueprint tb = blueprints.get(1);//rand.nextInt(blueprints.size()));
            yPosGen -= tb.getHeight();
            TrackSegment ts = new TrackSegment(0.0, yPosGen, screenDims, tb );
            trackSegments.add(ts);
            heightGenerated += ts.getHeight();
        }
    }

    public void drawShadow (Canvas canvas) {
        for (TrackSegment ts : trackSegments)
            ts.drawShadow(canvas);
    }

    // Returns null on fatal collision or if bounces is already null
    private List<Vector2<Integer>> getListBounces(List<Obstacle> obstacles, Ball b, PhysicsState phys, List<Vector2<Integer>> bounces) {
        if(bounces == null) // Propogate previous failure here for cleanliness
            return null;
        for (Obstacle o : obstacles) {
            Collider.CollisionType collisionType = o.checkCollision(b);
            if(collisionType != Collider.CollisionType.None) {
                Log.d("202", "Normal Obstacle:" + o.toString());
                if(o.isDeadly()) {
                    if(collisionType == Collider.CollisionType.Internal) // Die if past point of no return
                        return null;
                    else
                        continue;
                }
                Vector2<Integer> bounce = o.getBounceDir(b, phys);
                if(bounce != null) {
                    Log.d("202", "Bounce: " + bounce.x + " " + bounce.y);
                    bounces.add(bounce);
                }
            }
        }
        return bounces;
    }

    // Returns null on fatal collision
    public List<Vector2<Integer>> getBounces(Ball b, PhysicsState phys) {
        List<Vector2<Integer>> bounces = new ArrayList<>();
        for (TrackSegment ts : trackSegments)
            bounces = getListBounces(ts.getObstacles(), b, phys, bounces);

        return bounces;
    }

    public void draw (Canvas canvas) {
        for (TrackSegment ts : trackSegments)
            ts.draw(canvas);
    }

    private void setBlueprints () {
        WaterBridge wb = new WaterBridge(screenDims);
        BrokenBridge bb = new BrokenBridge(screenDims);
        blueprints.add(wb);
        blueprints.add(bb);
    }

    private void generateBaseSpawn () {
        Random rand = new Random();
        double yPosGen = screenDims.y + offScreenHeightGen;
        Log.d("202", String.format("Total to gen: %s, starting at: %s", Integer.toString(totalToGen), Double.toString(yPosGen)));
        while (heightGenerated <= totalToGen) {
            TrackBlueprint tb = blueprints.get(rand.nextInt(blueprints.size()));
            yPosGen -= tb.getHeight();
            Log.d("202", String.format("Spawning at: %s", yPosGen));
            TrackSegment ts = new TrackSegment(0.0, yPosGen, screenDims, tb);
            trackSegments.add(ts);
            heightGenerated += ts.getHeight();
            Log.d("202", String.format("Generated %s", heightGenerated));
        }
    }

}
