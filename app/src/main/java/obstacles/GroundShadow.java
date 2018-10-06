package obstacles;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import name.small.ballflinggame.Ball;
import physics.Collider;

public class GroundShadow extends RectObstacle {

    public GroundShadow (double xPos, double yPos, Point obstacleDims) {
        super(xPos, yPos, obstacleDims, false, 101902 | 0xFF000000);
    }

    @Override
    public Collider.CollisionType checkCollision(Ball b) {
        return Collider.CollisionType.None;
    }

    @Override
    public void draw (Canvas canvas) {
        // dont need to draw
    }

    @Override
    public void drawShadow (Canvas canvas) {
        super.drawShadow(canvas);
        double x = pos.x;
        double y = pos.y;
        if (y + obstacleDims.y < 0) return;
        canvas.drawRect((float) x, (float) y, (float) x + obstacleDims.x, (float) y + obstacleDims.y, p);
    }

}
