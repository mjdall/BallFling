package name.small.ballflinggame;

import android.graphics.Canvas;


public abstract class GameObject {

    protected Vector2<Double> pos;

    public GameObject(double xPos, double yPos) {
        this.pos = new Vector2<>(xPos, yPos);
    }

    public Vector2<Double> getPos() {
        return pos;
    }

    public void setPos(Vector2<Double> pos) {
        this.pos = pos;
    }

    public abstract void applyPhysics(PhysicsState phys);

    public abstract void draw(Canvas c);
}
