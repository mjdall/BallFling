package tracksegments;

import android.graphics.Point;

import obstacles.LongGrass;
import obstacles.Obstacle;
import obstacles.Wall;
import obstacles.Water;

public class Labyrinth extends  TrackBlueprint {
    protected int wallWidth;
    public Labyrinth (Point screenDims) {
        super(screenDims, screenDims.y, true);
    }

    @Override
    void setObs() {
        Point sideWallDims = new Point(width / 20, height);
        Point fifteenthConst = new Point(width / 15, height / 15);

        Obstacle sideWallLeft = new Wall(0.0, 0.0, sideWallDims);
        Obstacle sideWallRight = new Wall(width - sideWallDims.x, 0.0, sideWallDims);
        addToObs(sideWallLeft, MED_PRIORITY + 3);
        addToObs(sideWallRight, MED_PRIORITY + 3);

        Point exitDim = new Point(eigthConstants.x * 3, fifteenthConst.y);
        Obstacle topLExit = new Wall(0.0, 0.0, exitDim);
        Obstacle topRExit = new Wall(width - exitDim.x, 0.0, exitDim);
        addToObs(topLExit, MED_PRIORITY + 3);
        addToObs(topRExit, MED_PRIORITY + 3);

        Point endWaterTrapDims = new Point(halfConstants.x, fifteenthConst.y * 2);
        Obstacle endWaterTrap = new Water(fourthConstants.x, fifteenthConst.y * 2, endWaterTrapDims);
        addToObs(endWaterTrap, LOW_PRIORITY);

        Point dividerDims = new Point(eigthConstants.x / 2, fifteenthConst.y * 9);
        Obstacle dividerLeft = new Wall(eigthConstants.x * 3, fifteenthConst.y * 3, dividerDims);
        Obstacle dividerRight = new Wall(eigthConstants.x * 5 - dividerDims.x , fifteenthConst.y * 3, dividerDims);
        addToObs(dividerLeft,MED_PRIORITY + 2);
        addToObs(dividerRight, MED_PRIORITY + 2);

        Point largeBelowWaterDims = new Point(eigthConstants.x, fifteenthConst.y * 2);
        Obstacle largeBelowWater = new Wall(eigthConstants.x * 2, fifteenthConst.y * 4, largeBelowWaterDims);
        addToObs(largeBelowWater, MED_PRIORITY + 1);

        Point smallBelowWaterDims = new Point(eigthConstants.x, fifteenthConst.y);
        Obstacle smallBelowWater = new Wall(eigthConstants.x * 5, fifteenthConst.y * 4, smallBelowWaterDims);
        addToObs(smallBelowWater, MED_PRIORITY);

        Point sandPitLeftDims = new Point(eigthConstants.x, fifteenthConst.y * 2);
        Obstacle sandPitLeft = new Wall(eigthConstants.x * 2, fifteenthConst.y * 11, sandPitLeftDims);
        addToObs(sandPitLeft, MED_PRIORITY - 1);

        Point sandPitRightDims = new Point(eigthConstants.x, fifteenthConst.y * 3);
        Obstacle sandPitRight = new Wall(eigthConstants.x * 5, fifteenthConst.y * 10, sandPitRightDims);
        addToObs(sandPitRight, MED_PRIORITY - 1);

        Point longGrassEntryDims = new Point(halfConstants.x, fifteenthConst.y * 2);
        Obstacle longGrassEntry = new LongGrass(fourthConstants.x, fifteenthConst.y * 12, longGrassEntryDims);
        addToObs(longGrassEntry, LOW_PRIORITY);

        Point middleWaterDims = new Point(eigthConstants.x * 2, fifteenthConst.y * 9 + fifteenthConst.y / 4);
        Obstacle middleWater = new Water(halfConstants.x - eigthConstants.x, fifteenthConst.y * 3, middleWaterDims);
        addToObs(middleWater, LOW_PRIORITY + 1);

    }
}
