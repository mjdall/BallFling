package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstacleGenerator {
    // TODO: Generates well
    private final int genBounds = 2000;
    private final int genBaseWidth = 100;
    private final int genBaseWidthAddition = 100;
    private final int genBaseHeight = 250;
    private final int genBaseHeightAddition = 300;
    private final int totalHeightGen; // Holds the screen height + genBounds
    private ArrayList<Obstacle> leftObstacles;
    private ArrayList<Obstacle> rightObstacles;
    private ArrayList<Obstacle> otherObstacles;
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
        for (int i = leftObstacles.size() - 1; i >= 0; i--) {
            leftObstacles.get(i).applyPhysics(physics);
            rightObstacles.get(i).applyPhysics(physics);

            // check if the obstacle is off screen now
            if (leftObstacles.get(i).pos.y > outerBounds.y + 1000) {
                // if it is, remove it and generate new obstacles
                int height = leftObstacles.get(i).getDims().y;
                totalGenerated -= height;
                leftObstacles.remove(i);
                rightObstacles.remove(i);
                regenerate();
            }
        }
        for (int i = otherObstacles.size() - 1; i >= 0; i--) {
            Obstacle o = otherObstacles.get(i);
//            if(o.pos.y > outerBounds.y + 1000)
//                otherObstacles.remove(i);
            o.applyPhysics(physics);
        }
    }

    private static int count = 0;

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

        bounces = getListBounces(otherObstacles, b, phys, bounces);
        bounces = getListBounces(rightObstacles, b, phys, bounces);
        bounces = getListBounces(leftObstacles, b, phys, bounces);

        return bounces;
    }

    public void drawShadow(Canvas c) {
        for (Obstacle o : otherObstacles) {
            o.drawShadow(c);
        }
        for (int i = 0; i < leftObstacles.size(); i++) {
            leftObstacles.get(i).drawShadow(c);
            rightObstacles.get(i).drawShadow(c);
        }
    }

    // draw the obstacles
    public void draw (Canvas c) {

        for (Obstacle o : otherObstacles) {
            o.draw(c);
        }
        for (int i = 0; i < leftObstacles.size(); i++) {
            leftObstacles.get(i).draw(c);
            rightObstacles.get(i).draw(c);
        }
    }

    /*
        Whenever an obstacle goes off screen, we call this method.
        This will generate new obstacles until we meet our pre-rendered requirement
     */
    private void regenerate () {
        while (totalGenerated < totalHeightGen) {
            Point newObjDims = new Point(genBaseWidth + genBaseWidthAddition/2, genBaseHeight + genBaseHeightAddition/2);
            double rightX = outerBounds.x - newObjDims.x;
            double y = leftObstacles.get(leftObstacles.size() - 1).getPos().y - newObjDims.y;
            Wall leftObj = new Wall(0, y, newObjDims);
            Wall rightObj = new Wall(rightX, y, newObjDims);
            totalGenerated += newObjDims.y;
            leftObstacles.add(leftObj);
            rightObstacles.add(rightObj);

            Log.d("202", "Gen centre obstacle: " + (rightX / 2 - newObjDims.x/2) + " " + y + " " + newObjDims.x + " " + newObjDims.y);
            if((count % 2) != 1) {

                Point dims = new Point((int)(outerBounds.x * 0.6), newObjDims.y);
                Water centreObstacle = new Water(count % 4 == 0 ? 0 : outerBounds.x * 0.3, y, dims);
                otherObstacles.add(centreObstacle);
            } else {
                Log.d("202", "Ignoring");
            }
            count++;

        }
    }

    private void initObstacles () {
        leftObstacles = new ArrayList<>();
        rightObstacles = new ArrayList<>();
        otherObstacles = new ArrayList<>();

        Point obsDims = new Point(outerBounds.x, 100);

        GenBounds gb = new GenBounds(outerBounds, totalHeightGen);
        // Generates new obstacles on either side of the screen until it has generated a certain height of objects
        while (!gb.enoughAlready()) {
            Point newObjDims = new Point(genBaseWidth + genBaseWidthAddition/2, genBaseHeight + genBaseHeightAddition/2);
            gb.setGenParams(newObjDims);
            Wall leftObj = new Wall(0, gb.y(), newObjDims);
            Wall rightObj = new Wall(gb.xMax(), gb.y(), newObjDims);
            leftObstacles.add(leftObj);
            rightObstacles.add(rightObj);
        }
        totalGenerated = gb.getGenerated();
    }

    /*
        This class is used to know when we've generated enough obstacles and
        to know where the x and y of where to generate our obstacles with the
        width and height we have given them.
        TODO: Make genbounds class hold the state of the objects
     */
    private class GenBounds {
        final int xRestrict;
        final int totalGenHeight;
        int generated;
        int yGenHeight;
        int xGenMax;

        public GenBounds (Point screenDims, int totalGenHeight) {
            yGenHeight = screenDims.y;
            xGenMax = screenDims.x;
            xRestrict = screenDims.x;
            this.totalGenHeight = totalGenHeight;
            generated = 0;
        }

        public void setGenParams (Point objectDims) {
            xGenMax = xRestrict - objectDims.x;
            yGenHeight -= objectDims.y;
            generated += objectDims.y;
        }

        public int y () {
            return yGenHeight;
        }

        public int xMax () {
            return xGenMax;
        }

        public boolean enoughAlready () {
            return generated > totalGenHeight;
        }

        public int getGenerated () {
            return generated;
        }
    }
}
