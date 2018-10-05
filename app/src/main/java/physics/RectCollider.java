package physics;

import android.util.Log;

import name.small.ballflinggame.Ball;
import name.small.ballflinggame.Vector2;

public class RectCollider implements Collider {

    private Vector2<Double> tl, tr, bl, br;

    private static double getDistSqr(Vector2<Double> p1, Vector2<Double> p2) {
        double dX = p1.x - p2.x;
        double dY = p1.y - p2.y;
        return dX*dX + dY*dY;
    }

    public RectCollider(double x, double y, double w, double h) {
        /*
        if(w <= 0 || h <= 0)
            throw new IllegalArgumentException("Dimensions must be >= 0");
            */
        tl = new Vector2<>(x,y);
        tr = new Vector2<>(x+w,y);
        bl = new Vector2<>(x,y+h);
        br = new Vector2<>(x+w,y+h);
    }

    public void updatePosition(double x, double y, double w, double h) {
        tl.x = x  ; tl.y = y  ;
        tr.x = x+w; tr.y = y  ;
        bl.x = x  ; bl.y = y+h;
        br.x = x+w; br.y = y+h;
    }

    @Override
    public CollisionType checkBallCollision(Ball b) {

        Vector2<Double> pos = b.getPos();
        double radius = b.getRadius();
        double radiusSqr = radius*radius;
        double minX = tl.x;
        double maxX = tr.x;
        double minY = tl.y;
        double maxY = bl.y;

        // Completely inside rectangle
        if(pos.x >= minX && pos.x <= maxX && pos.y >= minY && pos.y <= maxY) {
            Log.d("202", "Internal collision");
            return CollisionType.Internal;
        }

        // If the ball is touching the top or bottom
        if(pos.x >= minX && pos.x <= maxX) {
            if(Math.abs(pos.y - minY) <= radius || Math.abs(pos.y - maxY) <= radius) {
                Log.d("202", "Top collision");
                return CollisionType.Side;
            }
        }

        // If the ball is touching left or right side
        if(pos.y >= minY && pos.y <= maxY) {
            if(Math.abs(pos.x - minX) <= radius || Math.abs(pos.x - maxX) <= radius) {
                Log.d("202", "Side collision");
                return CollisionType.Side;
            }
        }

        // If one of the corners are inside the ball
        if(getDistSqr(tl, pos) <= radiusSqr
                || getDistSqr(tr, pos) <= radiusSqr
                || getDistSqr(bl, pos) <= radiusSqr
                || getDistSqr(br, pos) <= radiusSqr) {
            Log.d("202", "Corner collision");
            return CollisionType.Side;
        }

        return CollisionType.None;
    }

    @Override
    public boolean supportsBounce() {
        return true;
    }

    private double getXPos(double y, double m, double c) {
        return  (y-c)/m;
    }

    private double getYPos(double x, double m, double c) {
        return m*x + c;
    }

    private Vector2<Double> findCollisionPoint(Vector2<Double> pos, Vector2<Double> vel) {

        double m = vel.y/vel.x;
        double c = (-m*pos.x)+pos.y;

        Vector2<Double> corner;
        if(vel.x >= 0 && vel.y >= 0) {
            // Right and down - from top left
            corner = tl;
        } else if (vel.x >= 0 && vel.y <= 0) {
            // Right and up - from bottom left
            corner = bl;
        } else if (vel.x <= 0 && vel.y >= 0) {
            // Left and down - from top right
            corner = tr;
        } else if (vel.x <= 0 && vel.y <= 0) {
            // Left and up - from bottom right
            corner = br;
        } else {
            throw new RuntimeException("Bad state encountered");
        }

        double xInt = getXPos(corner.y, m, c);
        double yInt = getYPos(corner.x, m, c);
        if(xInt > tl.x && xInt < tr.x)
            return new Vector2<>(xInt, corner.y); // Hit the top/bottom
        else if(yInt > tl.y && yInt < bl.y)
            return new Vector2<>(corner.x, yInt); // Hit the side
        else
            return new Vector2<>(corner.x, corner.y); // Hit the corner exactly
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

        // If the ball is touching the top or bottom
        if(pos.x >= tl.x && pos.x <= tr.x) {
            if(Math.abs(pos.y - tl.y) <= radius) {
                return new Vector2<>(0, -1);
            } else if(Math.abs(pos.y - bl.y) <= radius) {
                return new Vector2<>(0, 1);
            }
            return new Vector2<>(0, 0);
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
