package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;

public abstract class Obstacle extends GameObject {

    protected boolean deadly;
    protected boolean offScreen;
    private Point outerBounds;
    private Collider collider;
    protected Point obstacleDims;

    public boolean isDeadly() {
        return deadly;
    }

    public Obstacle(double xPos, double yPos, Point obstacleDims, Point outerBounds) {
        super(xPos, yPos);
        offScreen = false;
        this.obstacleDims = obstacleDims;
        this.outerBounds = outerBounds;
        // TODO: Init a new collider
    }

    public Collider.Face checkCollision(Ball b) {
        return collider.checkBallCollision(b);
    }

    // updates pos from phy to be -vY
    public void applyPhysics(PhysicsState phys) {
        pos = phys.obstacleUpdatePos(pos);
        if (pos.y < outerBounds.y) offScreen = false;
        else offScreen = true;
    }

    public boolean offScreen () {
        return offScreen;
    }

    public Point getDims () {
        return obstacleDims;
    }
}
