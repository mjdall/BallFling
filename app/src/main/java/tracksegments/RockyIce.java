package tracksegments;

import android.graphics.Point;
import java.util.Random;
import obstacles.Rock;

public class RockyIce extends IceBridge {

    public RockyIce (Point screenDims) {
        super(screenDims);
    }

    @Override
    protected void setObs() {
        super.setObs();
        Random rand = new Random();
        double waterWidth = thirdConstants.x - wallWidth;

        for (int i = 1; i < 6; i++) {
            int rockSize = 20 + rand.nextInt(30);
            Rock rock = new Rock(waterWidth + rand.nextInt(thirdConstants.x - rockSize),
                    i * seventhConstants.y, new Point(rockSize, rockSize));
            addToObs(rock, MED_PRIORITY);
        }
    }

}