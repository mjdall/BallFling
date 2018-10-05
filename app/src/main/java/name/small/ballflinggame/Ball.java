package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import physics.PhysicsState;

public class Ball extends GameObject {

    private double radius;
    private Paint paint;
    private Paint shadow;


    public double getRadius() {
        return radius;
    }

    public Ball(double x, double y, double radius, int colour) {
        super(x, y);
        this.radius = radius;
        this.paint = new Paint();
        this.paint.setColor(colour);
        shadow = new Paint();
        shadow.setColor(Color.BLACK & 0x8FFFFFFF);
    }

    @Override
    public void applyPhysics(PhysicsState phys) {
        pos = phys.ballUpdatePos(this);
    }

    @Override
    public void drawShadow(Canvas c) {
        double x = pos.x;
        double y = pos.y;
        c.drawCircle((float)x + 10, (float)y - 10, (float)this.radius, shadow);
    }

    @Override
    public void draw(Canvas c) {
        double x = pos.x;
        double y = pos.y;
        c.drawCircle((float)x, (float)y, (float)this.radius, this.paint);
    }
}
