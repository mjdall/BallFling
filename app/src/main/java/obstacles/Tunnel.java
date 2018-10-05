package obstacles;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import name.small.ballflinggame.Vector2;
import physics.TunnelCollider;

public class Tunnel extends Obstacle {
    private Paint p;

    public Tunnel (double xPos, double yPos, Point obstacleDims) {
        super(xPos, yPos, obstacleDims, false, new TunnelCollider(xPos,yPos, obstacleDims.x, obstacleDims.y));
        p = new Paint();
        p.setColor(Color.WHITE & 0x7FFFFFFF);
    }

    @Override
    public void updatePos(Vector2<Double> newPos) {
        pos = newPos;
        ((TunnelCollider)collider).updatePosition(pos.x, pos.y, obstacleDims.x, obstacleDims.y);
    }

    @Override
    public void drawShadow(Canvas c) {
        // rip
    }

    @Override
    public void draw (Canvas c) {
        double x = pos.x;
        double y = pos.y;
        if (y + obstacleDims.y < 0) return;
        c.drawRect((float) x, (float) y, (float) x + obstacleDims.x, (float) y + obstacleDims.y, p);
    }
}
