package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class Ball extends GameObject {

    private double radius;
    private Paint paint;

    public double getRadius() {
        return radius;
    }

    public Ball(double x, double y, double radius, int colour) {
        super(x, y);
        this.radius = radius;
        this.paint = new Paint();
        this.paint.setColor(colour);
    }


    @Override
    public void applyPhysics(PhysicsState phys) {
        pos = phys.ballUpdatePos(pos);
    }

    @Override
    public void draw(Canvas c) {
        double x = pos.x;
        double y = pos.y;
        c.drawCircle((float)x, (float)y, (float)this.radius, this.paint);
    }
}
