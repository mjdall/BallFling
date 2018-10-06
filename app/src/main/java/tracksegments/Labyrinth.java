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
        addToObs(sideWallLeft, MED_PRIORITY + 5);
        addToObs(sideWallRight, MED_PRIORITY + 5);

        Point exitDim = new Point(eigthConstants.x * 3, fifteenthConst.y);
        Obstacle topLExit = new Wall(0.0, 0.0, exitDim);
        Obstacle topRExit = new Wall(width - exitDim.x, 0.0, exitDim);
        addToObs(topLExit, MED_PRIORITY + 5);
        addToObs(topRExit, MED_PRIORITY + 5);

        Point endWaterTrapDims = new Point(halfConstants.x, fifteenthConst.y * 2);
        Obstacle endWaterTrap = new Water(fourthConstants.x, fifteenthConst.y * 2, endWaterTrapDims);
        addToObs(endWaterTrap, LOW_PRIORITY);

        Point exitLongGrassDims = new Point(width, fifteenthConst.y * 2);
        Obstacle exitLongGrass = new LongGrass(0.0, fifteenthConst.y, exitLongGrassDims);
        addToObs(exitLongGrass, LOW_PRIORITY - 1);

        Point dividerDims = new Point(eigthConstants.x / 2, fifteenthConst.y * 9);
        Point dividerLeftTopDims = new Point( eigthConstants.x / 2,fifteenthConst.y * 3 + fifteenthConst.y / 4);
        Point dividerLeftBottomDims = new Point(eigthConstants.x / 2, fifteenthConst.y / 4 + fifteenthConst.y * 5);
        Obstacle dividerLeftTop = new Wall(eigthConstants.x * 3, fifteenthConst.y * 3, dividerLeftTopDims);
        Obstacle dividerLeftBottom = new Wall(eigthConstants.x * 3, fifteenthConst.y * 6 + (fifteenthConst.y * 3 / 4), dividerLeftBottomDims);
        Obstacle dividerRight = new Wall(eigthConstants.x * 5 - dividerDims.x , fifteenthConst.y * 3, dividerDims);
        addToObs(dividerLeftTop,MED_PRIORITY + 4);
        addToObs(dividerLeftBottom,MED_PRIORITY + 4);
        addToObs(dividerRight, MED_PRIORITY + 4);

        Point largeBelowWaterDims = new Point(eigthConstants.x, fifteenthConst.y * 2);
        Obstacle largeBelowWater = new Wall(eigthConstants.x * 2, fifteenthConst.y * 4, largeBelowWaterDims);
        addToObs(largeBelowWater, MED_PRIORITY + 3);

        Point waterMiddleLeakDims = new Point(sixthConstants.x * 2, fifteenthConst.y);
        Obstacle waterMiddleLeak = new Water(eigthConstants.x * 2, fifteenthConst.y * 6, waterMiddleLeakDims);
        addToObs(waterMiddleLeak, LOW_PRIORITY);

        Point zigZagDims = new Point(fifteenthConst.x * 3, fifteenthConst.y);
        Obstacle leftZigZagTopRight = new Wall(eigthConstants.x * 2 - fifteenthConst.x, fifteenthConst.y * 7, zigZagDims);
        Obstacle leftZigZagMiddleLeft = new Wall(sideWallDims.x, fifteenthConst.y * 9, zigZagDims);
        addToObs(leftZigZagTopRight, MED_PRIORITY + 2);
        addToObs(leftZigZagMiddleLeft, MED_PRIORITY + 2);

        Point largeZigZagDims = new Point(fifteenthConst.x * 3, fifteenthConst.y * 2);
        Obstacle rightZigZagTopLeft = new Wall(eigthConstants.x * 5, fifteenthConst.y * 5, zigZagDims);
        Obstacle rightZigZagMiddleRight = new Wall(eigthConstants.x * 6, fifteenthConst.y * 7, largeZigZagDims);
        addToObs(rightZigZagTopLeft, MED_PRIORITY + 2);
        addToObs(rightZigZagMiddleRight, MED_PRIORITY + 2);

        Point smallBelowWaterDims = new Point(eigthConstants.x, fifteenthConst.y);
        Obstacle smallBelowWater = new Wall(eigthConstants.x * 5, fifteenthConst.y * 4, smallBelowWaterDims);
        addToObs(smallBelowWater, MED_PRIORITY + 1);

        Point sandPitLeftDims = new Point(eigthConstants.x, fifteenthConst.y * 2);
        Obstacle sandPitLeft = new Wall(eigthConstants.x * 2, fifteenthConst.y * 11, sandPitLeftDims);
        addToObs(sandPitLeft, MED_PRIORITY);

        Point sandPitRightDims = new Point(eigthConstants.x, fifteenthConst.y * 3);
        Obstacle sandPitRight = new Wall(eigthConstants.x * 5, fifteenthConst.y * 10, sandPitRightDims);
        addToObs(sandPitRight, MED_PRIORITY);

        Point longGrassEntryDims = new Point(halfConstants.x, fifteenthConst.y * 2);
        Obstacle longGrassEntry = new LongGrass(fourthConstants.x, fifteenthConst.y * 12, longGrassEntryDims);
        addToObs(longGrassEntry, LOW_PRIORITY);

        Point middleWaterDims = new Point(eigthConstants.x * 2, fifteenthConst.y * 9 + fifteenthConst.y / 4);
        Obstacle middleWater = new Water(halfConstants.x - eigthConstants.x, fifteenthConst.y * 3, middleWaterDims);
        addToObs(middleWater, LOW_PRIORITY + 1);
    }
}
