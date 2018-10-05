package obstacles;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import physics.StatusAffect;

public class LongGrass extends RectObstacle {
    private Paint grassPaint;

    public LongGrass (double xPos, double yPos, Point obstacleDims) {
        super(xPos, yPos, obstacleDims, false, Color.YELLOW);
        grassPaint = new Paint();
        grassPaint.setColor(0xFF007F00);
    }

    @Override
    public StatusAffect getStatusAffect() {
        return StatusAffect.LONG_GRASS;
    }

    @Override
    public void drawShadow(Canvas c) {
        double x = pos.x;
        double y = pos.y;
        if (y + obstacleDims.y < 0) return;
        c.drawRect((float) x, (float) y, (float) x + obstacleDims.x, (float) y + obstacleDims.y, grassPaint);
    }

    @Override
    public void draw(Canvas c) {
        // Draws exclusively on shadow pass
    }
}
