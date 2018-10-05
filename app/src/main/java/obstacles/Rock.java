package obstacles;

import android.graphics.Canvas;
import android.graphics.Point;

public class Rock extends Wall {
    public Rock (double xPos, double yPos, Point obstacleDims) {
        super(xPos, yPos, obstacleDims);
    }

    @Override
    public void drawShadow (Canvas canvas) {
        // rocks are shadowless walls
    }
}
