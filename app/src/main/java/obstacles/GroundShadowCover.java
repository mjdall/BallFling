package obstacles;

import android.graphics.Canvas;
import android.graphics.Point;

public class GroundShadowCover extends GroundShadow {
    public GroundShadowCover (double xPos, double yPos, Point obstacleDims) {
        super(xPos, yPos, obstacleDims);
    }

    @Override
    public void drawShadow (Canvas canvas) {
        double x = pos.x;
        double y = pos.y;
        if (y + obstacleDims.y < 0) return;
        canvas.drawRect((float) x, (float) y, (float) x + obstacleDims.x, (float) y + obstacleDims.y, p);
    }
}
