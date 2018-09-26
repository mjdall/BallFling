package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ball extends GameObject {

    private double radius;
    private Paint paint;

    public Ball(double x, double y, double radius, int colour) {
        super(x, y);
        this.radius = radius;
        this.paint = new Paint();
        this.paint.setColor(colour);
    }


    public void draw(Canvas c) {
        c.drawCircle((float)super.xPos, (float)super.yPos, (float)this.radius, this.paint);
    }
}
