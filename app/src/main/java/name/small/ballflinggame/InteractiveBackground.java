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
    private List<MiscBall> balls;
    private Boolean pressed;
    private Point pressedAt;
    private Point canvasDims;
    // private final int maxBalls = 50;
    private Point[] directions;
    private int directionIndex;
    private int wrapDirectionIndex;
    private final int spawnRate = 3;
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
        directions = new Point[8];
        wrapDirectionIndex = 7; // TODO: Add more directions in (need to RF to use double[] or similar)
        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++) {
            if (i == 0 && j == 0) continue;
                Point direction = new Point(i, j);
                directions[arrayIndex] = direction;
                arrayIndex++;
            }
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

    private class MiscBall {
        private Paint ballColour = new Paint(Color.YELLOW);
        private double accelerationRate = 1.1;
        private final int accelerationThresh = 10;
        private final int maxSpeed = 50;
        private int drawn;
        private Boolean dead = false;
        private final int bouncesTillDeath;
        private int currentBounces;
        private Point location;
        private Point direction;
        private Point bounds;
        private double speed;
        private int radius;

        public MiscBall (Point spawnLoc, Point direction, Point bounds) {
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
            if (drawn == accelerationThresh && speed < maxSpeed) {
                drawn = 0;
                speed = speed * accelerationRate;
            }
            getNewPos();
        }

        private void getNewPos () {
            // TODO: Increment bounces on collision with wall - change dead to true when maxBounces is reached
            // TODO: Don't create a new point for working out new location
            // TODO: Implement bounds checking
            // TODO: Implement rebounds when hitting bounds
            // TODO: Implement acceleration increasing every X amount of calls to this method
            Point newLocation = new Point();
            if (location.x == 0) { direction.x = 1; currentBounces++; }
            if (location.y == 0) { direction.y = 1; currentBounces++; }
            if (location.x == bounds.x) direction.x = -1;
            if (location.y == bounds.y) direction.y = -1;
            newLocation.x = location.x + direction.x * (int) speed;
            newLocation.y = location.y + direction.y * (int) speed;
            if (newLocation.x < 0) newLocation.x = 0;
            if (newLocation.y < 0) newLocation.y = 0;
            if (newLocation.x > bounds.x) { newLocation.x = bounds.x; currentBounces++; }
            if (newLocation.y > bounds.y) { newLocation.y = bounds.y; currentBounces++; }
            if (currentBounces == bouncesTillDeath) dead = true;
            location = newLocation;
        }

        private Boolean isDead () {
            return dead;
        }

    }

}
