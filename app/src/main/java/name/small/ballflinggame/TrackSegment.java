package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TrackSegment extends GameObject {
    private ArrayList<Obstacle> obstacles;
    private Point screenDims;
    private int height;

    public TrackSegment (double xPos, double yPos, Point screenDims, TrackBlueprint configClass) {
        super (xPos, yPos);
        this.screenDims = screenDims;
        this.height = configClass.height;
        obstacles = new ArrayList<>();
        generateObstacles(configClass);
    }

    @Override
    public void applyPhysics (PhysicsState physics) {
        pos = physics.obstacleUpdatePos(pos);
        for (Obstacle o : obstacles)
            o.applyPhysics(physics);
    }

    @Override
    public void draw (Canvas canvas) {
        // if (pos.y - height < 0 || pos.y + height > screenDims.y) return;
        for (Obstacle o : obstacles)
            o.draw(canvas);
    }

    @Override
    public void drawShadow (Canvas canvas) {
        for (Obstacle o : obstacles)
            o.drawShadow(canvas);
    }

    private void generateObstacles (TrackBlueprint configClass) {
        while (true) {
            Obstacle newO = configClass.pop(pos.y);
            if (newO == null) break;
            obstacles.add(newO);
        }
    }

    public ArrayList<Obstacle> getObstacles () {
        return obstacles;
    }

    public double getYPos () {
        return pos.y;
    }

    public int getHeight () {
        return height;
    }
}
