package name.small.ballflinggame;

import android.annotation.SuppressLint;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class GameActiviy extends AppCompatActivity {

    private GestureDetectorCompat gestureDetector;

    GestureDetector.SimpleOnGestureListener gestureListener = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            // Use fling
            Log.d("202", "Got fling");
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        View v = findViewById(R.id.gameState);
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                              | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                              | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        gestureDetector = new GestureDetectorCompat(this, gestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.gestureDetector.onTouchEvent(event) || super.onTouchEvent(event);
    }
}
