package obstacles;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

public class Water extends RectObstacle {
    private Paint innerPaint;

    public Water(double xPos, double yPos, Point obstacleDims) {
        // Translucent surface with base shadow colour
        super(xPos, yPos, obstacleDims, true, 0);
        innerPaint = new Paint();
        innerPaint.setColor(Color.CYAN);
    }

    @Override
    public void drawShadow(Canvas c) {
        double x = pos.x;
        double y = pos.y;
        if (y + obstacleDims.y < 0) return;
        c.drawRect((float) x, (float) y, (float) x + obstacleDims.x, (float) y + obstacleDims.y, innerPaint);
    }

    @Override
    public void draw(Canvas c) {
        // Draws exclusively on shadow pass
    }
}
