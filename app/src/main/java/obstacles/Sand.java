package obstacles;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import physics.StatusAffect;

public class Sand extends RectObstacle {
    private Paint sandPaint;

    public Sand (double xPos, double yPos, Point obstacleDims) {
        super(xPos, yPos, obstacleDims, false, Color.YELLOW);
        sandPaint = new Paint();
        sandPaint.setColor(Color.YELLOW);
    }

    @Override
    public StatusAffect getStatusAffect() {
        return StatusAffect.SAND;
    }

    @Override
    public void drawShadow(Canvas c) {
        double x = pos.x;
        double y = pos.y;
        if (y + obstacleDims.y < 0) return;
        c.drawRect((float) x, (float) y, (float) x + obstacleDims.x, (float) y + obstacleDims.y, sandPaint);
    }

    @Override
    public void draw(Canvas c) {
        // Draws exclusively on shadow pass
    }
}
