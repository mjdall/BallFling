package name.small.ballflinggame;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import highscores.HighScoreManager;
import physics.PhysicsState;

public class GameState extends View {

    private Ball ball;
    private Context parentC;
    private Point screenDims;
    private TrackGenerator generator;
    private TextView scoreDisplay;
    int canvasColour = 101902;
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
        ball = new Ball( screenDims.x / 2, screenDims.y * 0.85, screenDims.x * 0.03, Color.WHITE);
        physics = new PhysicsState(20.0f, 30.0f, 0.993, 0.9, 0.001, screenDims);
        generator = new TrackGenerator(screenDims);
    }

    private Activity getActivity() {
        Context context = getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity)context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }

    private void die() {
        Activity host = (Activity) this.getContext();
        host.recreate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(canvasColour | 0xFF000000);
        if(!physics.isStopped()) {
            physics.doPhysicsUpdate();
            ball.applyPhysics(physics);
            generator.doPhysicsOnObstacles(physics);
            TrackGenerator.PhysicsAffects physicsAffects = generator.getPhysicsAffects(ball, physics);
            if (physicsAffects == null) {
                Log.d("202", "Collided with fatal object");
                Log.d("202", "Distance travelled: " + physics.getDistanceTravelled());
                // TODO Update high score using distance travelled
                HighScoreManager.addHighScore((int)physics.getDistanceTravelled());
                die();
                return;
            }
            physics.doBounces(physicsAffects.bounces);
            physics.doStatusAffects(physicsAffects.statusAffects);
        }
        if(scoreDisplay == null) {
            scoreDisplay = ((View)getParent()).findViewById(R.id.scoreBox);
        }
        scoreDisplay.setText("Score: " + (int)physics.getDistanceTravelled());
        invalidate();
        generator.drawShadow(canvas);
        ball.drawShadow(canvas);
        generator.draw(canvas);
        ball.draw(canvas);
    }
}
