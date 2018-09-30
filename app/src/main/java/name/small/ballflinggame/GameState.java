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
    private ObstacleGenerator gener;
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
        ball = new Ball( screenDims.x / 2, screenDims.y * 0.85, 40, Color.BLACK);
        physics = new PhysicsState(25.0f, 100.0f, 0.993, 0.8, 0.002, screenDims);
        gener = new ObstacleGenerator(screenDims);
    }

    // TODO: Add points for passing over point line
    // TODO: Add points textview
    // TODO: Add music
    // TODO: Add collisions lul
    // TODO: Add more obstacles
    // TODO: Add death
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        if(!physics.isStopped()) {
            physics.doPhysicsUpdate();
            ball.applyPhysics(physics);
            gener.doPhysicsOnObstacles(physics);
            List<Vector2<Integer>> bounces = gener.getBounces(ball, physics);
            if (bounces == null) {
                // TODO Die
                Log.d("202", "Collided with fatal object");
                gener.draw(canvas);
                ball.draw(canvas);
                physics.stop();
                return;
            }
            physics.doBounces(bounces);
        }
        // TODO: Loop through screen objects here, applying physics to them
        // TODO: Apply physics, check in class if dead now
        // TODO: In here, check isDead, if dead remove from list, generate new object offscreen?
        // TODO: Should just be able to hold their position off screen but not actually render them until they should be on screen
        // TODO: Check .onScreen() -> yes, draw -> no, no-draw.
        // TODO: Course generator class, handling all of the procedural shit
        invalidate();
        gener.draw(canvas);
        ball.draw(canvas);
    }
}
