package tracksegments;

import android.graphics.Point;

import java.util.ArrayList;

import obstacles.Obstacle;
import name.small.ballflinggame.Vector2;

public abstract class TrackBlueprint {
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Integer> drawPriority; // Highest value drawn on top
    protected int height;
    protected int width;
    protected Point halfConstants;
    protected Point thirdConstants;
    protected Point fourthConstants;
    protected Point fifthConstants;
    protected Point sixthConstants;

    protected final int HIGH_PRIORITY = 10;
    protected final int MED_PRIORITY = 5;
    protected final int LOW_PRIORITY = 0;
    protected final int MIN_PRIORITY = Integer.MIN_VALUE; // Only used for background graphics

    private boolean obsSet;

    public TrackBlueprint (Point screenDimensions, int height) {
        this.obstacles = new ArrayList<>();
        this.width = screenDimensions.x;
        this.height = height;
        drawPriority = new ArrayList<>();
        setConsts();
        obsSet = false;
    }

    abstract void setObs (); // method for designing how everything is layed out

    final void addToObs (Obstacle obs, int priority) {
        int i;
        for(i = 0; i < drawPriority.size(); i++) {
            if(drawPriority.get(i) > priority)
                break;
        }

        obstacles.add(i, obs);
        drawPriority.add(i, priority);
    }

    private void setConsts () {
        halfConstants = new Point(width / 2, height / 2);
        thirdConstants = new Point(width / 3, height / 3);
        fourthConstants = new Point(width / 4, height / 4);
        fifthConstants = new Point(width / 5, height / 5);
        sixthConstants = new Point(width / 6, height / 6);
    }

    public Obstacle pop (double yPos) {
        if(!obsSet) // Generate obstacles on demand
        {
            obstacles = new ArrayList<>();
            setObs();
            obsSet = true;
        }

        if (obstacles.size() == 0) { obstacles = new ArrayList<>(); setObs(); return null; }
        Obstacle o = obstacles.get(0);
        o.updatePos(new Vector2<>(o.getPos().x, o.getPos().y + yPos));
        obstacles.remove(0);
        drawPriority.remove(0);
        return o;
    }

    public int getHeight () {
        return height;
    }
}
