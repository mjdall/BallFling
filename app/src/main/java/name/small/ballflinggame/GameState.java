package name.small.ballflinggame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class GameState extends View {

    Ball ball;
    Context parentC;

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

    private void init() {
        DisplayMetrics metrics = parentC.getResources().getDisplayMetrics();
        ball = new Ball( metrics.widthPixels / 2, metrics.heightPixels * 0.85, 40, Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);
        ball.draw(canvas);
    }
}
