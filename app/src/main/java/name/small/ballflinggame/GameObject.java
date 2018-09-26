package name.small.ballflinggame;

import android.graphics.Canvas;


public abstract class GameObject {

    private double xPos;
    private double yPos;

    public GameObject(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void applyPhysics(/*Physics object*/) {
        /* Update positions */
    }


    public abstract void draw(Canvas c);
}
