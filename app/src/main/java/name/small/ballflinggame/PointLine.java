package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;

public class PointLine extends Obstacle {

    private boolean flicked;
    private double pointLineHeight = 100;
    private Paint p;
    private boolean downScreen = false;

    // TODO: Implement object dims being set on creation of this method so we know it's set
    public PointLine (double xPos, double yPos, Point obstacleDims, Point outerBounds) {
        super(xPos, yPos, obstacleDims, outerBounds);
        flicked = false;
        deadly = false;
        offScreen = false;
        p = new Paint();
        p.setColor(Color.CYAN);
    }

    @Override
    public void draw (Canvas c) {
        double x = pos.x;
        double y = pos.y;
        c.drawRect((float) x, (float) y, (float) x + obstacleDims.x, (float) (y + pointLineHeight), p);
    }

    @Override
    public void applyPhysics (PhysicsState physics) {
        flicked = physics.isFlicked();
        if (!flicked && !downScreen) {
            if (pos.y < 0) { pos = physics.obstacleUpdatePos(pos); pos.y = pos.y > 0.0 ? 0.0 : pos.y; }
            return;
        }
        downScreen = true;
        pos = physics.obstacleUpdatePos(pos);
        if (pos.y > outerBounds.y) { pos.y = -pointLineHeight; if (!flicked) downScreen = false; }
    }

    private void resetPos () {
        pos.x = 0.0;
        pos.y = -pointLineHeight;
    }
}
