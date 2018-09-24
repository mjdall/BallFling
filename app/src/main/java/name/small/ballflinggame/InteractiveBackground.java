package name.small.ballflinggame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.DisplayMetrics;
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


    public InteractiveBackground (Context c) {
        super(c);
        populateDirections();
        balls = new ArrayList<>();
        pressed = false;
        DisplayMetrics metrics = c.getResources().getDisplayMetrics();
        this.canvasDims = new Point(metrics.widthPixels, metrics.heightPixels);
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
        if (balls.size() == 0) return;
        if (pressed) spawnBall();
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
        } catch (Exception e) {

        }
    }

    private void spawnBall () {
        if (pressedAt == null) return; // Don't need this but saftey first
        MiscBall newBall = new MiscBall(pressedAt, directions[directionIndex], canvasDims);
        balls.add(newBall);
        directionIndex = directionIndex != wrapDirectionIndex ? directionIndex++ : 0;
    }

    // TODO: Fix this to be the proper on touch method
    @Override
    public Boolean onTouch (View v, MotionEvent event) {
        //int action = event.getAction();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                pressed = true;
                break;

            case MotionEvent.ACTION_MOVE:
                // User is moving around on the screen
                break;

            case MotionEvent.ACTION_UP:
                pressed = false;
                break;
        }
        return pressed;
    }

    private class MiscBall {
        private Paint ballColour = new Paint(Color.YELLOW);
        private double accelerationRate = 1.2;
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
            this.radius = 8 + rand.nextInt(9);
            this.currentBounces = 0;

            if (rand.nextInt(3) == 0) {
                speed = 25 + rand.nextInt(50);
                accelerationRate = 2;
            } else
                this.speed = 20 + rand.nextInt(15);
        }

        public void draw (Canvas canvas) {
            canvas.drawCircle(location.x, location.y, radius, ballColour);
            getNewPos();
        }

        private void getNewPos () {
            // TODO: Increment bounces on collision with wall - change dead to true when maxBounces is reached
            // TODO: Don't create a new point for working out new location
            // TODO: Implement bounds checking
            // TODO: Implement rebounds when hitting bounds
            // TODO: Implement acceleration increasing every X amount of calls to this method
            Point newLocation = new Point();
            speed = (int) speed * accelerationRate;
            newLocation.x = location.x * direction.x * (int) speed;
            newLocation.y = location.y * direction.y * (int) speed;
            location = newLocation;
        }

        private Boolean isDead () {
            return dead;
        }

    }

}
