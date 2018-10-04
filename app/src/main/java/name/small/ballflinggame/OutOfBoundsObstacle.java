package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.util.Log;

public class OutOfBoundsObstacle extends RectObstacle {

    private double maxY;

    public OutOfBoundsObstacle (Point screenDims, double maxY) {
        super(0, maxY, screenDims, true, Color.RED & 0x7FFFFFFF);
        this.maxY = maxY;
    }

    @Override
    public void drawShadow(Canvas c) {
        // No shadow
    }

    @Override
    public void updatePos(Vector2<Double> newPos) {
        newPos.x = 0.0; // Ensure x pos is 0
        if(newPos.y > maxY) { // Ensure not past max end of bounds
            newPos.y = maxY;
        }

        Log.d("OUTOFBOUNDS", "Out Of Bounds moving to: " + newPos.y);
        super.updatePos(newPos);
    }
}
