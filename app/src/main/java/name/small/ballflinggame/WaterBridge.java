package name.small.ballflinggame;

import android.graphics.Point;

public class WaterBridge extends TrackBlueprint {
    protected final int wallWidth = 50;

    public WaterBridge (Point screenDims) {
        super(screenDims, 2000);
    }

    @Override
    protected void setObs () {
        Point waterWidth = new Point (thirdConstants.x - wallWidth, height);
        Water wa1 = new Water(0.0, 0.0, waterWidth);
        Water wa2 = new Water(thirdConstants.x * 2 + wallWidth, 0.0, waterWidth);
        Wall wall1 = new Wall((double) waterWidth.x - wallWidth / 2, 0.0, new Point(wallWidth, height));
        Wall wall2 = new Wall((double) thirdConstants.x * 2 + wallWidth / 2, 0.0, new Point(wallWidth, height));
        addToObs(wa1, LOW_PRIORITY);
        addToObs(wa2, LOW_PRIORITY);
        addToObs(wall1, MED_PRIORITY);
        addToObs(wall2, MED_PRIORITY);
    }

}
