package tracksegments;

import android.graphics.Point;

import obstacles.Obstacle;
import obstacles.Rock;

public class PinCastle extends CastleWalls {
    public PinCastle(Point screenDimensions) {
        super(screenDimensions, false, false);
        super.castleWallWidth = eigthConstants.x/2;
    }

    @Override
    void setObs() {
        super.setObs();

        int areaOff = castleWallWidth + castleWallWidth/4;
        int areaSize = width - castleWallWidth*2 - castleWallWidth/2;
        int gridSize = areaSize / 9;

        int numGrid = areaSize / gridSize;

        int squareDim = gridSize / 4;

        // Wide rows
        for(int x = 0; x < numGrid; x+=2) {
            for(int y = 0; y < numGrid; y+=2) {
                int xOff = gridSize /2;
                int yOff = gridSize/2;
                Obstacle pin = new Rock((x*gridSize) + xOff + areaOff, (y*gridSize) + yOff + areaOff, new Point(squareDim, squareDim));
                addToObs(pin, HIGH_PRIORITY);
            }
        }

        for(int x = 1; x < numGrid; x+=2) {
            for(int y = 1; y < numGrid; y+=2) {
                int xOff = gridSize /2;
                int yOff = gridSize/2;
                Obstacle pin = new Rock((x*gridSize) + xOff + areaOff, (y*gridSize) + yOff + areaOff, new Point(squareDim, squareDim));
                addToObs(pin, HIGH_PRIORITY);
            }
        }
    }
}
