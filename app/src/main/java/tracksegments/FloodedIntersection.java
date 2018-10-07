package tracksegments;

import android.graphics.Point;

import obstacles.Rock;
import obstacles.Wall;
import obstacles.Water;

public class FloodedIntersection extends TrackBlueprint {

    public FloodedIntersection (Point screenDims) {
        super(screenDims, 1000, false);
    }

    protected void setObs () {
        int waterWidth = 150;
        int waterRockSize = 130;
        int wallSize = thirdConstants.x - 25;
        Wall topL = new Wall(0.0, 0.0, new Point(wallSize, thirdConstants.y));
        Wall topR = new Wall(thirdConstants.x * 2 + 25, 0.0, new Point(wallSize, thirdConstants.y));
        Wall bottomL = new Wall(0.0, height - thirdConstants.y, new Point(wallSize, thirdConstants.y));
        Wall bottomR = new Wall(thirdConstants.x * 2 + 25, height - thirdConstants.y, new Point(wallSize, thirdConstants.y));
        Water left = new Water(0.0, thirdConstants.y, new Point(waterWidth, thirdConstants.y));
        Water right = new Water(width - waterWidth, thirdConstants.y, new Point(waterWidth, thirdConstants.y));
        Rock middle = new Rock (halfConstants.x - waterRockSize / 2, halfConstants.y - waterRockSize / 2, new Point(waterRockSize, waterRockSize));
        addToObs(topL, HIGH_PRIORITY);
        addToObs(topR, HIGH_PRIORITY);
        addToObs(bottomL, HIGH_PRIORITY);
        addToObs(bottomR, HIGH_PRIORITY);
        addToObs(left, MED_PRIORITY);
        addToObs(right, MED_PRIORITY);
        addToObs(middle, HIGH_PRIORITY);
    }


}
