package name.small.ballflinggame;

import android.graphics.Point;

public class IceBridge extends WaterBridge {

    public IceBridge (Point screenDims) {
        super(screenDims, false);
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
