package tracksegments;

import android.graphics.Point;

import obstacles.Obstacle;
import obstacles.Sand;
import obstacles.Wall;
import obstacles.Water;

public class CastleWalls extends TrackBlueprint {

    protected double rightOfEntry;
    protected int castleWallWidth;
    protected int moatHeight;


    public CastleWalls(Point screenDimensions) {
        super(screenDimensions, screenDimensions.x + screenDimensions.x/2, true);
    }

    protected CastleWalls(Point screenDimensions, boolean allowInitialSpawn) {
        super(screenDimensions, screenDimensions.x + screenDimensions.x/2, allowInitialSpawn);
    }

    @Override
    void setObs() {

        rightOfEntry = halfConstants.x + sixthConstants.x/2;
        Point moatDims = new Point(halfConstants.x - sixthConstants.x/2, (sixthConstants.y * 3) / 4);
        Point sandDims = new Point(halfConstants.x - sixthConstants.x/2, sixthConstants.y / 4);

        Obstacle moatLeft = new Water(0.0,height - sixthConstants.y, moatDims);
        Obstacle moatRight = new Water(rightOfEntry,height - sixthConstants.y, moatDims);
        Obstacle sandLeft = new Sand(0.0,height - sandDims.y, sandDims);
        Obstacle sandRight = new Sand(rightOfEntry,height - sandDims.y, sandDims);

        addToObs(moatLeft, LOW_PRIORITY);
        addToObs(moatRight, LOW_PRIORITY);
        addToObs(sandLeft, LOW_PRIORITY);
        addToObs(sandRight, LOW_PRIORITY);

        Obstacle moatExitLeft = new Water(0.0, sandDims.y, moatDims);
        Obstacle moatExitRight = new Water(rightOfEntry, sandDims.y, moatDims);
        Obstacle sandExitLeft = new Sand(0.0, 0.0, sandDims);
        Obstacle sandExitRight = new Sand(rightOfEntry, 0.0, sandDims);


        addToObs(moatExitLeft, LOW_PRIORITY);
        addToObs(moatExitRight, LOW_PRIORITY);
        addToObs(sandExitLeft, LOW_PRIORITY);
        addToObs(sandExitRight, LOW_PRIORITY);


        castleWallWidth = sixthConstants.x;
        moatHeight = sixthConstants.y;
        Point gateDims = new Point(halfConstants.x - sixthConstants.x/2, castleWallWidth);

        Obstacle gateLeft = new Wall(0.0,height - moatHeight - castleWallWidth, gateDims);
        Obstacle gateRight = new Wall(rightOfEntry,height - moatHeight - castleWallWidth, gateDims);

        addToObs(gateLeft, MED_PRIORITY);
        addToObs(gateRight, MED_PRIORITY);

        Point wallDims = new Point(castleWallWidth, thirdConstants.y + castleWallWidth*2);

        Obstacle wallLeft = new Wall(0.0, moatHeight + castleWallWidth, wallDims);
        Obstacle wallRight = new Wall(width - castleWallWidth, moatHeight + castleWallWidth, wallDims);

        addToObs(wallLeft, MED_PRIORITY+1);
        addToObs(wallRight, MED_PRIORITY+1);

        Obstacle gateExitLeft = new Wall(0.0, moatHeight, gateDims);
        Obstacle gateExitRight = new Wall(rightOfEntry, moatHeight, gateDims);

        addToObs(gateExitLeft, MED_PRIORITY + 2);
        addToObs(gateExitRight, MED_PRIORITY + 2);
    }
}
