package physics;

import android.graphics.Point;
import android.util.Log;

import java.util.List;

import name.small.ballflinggame.Ball;
import name.small.ballflinggame.Vector2;

public class PhysicsState {
    public final static int BOUNCE_VERTICAL = 1;
    public final static int BOUNCE_HORIZONTAL = 2;

    private Vector2<Double> vel;
    private double acclVel = 0.0;

    private double baseFriction;
    private double activeFriction;
    private double bounciness;
    private double flingDampening;

    private double stopTolerance = 2.5;

    private double maxVx;
    private double maxVy;
    private double maxV;
    private double maxAcclBase = 5;
    private double maxAccl = maxAcclBase;

    private final double accelerometerSpeedUpBase = 1.7;
    private double getAccelerometerSpeedUpActive;

    private double distanceTravelled = 0.0;

    private Point bounds;

    private static double Clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }

    private static double Clamp01(double val) {
        return Clamp(val, 0, 1);
    }

    public PhysicsState(double maxVx, double maxVy, double baseFriction, double bounciness, double flingDampening, Point bounds) {
        vel = new Vector2<>(0.0, 0.0);
        this.maxVx = maxVx;
        this.maxVy = maxVy;
        maxV = Math.sqrt(maxVx*maxVx+maxVy*maxVy);
        // Clamp to range 0-1
        this.baseFriction = Clamp01(baseFriction);
        this.activeFriction = this.baseFriction;
        this.bounciness = Clamp01(bounciness);
        this.flingDampening = flingDampening;
        this.bounds = bounds;

        this.getAccelerometerSpeedUpActive = accelerometerSpeedUpBase;
    }

    public void applyFling(double vX, double vY) {
        // Ignore flings while moving
        if (!isStopped()) return;

        vel.x = Clamp(vX * flingDampening, -maxVx, maxVx);
        vel.y = Clamp(vY * flingDampening, -maxVy, maxVy);
        Log.d("physics", String.format("xvel: %.05f, yvel: %.05f", vel.x, vel.y));
    }

    public Vector2<Double> getVel() {
        return vel;
    }

    public Vector2<Double> obstacleUpdatePos(Vector2<Double> pos) {
        pos.y += (-vel.y);
        return pos;
    }

    public Vector2<Double> ballUpdatePos(Ball ball) {
        Vector2<Double> pos = ball.getPos();
        pos.x += vel.x;
        distanceTravelled += (-vel.y);


        // Bounce off edge of screen
        // Should never happen
        if (pos.x < ball.getRadius() || pos.x > bounds.x - ball.getRadius()) {
            ballBounce(PhysicsState.BOUNCE_HORIZONTAL);
            if (pos.x < ball.getRadius())
                pos.x = ball.getRadius();
            else
                pos.x = bounds.x - ball.getRadius();
            ball.setPos(pos);
        }

        return pos;
    }

    public void doBounces(List<Vector2<Integer>> bounces) {
        int xSum = 0;
        int ySum = 0;
        for(Vector2<Integer> bounce : bounces) {
            xSum += bounce.x;
            ySum += bounce.y;
        }

        int bounceDir = 0;
        if((xSum > 0 && vel.x < 0) || (xSum < 0 && vel.x > 0)) {
            bounceDir |= BOUNCE_HORIZONTAL;
        }
        if((ySum > 0 && vel.y < 0) || (ySum < 0 && vel.y > 0)) {
            bounceDir |= BOUNCE_VERTICAL;
        }

        ballBounce(bounceDir);
    }

    public void doStatusAffects(List<StatusAffect> statusAffects) {
        activeFriction = baseFriction;
        getAccelerometerSpeedUpActive = accelerometerSpeedUpBase;
        maxAccl = maxAcclBase;
        // If affects override each other then last one takes affect
        for(StatusAffect statusAffect : statusAffects) {
            switch (statusAffect) {
                case SAND:
                    activeFriction = 0.7;
                    getAccelerometerSpeedUpActive = 0.0;
                    break;
                case LONG_GRASS:
                    activeFriction = 0.9;
                    getAccelerometerSpeedUpActive = 0.0;
                    break;
                case ICE:
                    activeFriction = 0.999;
                    getAccelerometerSpeedUpActive = 5.0;
                    break;
                case VOLCANIC:
                    activeFriction = 0.94;
                    break;
            }
        }
    }

    // Applies bounciness to affected directions
    private void ballBounce(int bounceDir) {
        if(bounceDir == 0) return;
        Log.d("202", "Bouncing " + bounciness + " " + vel.x +" " + vel.y);

        if((bounceDir & PhysicsState.BOUNCE_HORIZONTAL) != 0) {
            vel.x *= -bounciness;
            acclVel *= bounciness;
        }

        if((bounceDir & PhysicsState.BOUNCE_VERTICAL) != 0) {
            vel.y *= -bounciness;
        }

        Log.d("202", "Bounced " + bounciness + " " + vel.x +" " + vel.y);
    }

    public void doPhysicsUpdate() {
        acclVel *= this.activeFriction;
        vel.x *= this.activeFriction;
        vel.y *= this.activeFriction;
        // Log.d("physics", String.format("xvel: %.05f, yvel: %.05f", vel.x, vel.y));

        if(isStopped()) {
            Log.d("202", "Stopped");
            stop();
        }

    }

    public void handleAccelerometer (float input) {
        if (!isStopped()) {
            vel.x -= acclVel;
            acclVel = Clamp((double) -input * getAccelerometerSpeedUpActive * (Math.sqrt(vel.x*vel.x+vel.y*vel.y)/maxV), -maxAccl, maxAccl);
            if(vel.x + acclVel > maxVx) {
                acclVel = maxVx - vel.x;
            } else if(vel.x + acclVel < -maxVx) {
                acclVel = (-maxVx) - vel.x;
            }
            vel.x += acclVel;
        }

    }

    public void stop() {
        acclVel = 0.0;
        vel.x = 0.0;
        vel.y = 0.0;
    }

    public boolean isStopped() {
        return Math.abs(vel.x - acclVel) <= stopTolerance && Math.abs(vel.y) <= stopTolerance;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }
}
