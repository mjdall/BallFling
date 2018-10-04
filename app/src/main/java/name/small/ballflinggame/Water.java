package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

public class Water extends RectObstacle {
    private Paint shadowPaint;
    private Paint innerPaint;
    private Paint sandPaint;

    public Water(double xPos, double yPos, Point obstacleDims) {
        // Translucent surface with base shadow colour
        super(xPos, yPos, obstacleDims, true, 0);
        shadowPaint = new Paint();
        shadowPaint.setColor(Color.BLACK & 0x3FFFFFFF);
        innerPaint = new Paint();
        innerPaint.setColor(Color.CYAN);
        sandPaint = new Paint();
        sandPaint.setColor(Color.YELLOW);
    }

    @Override
    public void drawShadow(Canvas c) {
        double x = pos.x;
        double y = pos.y;
        if (y + obstacleDims.y < 0) return;
        c.drawRect((float) x - 5, (float) y - 5, (float) x + obstacleDims.x + 5, (float) y + obstacleDims.y + 5, sandPaint);
        c.drawRect((float) x-1, (float) y-1, (float) x + obstacleDims.x+1, (float) y + obstacleDims.y+1, shadowPaint);
        c.drawRect((float) x+2, (float) y+2, (float) x + obstacleDims.x-2, (float) y + obstacleDims.y-2, innerPaint);
    }

    @Override
    public void draw(Canvas c) {
        // Draws exclusively on shadow pass
    }
}
