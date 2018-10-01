package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstacleGenerator {
    // TODO: Generates well
    private final int genBounds = 5000;
    private final int totalHeightGen; // Holds the screen height + genBounds
    private ArrayList<TrackPiece> track;
    /*
    private ArrayList<Obstacle> leftObstacles;
    private ArrayList<Obstacle> rightObstacles;
    private ArrayList<Obstacle> otherObstacles;
    */
    private Point outerBounds;

    private int totalGenerated;
    private Random rand;

    public ObstacleGenerator (Point outerBounds) {
        this.outerBounds = outerBounds;
        rand = new Random();
        totalHeightGen = genBounds + outerBounds.y;
        totalGenerated = 0;
        initObstacles();
    }

    // Don't need to use two lists but yolo
    public void doPhysicsOnObstacles (PhysicsState physics) {
        for (TrackPiece tp : track) {
            tp.applyPhysics(physics);
            if (tp.outOfBounds()) {
                totalGenerated -= tp.getHeight();
                regenerate(tp);
                track.remove(tp);
            }
        }
    }

    // Returns null on fatal collision
    public List<Vector2<Integer>> getBounces(Ball b, PhysicsState phys) {
        List<Vector2<Integer>> list = new ArrayList<>();
        for (TrackPiece tp : track) {
            if (tp.checkCollisions(b)) {
                // check deadly collision
                    // return null
                Vector2<Integer> bounce = tp.getBounceDir(b, phys);
                if (bounce != null) {
                    list.add(bounce);
                }
            }
        }
        /*
        List<Vector2<Integer>> list = new ArrayList<>();
        for (Obstacle o : otherObstacles) {
            if(o.checkCollision(b)) {
                Log.d("202", "Normal Obstacle:" + o.toString());
                if(o.isDeadly())
                    return null;
                Vector2<Integer> bounce = o.getBounceDir(b, phys);
                if(bounce != null) {
                    Log.d("202", "Bounce: " + bounce.x + " " + bounce.y);
                    list.add(bounce);
                }
            }
        }*/
        return list;
    }

    // draw the obstacles
    public void draw (Canvas c) {
        for (TrackPiece tp : track)
            tp.draw(c);
    }

    /*
        Whenever an obstacle goes off screen, we call this method.
        This will generate new obstacles until we meet our pre-rendered requirement
     */
    private void regenerate (TrackPiece tp) {
        while (true) {
            if (totalGenerated >= totalHeightGen) break;
            double y = track.get(track.size() - 1).getPos().y;
            Vector2<Double> vd = new Vector2<>(0.0, y);
            TrackPiece newPiece = tp.setRandomNextPiece(vd);
            track.add(newPiece);
            totalGenerated += newPiece.getHeight();
        }
    }

    private void initObstacles () {
        track = new ArrayList<>();
        int totalGen = 0;
        TrackPiece tp = new WaterBridge(0,0, outerBounds);
        Vector2<Double> spawnPos = new Vector2<>(0.0, -Math.abs(outerBounds.y - tp.getHeight()));

        while (totalGen <= totalHeightGen) {
            tp.setPos(spawnPos);
            track.add(tp);
            totalGen += tp.getHeight();
            tp = tp.setRandomNextPiece(spawnPos);
            spawnPos.y -= tp.getHeight();
        }
        totalGenerated = totalGen;
        Log.d("[INIT]", "Objects inited");
    }
}
