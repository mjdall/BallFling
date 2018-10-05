package physics;

import android.util.Log;

import name.small.ballflinggame.Ball;
import name.small.ballflinggame.Vector2;

public class TunnelCollider extends RectCollider {
    public TunnelCollider (double x, double y, double w, double h) {
        super(x, y, w, h);
    }

    @Override
    public Vector2<Integer> getBounceDir(Ball b, PhysicsState phys) {
            Vector2<Double> pos = b.getPos();
            double radius = b.getRadius();
            double radiusSqr = radius*radius;
            Vector2<Double> vel = phys.getVel();

            // Completely inside rectangle
            if(pos.x >= tl.x && pos.x <= tr.x && pos.y >= tl.y && pos.y <= bl.y) {
                Log.d("202", "Adjusting position");
                // Rewind position to collision point
                pos = findCollisionPoint(pos, vel);
            }


            // If the ball is touching left or right side
            if(pos.y >= tl.y && pos.y <= bl.y) {
                if(Math.abs(pos.x - tl.x) <= radius) {
                    return new Vector2<>(-1, 0);
                } else if(Math.abs(pos.x - tr.x) <= radius) {
                    return new Vector2<>(1, 0);
                }
                return new Vector2<>(0, 0);
            }


            // If one of the corners are inside the ball
            if(getDistSqr(tl, pos) <= radiusSqr) {
                // Bounce up and left
                return new Vector2<>(-1, -1);
            }
            if(getDistSqr(tr, pos) <= radiusSqr) {
                // Bounce up and right
                return new Vector2<>(1, -1);
            }
            if(getDistSqr(bl, pos) <= radiusSqr) {
                // Bounce down and left
                return new Vector2<>(-1, 1);
            }
            if(getDistSqr(br, pos) <= radiusSqr) {
                // Bounce down and right
                return new Vector2<>(1, 1);
            }

            // No bounce force
            return new Vector2<>(0, 0);

    }
}
