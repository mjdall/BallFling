package name.small.ballflinggame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class GameState extends View {

    private Ball ball;
    private Context parentC;
    private DisplayMetrics metrics;

    private PhysicsState physics;

    public GameState (Context c) {
        super(c);
        parentC = c;
        init();
    }

    public GameState (Context c, AttributeSet attrs) {
        super(c, attrs);
        parentC = c;
        init();
    }

    public GameState (Context c, AttributeSet attrs, int defStyle) {
        super(c, attrs, defStyle);
        parentC = c;
        init();
    }

    public PhysicsState getPhysics() {
        return physics;
    }

    private void init() {
        metrics = parentC.getResources().getDisplayMetrics();
        ball = new Ball( metrics.widthPixels / 2, metrics.heightPixels * 0.85, 40, Color.WHITE);
        physics = new PhysicsState(1000.0f, 1000.0f, 0.99, 0.8, 0.02);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);

        if(!physics.isStopped()) {
            physics.doPhysicsUpdate();
            ball.applyPhysics(physics);

            Vector2<Double> pos = ball.getPos();
            if (pos.x < ball.getRadius() || pos.x > metrics.widthPixels - ball.getRadius()) {
                physics.ballBounce(PhysicsState.BOUNCE_HORIZONTAL);
                if (pos.x < ball.getRadius())
                    pos.x = ball.getRadius();
                else
                    pos.x = metrics.widthPixels - ball.getRadius();
                ball.setPos(pos);
            }

            invalidate();
        }
        ball.draw(canvas);
    }
}
