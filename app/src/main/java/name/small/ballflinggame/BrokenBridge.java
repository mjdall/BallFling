package name.small.ballflinggame;

import android.graphics.Point;

import java.util.Random;

public class BrokenBridge extends WaterBridge {

    public BrokenBridge (Point screenDims) {
        super(screenDims);
    }

    @Override
    protected void setObs () {
        super.setObs();
        Random rand = new Random();
        Point waterWidth = new Point (thirdConstants.x - wallWidth, height);
        Sand brokenBridgeW1 = new Sand( waterWidth.x,
                rand.nextInt(halfConstants.y - sixthConstants.y),
                new Point(sixthConstants.x, sixthConstants.x));
        Sand brokenBridgeW2 = new Sand( thirdConstants.x * 2 - sixthConstants.x + wallWidth,
                height - rand.nextInt(halfConstants.y + sixthConstants.y),
                new Point(sixthConstants.x, sixthConstants.x));
        addToObs(brokenBridgeW1, LOW_PRIORITY - 1); // Draw under outer water
        addToObs(brokenBridgeW2, LOW_PRIORITY - 1);
    }
}
