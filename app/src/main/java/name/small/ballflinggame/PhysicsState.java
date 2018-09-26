package name.small.ballflinggame;

import android.util.Log;

public class PhysicsState {
    public final static int BOUNCE_VERTICAL = 1;
    public final static int BOUNCE_HORIZONTAL = 2;

    private Vector2<Double> vel;

    private double friction;
    private double bounciness;
    private double flingDampening;

    private double maxVx;
    private double maxVy;

    private static double Clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }

    private static double Clamp01(double val) {
        return Clamp(val, 0, 1);
    }

    public PhysicsState(double maxVx, double maxVy, double friction, double bounciness, double flingDampening) {
        vel = new Vector2<>(0.0, 0.0);
        this.maxVx = maxVx;
        this.maxVy = maxVy;
        // Clamp to range 0-1
        this.friction = Clamp01(friction);
        this.bounciness = Clamp01(bounciness);
        this.flingDampening = flingDampening;
    }

    public void applyFling(double vX, double vY) {
        // Ignore flings while moving
        // Ignore flings backwards
        if(!isStopped() || vY > 0)
            return;

        if(vX < 0) {
            Log.d("202", vX + "");
        }

        vel.x = Clamp(vX * flingDampening, -maxVx, maxVx);
        vel.y = Clamp(vY * flingDampening, -maxVy, maxVy);
    }

    public Vector2<Double> obstacleUpdatePos(Vector2<Double> pos) {
        pos.y += -vel.y;
        return pos;
    }

    public Vector2<Double> ballUpdatePos(Vector2<Double> pos) {
        pos.x += vel.x;
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
        vel.x *= friction;
        vel.y *= friction;
        if(isStopped()) {
            Log.d("202", "Stopped");
            vel.x = 0.0;
            vel.y = 0.0;
        }
    }

    public boolean isStopped() {
        return Math.abs(vel.x) <= 1 && Math.abs(vel.y) <= 1;
    }
}
