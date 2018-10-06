package obstacles;

import android.graphics.Color;
import android.graphics.Point;

public class Wall extends RectObstacle {

    public Wall (double xPos, double yPos, Point obstacleDims) {
        super(xPos, yPos, obstacleDims, false, Color.GRAY);
    }

    public Wall (double xPos, double yPos, Point obstacleDims, int colour) {
        super(xPos, yPos, obstacleDims, false, colour);
    }

}
