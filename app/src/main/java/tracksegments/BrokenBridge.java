package tracksegments;

import android.graphics.Point;

import java.util.Random;

import obstacles.Obstacle;
import obstacles.Wall;
import obstacles.Water;

public class BrokenBridge extends WaterBridge {
    Point screenDims;
    public BrokenBridge (Point screenDims) {
        super(screenDims, true, true); height = 3500;
        this.screenDims = screenDims;
    }

    @Override
    protected void setObs () {
        super.setObs();
        Random rand = new Random();
        Point waterWidth = new Point (thirdConstants.x - wallWidth, height);

        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0 && rand.nextBoolean()) {
                int y = i * eigthConstants.y + rand.nextInt(100);
                y = y - 20 < screenDims.y ? i * eigthConstants.y : y;
                y = y + 20> screenDims.y ? i * eigthConstants.y : y;
                Obstacle brokenBridgeW1 = new Water( waterWidth.x,
                        y,
                        new Point(seventhConstants.x, seventhConstants.x));
                addToObs(brokenBridgeW1, LOW_PRIORITY - rand.nextInt(1));
            } else if (rand.nextBoolean()) {
                int y = i * eigthConstants.y + rand.nextInt(100);
                y = y - 20 < screenDims.y ? i * eigthConstants.y : y;
                y = y + 20 > screenDims.y ? i * eigthConstants.y : y;
                Obstacle brokenBridgeW2 = new Water( thirdConstants.x * 2 - sixthConstants.x + wallWidth,
                        y,
                        new Point(seventhConstants.x, seventhConstants.x));
                addToObs(brokenBridgeW2, MED_PRIORITY - rand.nextInt(1));
            }
        }

    }
}
