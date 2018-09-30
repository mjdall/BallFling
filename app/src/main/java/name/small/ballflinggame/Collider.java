package name.small.ballflinggame;

public interface Collider {

    boolean checkBallCollision(Ball b);

    boolean supportsBounce();

    // Returns Vector2 containing -1, 0 or 1
    // where -1 means that ball bounces left/up for that component of vel vector
    // 0 means bounce does not affect that component
    // 1 means the ball bounces right/down for that component
    Vector2<Integer> getBounceDir(Ball b, PhysicsState phys);
}
