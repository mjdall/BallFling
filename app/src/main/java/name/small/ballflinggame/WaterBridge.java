package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Point;

public class WaterBridge extends TrackPiece {

    public WaterBridge (double xPos, double yPos, Point screenDims) {
        super(xPos, yPos, screenDims);
    }

    @Override
    protected void setUpTrack () {
        double x = pos.x; // where we are right now
        double y = pos.y;
        Point leftSide2ndXY = new Point(thirdSlice.x, (int) y + screenDims.y);
        Point rightSide2ndXY = new Point(screenDims.x, (int) y + screenDims.y);
        RectObstacle leftSide = new RectObstacle(x, y, leftSide2ndXY, screenDims, Pit.PitType.Water);
        RectObstacle rightSide = new RectObstacle(screenDims.x - thirdSlice.x, y, rightSide2ndXY, screenDims, Pit.PitType.Water);
        toDraw.add(leftSide);
        toDraw.add(rightSide);
    }

    @Override
    protected void setUpTrackSpecs () {
        trackPieceDims = new Point(screenDims.x, 3500);
    }

    @Override
    public void draw (Canvas c) {
        for (Obstacle o : toDraw) {
            o.draw(c);
        }
    }

    @Override
    public void applyPhysics (PhysicsState physics) {
        pos = physics.obstacleUpdatePos(pos);
        for (Obstacle o : toDraw) {
            o.applyPhysics(physics);
        }
    }

    @Override
    protected void setUpCanGenerateArray () {
        try {
            TrackPiece wb = new WaterBridge(0.0, 0.0, this.screenDims);
            canGenerate.add(wb);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Vector2<Integer> getBounceDir (Ball b, PhysicsState physics) {
        Vector2<Integer> bounceDir = new Vector2<>(0,0);
        return bounceDir;
    }
}
