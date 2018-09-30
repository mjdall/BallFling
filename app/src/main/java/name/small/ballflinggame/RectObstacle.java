package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;

import java.util.Random;

public class RectObstacle extends Obstacle implements Pit {
    private Random rand;
    private PitType pt;
    private Paint p;


    // TODO: Implement object dims being set on creation of this method so we know it's set
    public RectObstacle (double xPos, double yPos, Point obstacleDims, Point bounds) {
        super(xPos, yPos, obstacleDims, bounds, new RectCollider(xPos, yPos, obstacleDims.x, obstacleDims.y));
        init();
    }

    @Override
    public void updatePos(Vector2<Double> newPos) {
        pos = newPos;
        ((RectCollider)collider).updatePosition(pos.x, pos.y, obstacleDims.x, obstacleDims.y);
    }

    @Override
    public void draw (Canvas c) {
        double x = pos.x;
        double y = pos.y;
        if (y + obstacleDims.y < 0) return;
        c.drawRect((float) x, (float) y, (float) x + obstacleDims.x, (float) y + obstacleDims.y, p);
    }

    private void init () {
        rand = new Random();
        pt = initType(rand.nextInt(3));
        initColour();
        initDeadly();
        // TODO: Make a collider in here
    }

    // gets a new random type of pit, this should be changed to have different rarities
    private PitType initType (int index) {
        return index == 0 ? PitType.Water : index == 1 ? PitType.Sand : PitType.Void;
    }

    // gets the colour of the pit type
    private void initColour () {
        p = new Paint();
        // p.setColor(pt == PitType.Water ? Color.BLUE : pt == PitType.Sand ? Color.YELLOW : Color.LTGRAY);
        p.setColor(Color.BLUE);
    }

    // Currently water and void are deadly pitypes
    private void initDeadly () {
        deadly = false;
    }
}
