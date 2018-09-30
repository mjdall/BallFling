package name.small.ballflinggame;

public class CircleCollider implements Collider {

    private Vector2<Double> pos;
    private double radius;

    public CircleCollider(Vector2<Double> pos, double radius) {
        this.pos = pos;
        this.radius = radius;
    }

    @Override
    public boolean checkBallCollision(Ball b) {
        Vector2<Double> ballPos = b.getPos();
        double ballRadius = b.getRadius();
        double dX = pos.x - ballPos.x;
        double dY = pos.y - ballPos.y;
        double minDist = (radius + ballRadius);
        return dX*dX + dY*dY <= minDist*minDist;
    }

    @Override
    public boolean supportsBounce() {
        return false;
    }

    @Override
    public Vector2<Integer> getBounceDir(Ball b, PhysicsState phys) {
        throw new UnsupportedOperationException("Circle colliders do not support bounces");
    }
}
