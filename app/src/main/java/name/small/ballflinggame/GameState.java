package name.small.ballflinggame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import java.util.List;

public class GameState extends View {

    private Ball ball;
    private Context parentC;
    private Point screenDims;
    private TrackGenerator generator;
    // TODO: Create a list of screen objects here
    // TODO: Create draw methods for screen objects
    // TODO: Implement bouncing off of the objects rendered on the screen
    // TODO: Implement bounce back on the ball -> render waterpit coming from below
    // TODO: Implement the objects loaded buffer so we procedurally generate our level
    // TODO: Implement scoring
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
        DisplayMetrics metrics = parentC.getResources().getDisplayMetrics();
        this.screenDims = new Point(metrics.widthPixels, metrics.heightPixels);
        ball = new Ball( screenDims.x / 2, screenDims.y * 0.85, 40, Color.WHITE);
        physics = new PhysicsState(20.0f, 30.0f, 0.993, 0.6, 0.001, screenDims);
        generator = new TrackGenerator(screenDims);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);
        if(!physics.isStopped()) {
            physics.doPhysicsUpdate();
            ball.applyPhysics(physics);
            generator.doPhysicsOnObstacles(physics);
            List<Vector2<Integer>> bounces = generator.getBounces(ball, physics);
            if (bounces == null) {
                // TODO Die
                Log.d("202", "Collided with fatal object");
                generator.drawShadow(canvas);
                ball.drawShadow(canvas);
                generator.draw(canvas);
                ball.draw(canvas);
                physics.stop();
                return;
            }
            physics.doBounces(bounces);
        }
        invalidate();
        generator.drawShadow(canvas);
        ball.drawShadow(canvas);
        generator.draw(canvas);
        ball.draw(canvas);
    }
}
