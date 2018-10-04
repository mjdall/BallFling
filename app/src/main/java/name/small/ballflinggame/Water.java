package name.small.ballflinggame;

import android.graphics.Color;
import android.graphics.Point;

public class Water extends RectObstacle {

    public Water (double xPos, double yPos, Point obstacleDims) {
        super(xPos, yPos, obstacleDims, true, Color.CYAN);
    }

    public Water (double xPos, double yPos, Point obstacleDims, boolean shadowOff) {
        super(xPos, yPos, obstacleDims, true, Color.CYAN, shadowOff);
    }

}
