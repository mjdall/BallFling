package name.small.ballflinggame;

import android.graphics.Point;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

abstract class TrackBlueprint {
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

    public TrackBlueprint (Point screenDimensions, int height) {
        this.obstacles = new ArrayList<>();
        this.width = screenDimensions.x;
        this.height = height;
        drawPriority = new ArrayList<>();
        setConsts();
        setObs();
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
        if (obstacles.size() == 0) { obstacles = new ArrayList<>(); setObs(); return null; }
        Obstacle o = obstacles.get(0);
        o.updatePos(new Vector2<>(o.pos.x, o.pos.y + yPos));
        obstacles.remove(0);
        drawPriority.remove(0);
        return o;
    }

    public int getHeight () {
        return height;
    }
}
