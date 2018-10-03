package name.small.ballflinggame;

import android.graphics.Point;

public class WaterBridge extends TrackBlueprint {
    private final int wallWidth = 50;

    public WaterBridge (Point screenDims) {
        super(screenDims, 2000);
    }

    @Override
    protected void setObs () {
        Point waterWidth = new Point (thirdConstants.x - wallWidth, height);
        Water wa1 = new Water(0.0, 0.0, waterWidth);
        Water wa2 = new Water(thirdConstants.x * 2 + wallWidth, 0.0, waterWidth);
        Wall wall1 = new Wall((double) waterWidth.x, 0.0, new Point(wallWidth, height));
        Wall wall2 = new Wall((double) thirdConstants.x * 2, 0.0, new Point(wallWidth, height));
        addToObs(wa1);
        addToObs(wa2);
        addToObs(wall1);
        addToObs(wall2);
    }

}
