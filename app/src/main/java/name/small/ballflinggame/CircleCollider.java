package name.small.ballflinggame;

public class CircleCollider implements Collider {

    private Vector2<Double> pos;
    private double radius;

    public CircleCollider(Vector2<Double> pos, double radius) {
        this.pos = pos;
        this.radius = radius;
    }

    @Override
    public Face checkBallCollision(Ball b) {
        Vector2<Double> ballPos = b.getPos();
        double ballRadius = b.getRadius();
        double dX = pos.x - ballPos.x;
        double dY = pos.y - ballPos.y;
        double distSqr = dX*dX + dY*dY;
        double minDist = (radius + ballRadius);
        if(distSqr > minDist*minDist) {
            return Face.None;
        }

        // TODO make more robust
        return Face.Down;
    }
}
