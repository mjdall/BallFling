package name.small.ballflinggame;

public interface Collider {
    enum Face {
        Up,
        Down,
        Left,
        Right,
        None
    }
    Face checkBallCollision(Ball b);
}
