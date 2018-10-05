package tracksegments;

import android.graphics.Point;
import java.util.Random;
import obstacles.Rock;

public class VeryRockyIce extends RockyIce{

    public VeryRockyIce (Point screenDims) {
        super(screenDims);
    }

    @Override
    protected void setObs() {
        super.setObs();
        Random rand = new Random();
        double waterWidth = thirdConstants.x - wallWidth;

        for (int i = 1; i < 6; i++) {
            int rockSize = 15 + rand.nextInt(20);
            Rock rock = new Rock(waterWidth * 2 - rand.nextInt(thirdConstants.x) + rockSize,
                    i * seventhConstants.y, new Point(rockSize, rockSize));
            addToObs(rock, MED_PRIORITY);
        }
    }
}
