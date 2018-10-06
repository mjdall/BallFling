package tracksegments;

import android.graphics.Point;

import obstacles.Ice;

public class IceBridge extends WaterBridge {

    public IceBridge (Point screenDims) {
        super(screenDims, false, false);
    }

    @Override
    protected void setObs() {
        super.setObs();
        double waterWidth = thirdConstants.x - wallWidth;
        Point iceDims = new Point((int)(width - waterWidth*2), height);
        Ice ice = new Ice(waterWidth, 0.0, iceDims);
        addToObs(ice, MIN_PRIORITY);
    }
}
