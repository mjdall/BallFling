package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.constraint.solver.widgets.Rectangle;
import android.util.Log;

import java.util.Random;

public abstract class RectObstacle extends Obstacle {
    private Paint p;
    private Paint shadow;


    // TODO:
    public RectObstacle (double xPos, double yPos, Point obstacleDims, boolean deadly, int colour) {
        super(xPos, yPos, obstacleDims, deadly, new RectCollider(xPos, yPos, obstacleDims.x, obstacleDims.y));
        p = new Paint();
        p.setColor(colour);
        shadow = new Paint();
        shadow.setColor(Color.BLACK & 0x8FFFFFFF);
    }

    @Override
    public void updatePos(Vector2<Double> newPos) {
        pos = newPos;
        ((RectCollider)collider).updatePosition(pos.x, pos.y, obstacleDims.x, obstacleDims.y);
    }


    @Override
    public void drawShadow(Canvas c) {
        double x = pos.x;
        double y = pos.y;
        if (y + obstacleDims.y < 0) return;
        c.drawRect((float) (x+10), (float) (y-10), (float) x+10 + obstacleDims.x, (float) (y-10) + obstacleDims.y, shadow);
    }

    @Override
    public void draw (Canvas c) {
        double x = pos.x;
        double y = pos.y;
        if (y + obstacleDims.y < 0) return;
        c.drawRect((float) x, (float) y, (float) x + obstacleDims.x, (float) y + obstacleDims.y, p);
    }
}
