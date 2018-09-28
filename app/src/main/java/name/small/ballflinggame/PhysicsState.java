package name.small.ballflinggame;

import android.graphics.Point;
import android.util.Log;

public class PhysicsState {
    public final static int BOUNCE_VERTICAL = 1;
    public final static int BOUNCE_HORIZONTAL = 2;

    private Vector2<Double> vel;

    private double friction;
    private double bounciness;
    private double flingDampening;

    private double stopTolerance = 5;

    private double maxVx;
    private double maxVy;

    private final double idleVy = 30;
    private final double accelerometerSpeedUp = 2.5;

    private Point bounds;

    private boolean flinged = false;

    private static double Clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }

    private static double Clamp01(double val) {
        return Clamp(val, 0, 1);
    }

    public PhysicsState(double maxVx, double maxVy, double friction, double bounciness, double flingDampening, Point bounds) {
        vel = new Vector2<>(0.0, 0.0);
        this.maxVx = maxVx;
        this.maxVy = maxVy;
        // Clamp to range 0-1
        this.friction = Clamp01(friction);
        this.bounciness = Clamp01(bounciness);
        this.flingDampening = flingDampening;
        this.bounds = bounds;
    }

    public void applyFling(double vX, double vY) {
        // Ignore flings while moving
        // Ignore flings backwards
        // if (vX < 0) return;

        if(vel.y > idleVy)
            return;

        if(vX < 0) {
            Log.d("202", vX + "");
        }

        vel.x = Clamp(vX * flingDampening, -maxVx, maxVx);
        vel.y = Clamp(vY * flingDampening, maxVy, maxVy);
        Log.d("physics", String.format("xvel: %.05f, yvel: %.05f", vel.x, vel.y));
        flinged = true;
    }

    public Vector2<Double> obstacleUpdatePos(Vector2<Double> pos) {
        pos.y += vel.y;
        return pos;
    }

    public Vector2<Double> ballUpdatePos(Vector2<Double> pos, Ball ball) {
        pos.x += vel.x;

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

    public void ballBounce(int bounceDir) {
        Log.d("202", "Bouncing " + bounciness + " " + vel.x +" " + vel.y);

        if((bounceDir & PhysicsState.BOUNCE_HORIZONTAL) != 0)
            vel.x *= -bounciness;
        if((bounceDir & PhysicsState.BOUNCE_VERTICAL) != 0)
            vel.y *= -bounciness;

        Log.d("202", "Bounced " + bounciness + " " + vel.x +" " + vel.y);

    }

    public void doPhysicsUpdate() {
        double newVy = vel.y *= friction;
        vel.x *= friction;
        vel.y = newVy > idleVy ? newVy : idleVy;
        // Log.d("physics", String.format("xvel: %.05f, yvel: %.05f", vel.x, vel.y));

        if(isStopped()) {
            Log.d("202", "Stopped");
            vel.x = 0.0;
            vel.y = idleVy;
            flinged = false;
        }

    }

    public void handleAccelerometer (float input) {
        if (isFlicked()) return;
        vel.x = (double) -input * accelerometerSpeedUp;
    }

    public boolean isFlicked () {
        return flinged;
    }

    public boolean isStopped() {
        return Math.abs(vel.x) <= stopTolerance && Math.abs(vel.y) <= idleVy + stopTolerance;
    }
}
