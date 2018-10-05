package tracksegments;

import android.graphics.Point;

import obstacles.Obstacle;
import obstacles.Wall;

public class CastleKeep extends CastleWalls {
    public CastleKeep(Point screenDimensions) {
        super(screenDimensions, false);
    }

    @Override
    void setObs() {
        super.setObs();

        // Add keep to centre of castle
        Point keepDims = new Point(thirdConstants.x, castleWallWidth*2);
        Obstacle keep = new Wall(thirdConstants.x, moatHeight + 2*castleWallWidth, keepDims);

        addToObs(keep, MED_PRIORITY);
    }
}
