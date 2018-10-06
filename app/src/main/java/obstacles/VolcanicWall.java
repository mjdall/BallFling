package obstacles;

import android.graphics.Canvas;
import android.graphics.Point;

import obstacles.Wall;

public class VolcanicWall extends Wall {
    public VolcanicWall(double xPos, double yPos, Point obstacleDims) {
        super(xPos, yPos, obstacleDims, 0xFF310600);
    }

    @Override
    public void drawShadow(Canvas c) {
        // No shadow
    }
}
