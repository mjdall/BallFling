package obstacles;

import android.graphics.Point;

public class Lava extends Water {
    public Lava(double xPos, double yPos, Point obstacleDims) {
        super(xPos, yPos, obstacleDims, 0xFFCF1020);
    }
}
