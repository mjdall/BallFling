package obstacles;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import physics.StatusAffect;

public class Ice extends RectObstacle {
    private Paint icePaint;

    public Ice (double xPos, double yPos, Point obstacleDims) {
        super(xPos, yPos, obstacleDims, false, Color.YELLOW);
        icePaint = new Paint();
        icePaint.setColor(0xFF7FFFFF);
    }

    public Ice (double xPos, double yPos, Point obstacleDims, int colour) {
        super(xPos, yPos, obstacleDims, false, Color.YELLOW);
        icePaint = new Paint();
        icePaint.setColor(colour);
    }

    @Override
    public StatusAffect getStatusAffect() {
        return StatusAffect.ICE;
    }

    @Override
    public void drawShadow(Canvas c) {
        double x = pos.x;
        double y = pos.y;
        if (y + obstacleDims.y < 0) return;
        c.drawRect((float) x, (float) y, (float) x + obstacleDims.x, (float) y + obstacleDims.y, icePaint);
    }

    @Override
    public void draw(Canvas c) {
        // Draws exclusively on shadow pass
    }
}
