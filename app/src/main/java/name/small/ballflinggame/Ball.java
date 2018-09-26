package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Ball extends GameObject {

    private double radius;
    private Paint colour;

    public Ball(double x, double y, double radius, Paint colour) {
        super(x, y);
        this.radius = radius;
        this.colour = colour;
    }


    public void draw(Canvas c) {
        c.drawCircle((float)super.xPos, (float)super.yPos, (float)this.radius, this.colour);
    }
}
