package tracksegments;

import android.graphics.Point;

import java.util.Random;

import obstacles.Obstacle;
import obstacles.Water;

public class BrokenBridge extends WaterBridge {

    public BrokenBridge (Point screenDims) {
        super(screenDims, true);
    }

    @Override
    protected void setObs () {
        super.setObs();
        Random rand = new Random();
        Point waterWidth = new Point (thirdConstants.x - wallWidth, height);
        Obstacle brokenBridgeW1 = new Water( waterWidth.x,
                rand.nextInt(halfConstants.y - sixthConstants.y),
                new Point(sixthConstants.x, sixthConstants.x));
        Obstacle brokenBridgeW2 = new Water( thirdConstants.x * 2 - sixthConstants.x + wallWidth,
                height - rand.nextInt(halfConstants.y + sixthConstants.y),
                new Point(sixthConstants.x, sixthConstants.x));
        addToObs(brokenBridgeW1, LOW_PRIORITY - 1); // Draw under outer water
        addToObs(brokenBridgeW2, LOW_PRIORITY - 1);
    }
}
