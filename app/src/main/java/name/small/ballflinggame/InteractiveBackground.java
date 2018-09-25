package name.small.ballflinggame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InteractiveBackground extends View {
    private final int maxBalls = 20;
    private List<MiscBall> balls;
    private Boolean pressed;
    private Point pressedAt;
    private Point canvasDims;
    private double[][] directions;
    private int directionIndex;
    private int wrapDirectionIndex;
    private final int spawnRate = 2;
    private int spawnCount;


    public InteractiveBackground (Context c) {
        super(c);
        populateDirections();
        balls = new ArrayList<>();
        pressedAt = new Point();
        pressed = false;
        DisplayMetrics metrics = c.getResources().getDisplayMetrics();
        this.canvasDims = new Point(metrics.widthPixels, metrics.heightPixels);
        spawnCount = spawnRate - 1;
    }

    // create a direction array holding (-1, -1) to (1, 1)
    private void populateDirections () {
        directionIndex = 0;
        int arrayIndex = 0;
        directions = new double[21][2];
        wrapDirectionIndex = 20;

        // TODO: Fix directions -> radiate out from (0,1) back to (0,1)
        for (int i = 0; i < 11; i++) {
            double[] direction = new double[2];
            direction[1] = 1 - (i * 0.2);
            direction[0] = i < 6 ? 0.2 * i : 1 - (i * 0.2);
            directions[arrayIndex] = direction;
            arrayIndex++;
        }

        for (int i = 0; i < 10; i++) {
            double[] direction = new double[2];
            direction[1] = -1 + (i * 0.2);
            direction[0] = i < 6 ? -0.2 * i : -1 + (i * 0.2);
            directions[arrayIndex] = direction;
            arrayIndex++;
        }

        /*
        for (double y = -1; y < 2; y++)
            for (double x = -1; x < 2; x++) {
            if (x == 0 && y == 0) continue;
                double[] direction = new double[2];
                direction[0] = x;
                direction[1] = y;
                directions[arrayIndex] = direction;
                arrayIndex++;
            }
        */
    }

    @Override
    public void onDraw (Canvas canvas) {
        // Log.d("[OnDraw]", Boolean.toString(pressed));
        if (pressed) { spawnCount++; spawnBall(); }
        if (balls.size() == 0) return;
        try {
            for (MiscBall b : balls) {
                if (b.isDead()) {
                    balls.remove(b);
                    // TODO: Implement explosions on death -> create explosion class or death seq in miscballs
                    // deadBalls = b.playDead();
                    continue;
                }
                b.draw(canvas);
            }
            invalidate();
        } catch (Exception e) {
            invalidate();
        }
    }

    private void spawnBall () {
        if (spawnCount != spawnRate) return;
        if (maxBalls == balls.size()) balls.remove(0);
        MiscBall newBall = new MiscBall(pressedAt, directions[directionIndex], canvasDims);
        balls.add(newBall);
        directionIndex = directionIndex != wrapDirectionIndex ? directionIndex + 1 : 0;
        spawnCount = 0;
        invalidate();
    }

    // TODO: Fix this to be the proper on touch method
    @Override
    public boolean onTouchEvent (MotionEvent event) {
        Log.d("[OnTouch]", "Screen touched");
        //int action = event.getAction();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                pressed = true;
                pressedAt.x = (int) event.getX();
                pressedAt.y = (int) event.getY();
                Log.d("[OnTouch]", "x: " + Integer.toString(pressedAt.x) + " y: " + Integer.toString(pressedAt.y));
                invalidate();
                break;

            case MotionEvent.ACTION_MOVE:
                pressedAt.x = (int) event.getX();
                pressedAt.y = (int) event.getY();
                break;

            case MotionEvent.ACTION_UP:
                pressed = false;
                break;
        }
        return pressed;
    }

    // TODO: RF Collision math into an abstract class to inherit from
    private class MiscBall {
        private Paint ballColour = new Paint(Color.YELLOW);
        private Boolean accelerationEnabled = false;
        private double accelerationRate = 1.1;
        private final int accelerationThresh = 15; // was 1-
        private final int maxSpeed = 50;
        private int drawn;
        private Boolean dead = false;
        private final int bouncesTillDeath;
        private int currentBounces;
        private Point location;
        private double[] direction;
        private Point bounds;
        private double speed;
        private int radius;

        public MiscBall (Point spawnLoc, double[] direction, Point bounds) {
            this.location = spawnLoc;
            this.bounds = bounds;
            this.bouncesTillDeath =  5;
            this.direction = direction;
            Random rand = new Random();
            this.radius = 20 + rand.nextInt(9);
            this.currentBounces = 0;
            this.drawn = 0;

            if (rand.nextInt(8) == 0) {
                speed = 20 + rand.nextInt(25);
                accelerationRate = 1.2;
            } else
                this.speed = 20 + rand.nextInt(10);
        }

        public void draw (Canvas canvas) {
            Log.d("[draw]", "location x: " + Integer.toString(location.x) + " y: " + Integer.toString(location.y));
            canvas.drawCircle(location.x, location.y, radius, ballColour);
            drawn++;
            if (drawn == accelerationThresh && speed < maxSpeed && accelerationEnabled) {
                drawn = 0;
                speed = speed * accelerationRate;
            }
            getNewPos();
        }

        private void getNewPos () {
            // TODO: Don't create a new point for working out new location
            // TODO: Create collision with other balls method
            Point newLocation = new Point();
            if (location.x == 0) { direction[0] = -direction[0]; currentBounces++; }
            if (location.y == 0) { direction[1] = -direction[1]; currentBounces++; }
            if (location.x == bounds.x) direction[0] = -1;
            if (location.y == bounds.y) direction[1] = -1;
            newLocation.x = location.x + (int) (direction[0] * speed);
            newLocation.y = location.y + (int) (direction[1] * speed);
            if (newLocation.x < 0) newLocation.x = 0;
            if (newLocation.y < 0) newLocation.y = 0;
            if (newLocation.x > bounds.x) { newLocation.x = bounds.x; currentBounces++; }
            if (newLocation.y > bounds.y) { newLocation.y = bounds.y; currentBounces++; }
            if (currentBounces >= bouncesTillDeath) dead = true;
            location = newLocation;
        }

        public void collision (MiscBall mb) {
            if (!overlap(mb)) return;
            // TODO: CollidedWith property -> might solve 3 way collisions
            int distance = getDistance(mb);
            // if (checkOverlap(distance, mb.getRadius())) // TODO: Implement setting balls touching before a frame before bouncing -> pythag
            // TODO: Work out new direction vector, then set the balls to be touching

        }

        // checks if two balls overlapping -> getDistance can get the distance param
        private boolean checkOverlap (int distance, int secondRadius) {
            return distance < radius + secondRadius;
        }

        // checks the distance between two balls
        private int getDistance(MiscBall mb) {
            Point mbLoc = mb.getLocation();
            return (int) Math.sqrt(
                    (Math.pow((mbLoc.x - location.x),2) + Math.pow((mbLoc.y - location.y),2))
            );
        }

        // checks to see if two balls are currently colliding
        private boolean overlap (MiscBall mb) {
            Point mbLoc = mb.getLocation();
            int mbRad = mb.getRadius();
            return Math.pow((mbLoc.x - location.x), 2) + Math.pow((mbLoc.y - location.y), 2) <= Math.pow((mbRad - radius), 2);
        }

        public Point getLocation () {
            return location;
        }

        public int getRadius () {
            return radius;
        }

        private Boolean isDead () {
            return dead;
        }
    }

}
