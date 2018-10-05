package tracksegments;

import android.graphics.Point;

import obstacles.Wall;
import obstacles.Water;

public class WaterBridge extends TrackBlueprint {
    protected final int wallWidth = 50;
    private boolean walls;

    public WaterBridge (Point screenDims) {
        super(screenDims, 2000);
        this.walls = true;
    }

    protected WaterBridge (Point screenDims, boolean walls) {
        super(screenDims, 2000);
        this.walls = walls;
    }

    @Override
    protected void setObs () {
        Point waterWidth = new Point (thirdConstants.x - wallWidth, height);
        Water wa1 = new Water(0.0, 0.0, waterWidth);
        Water wa2 = new Water(thirdConstants.x * 2 + wallWidth, 0.0, waterWidth);
        addToObs(wa1, LOW_PRIORITY);
        addToObs(wa2, LOW_PRIORITY);
        if(walls) {
            Wall wall1 = new Wall((double) waterWidth.x - wallWidth / 2, 0.0, new Point(wallWidth, height));
            Wall wall2 = new Wall((double) thirdConstants.x * 2 + wallWidth / 2, 0.0, new Point(wallWidth, height));
            addToObs(wall1, MED_PRIORITY);
            addToObs(wall2, MED_PRIORITY);
        }
    }

}
