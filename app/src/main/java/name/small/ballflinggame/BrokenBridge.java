package name.small.ballflinggame;

import android.graphics.Point;

import java.util.Random;

public class BrokenBridge extends TrackBlueprint {
    private final int wallWidth = 50;

    public BrokenBridge (Point screenDims) {
        super(screenDims, 2000);
    }

    @Override
    protected void setObs () {
        Random rand = new Random();
        Point waterWidth = new Point (thirdConstants.x - wallWidth, height);
        Water wa1 = new Water(0.0, 0.0, waterWidth);
        Water wa2 = new Water(thirdConstants.x * 2 + wallWidth, 0.0, waterWidth);
        Water brokenBridgeW1 = new Water( waterWidth.x,
                rand.nextInt(halfConstants.y - sixthConstants.y),
                new Point(sixthConstants.x, sixthConstants.x), true);
        Water brokenBridgeW2 = new Water( thirdConstants.x * 2 - sixthConstants.x + wallWidth,
                height - rand.nextInt(halfConstants.y + sixthConstants.y),
                new Point(sixthConstants.x, sixthConstants.x), true);
        Wall wall1 = new Wall(waterWidth.x, 0.0, new Point(wallWidth, height));
        Wall wall2 = new Wall(thirdConstants.x * 2, 0.0, new Point(wallWidth, height));
        addToObs(wa1);
        addToObs(wa2);
        addToObs(wall1);
        addToObs(wall2);
        addToObs(brokenBridgeW1);
        addToObs(brokenBridgeW2);
    }
}
