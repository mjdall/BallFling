package name.small.ballflinggame;

import android.graphics.Canvas;
import android.graphics.Point;

public abstract class ScreenObject {
    protected Point location;
    protected Point direction;
    protected int speed;

    protected abstract Point getPos ();

}
