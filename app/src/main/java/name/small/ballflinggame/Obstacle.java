package name.small.ballflinggame;

public abstract class Obstacle extends GameObject {

    private boolean deadly;
    private Collider collider;

    public boolean isDeadly() {
        return deadly;
    }

    public Obstacle(double xPos, double yPos, Collider collider) {
        super(xPos, yPos);
        this.collider = collider;
    }

    public Collider.Face checkCollision(Ball b) {
        return collider.checkBallCollision(b);
    }

    public void applyPhysics(PhysicsState phys) {
        pos = phys.obstacleUpdatePos(pos);
    }
}
