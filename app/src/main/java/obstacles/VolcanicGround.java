package obstacles;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import physics.StatusAffect;

public class VolcanicGround extends RectObstacle {

    Paint p;

    public VolcanicGround(double xPos, double yPos, Point obstacleDims) {
        super(xPos, yPos, obstacleDims, false, 0);
        p = new Paint();
        p.setColor(0xFF710600);
    }

    @Override
    public StatusAffect getStatusAffect() {
        return StatusAffect.VOLCANIC;
    }

    @Override
    public void drawShadow(Canvas c) {
        double x = pos.x;
        double y = pos.y;
        if (y + obstacleDims.y < 0) return;
        c.drawRect((float) x, (float) y, (float) x + obstacleDims.x, (float) y + obstacleDims.y, p);
    }

    @Override
    public void draw(Canvas c) {
        // Draws exclusively on shadow pass
    }
}
