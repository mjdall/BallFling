package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class ObstacleGenerator {
    // TODO: Generates well
    private final int genBounds = 5000;
    private final int genBaseWidth = 100;
    private final int genBaseWidthAddition = 100;
    private final int genBaseHeight = 150;
    private final int genBaseHeightAddition = 300;
    private final int totalHeightGen; // Holds the screen height + genBounds
    private ArrayList<Obstacle> leftObstacles;
    private ArrayList<Obstacle> rightObstacles;
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
        Log.d("[Generator]", "Called size - " + leftObstacles.size());
        for (int i = 0; i < leftObstacles.size(); i++) {
            leftObstacles.get(i).applyPhysics(physics);
            rightObstacles.get(i).applyPhysics(physics);

            // check if the obstacle is off screen now
            if (leftObstacles.get(i).offScreen()) {
                // if it is, remove it and generate new obstacles
                int height = leftObstacles.get(i).getDims().y;
                totalGenerated -= height;
                leftObstacles.remove(i);
                rightObstacles.remove(i);
                regenerate(physics);
                Log.d("[REGENATED]", "**********");
            }
        }
    }

    // draw the obstacles
    public void draw (Canvas c) {
        for (int i = 0; i < leftObstacles.size(); i++) {
            leftObstacles.get(i).draw(c);
            rightObstacles.get(i).draw(c);
        }
    }

    /*
        Whenever an obstacle goes off screen, we call this method.
        This will generate new obstacles until we meet our pre-rendered requirement
     */
    private void regenerate (PhysicsState phy) {
        while (true) {
            if (totalGenerated >= totalHeightGen) break;
            Point newObjDims = new Point(genBaseWidth + rand.nextInt(genBaseWidthAddition), genBaseHeight + rand.nextInt(genBaseHeightAddition));
            double rightX = outerBounds.x - newObjDims.x;
            double y = leftObstacles.get(leftObstacles.size() - 1).getPos().y - newObjDims.y;
            RectObstacle leftObj = new RectObstacle(0, y, newObjDims, outerBounds);
            RectObstacle rightObj = new RectObstacle(rightX, y, newObjDims, outerBounds);
            totalGenerated += newObjDims.y;
            leftObstacles.add(leftObj);
            rightObstacles.add(rightObj);
        }
    }

    private void initObstacles () {
        leftObstacles = new ArrayList<>();
        rightObstacles = new ArrayList<>();
        GenBounds gb = new GenBounds(outerBounds, totalHeightGen);
        Log.d("[InitGenerator]", "Called - " + gb.enoughAlready());
        // Generates new obstacles on either side of the screen until it has generated a certain height of objects
        while (!gb.enoughAlready()) {
            Point newObjDims = new Point(genBaseWidth + rand.nextInt(genBaseWidthAddition), genBaseHeight + rand.nextInt(genBaseHeightAddition));
            gb.setGenParams(newObjDims);
            RectObstacle leftObj = new RectObstacle(0, gb.y(), newObjDims, outerBounds);
            RectObstacle rightObj = new RectObstacle(gb.xMax(), gb.y(), newObjDims, outerBounds);
            leftObstacles.add(leftObj);
            rightObstacles.add(rightObj);
            Log.d("[Generator]", "Making new obstacle");
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
