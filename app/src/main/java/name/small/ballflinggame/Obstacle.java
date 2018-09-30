package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;

public abstract class Obstacle extends GameObject {

    protected boolean deadly;
    protected Point outerBounds;
    protected Collider collider;
    protected Point obstacleDims;

    public boolean isDeadly() {
        return deadly;
    }

    public Obstacle(double xPos, double yPos, Point obstacleDims, Point outerBounds, Collider collider) {
        super(xPos, yPos);
        this.obstacleDims = obstacleDims;
        this.outerBounds = outerBounds;
        this.collider = collider;
    }

    public boolean checkCollision(Ball b) {
        return collider.checkBallCollision(b);
    }

    public abstract void updatePos(Vector2<Double> pos);

    public Vector2<Integer> getBounceDir(Ball b, PhysicsState phys) {
        if(collider.supportsBounce()) {
            return collider.getBounceDir(b, phys);
        }
        return null;
    }

    // updates pos from phy to be -vY
    public void applyPhysics(PhysicsState phys) {
        updatePos(phys.obstacleUpdatePos(pos));
    }

    public boolean offScreen () {
        return pos.y > outerBounds.y;
    }

    public Point getDims () {
        return obstacleDims;
    }
}
