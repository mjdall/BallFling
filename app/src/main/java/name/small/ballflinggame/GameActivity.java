package name.small.ballflinggame;

import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class GameActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private AccelerometerListener listener;
    private GestureDetectorCompat gestureDetector;
    private GameState gameState;

    GestureDetector.SimpleOnGestureListener gestureListener = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d("202", "Got fling");
            // TODO Update velocities if screen is on its side
            gameState.getPhysics().applyFling(velocityX, velocityY);
            gameState.invalidate();
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gameState = findViewById(R.id.gameState);

        gestureDetector = new GestureDetectorCompat(this, gestureListener);

        PackageManager manager = getPackageManager();
        if (manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_ACCELEROMETER)) {
            sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            listener = new AccelerometerListener();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.gestureDetector.onTouchEvent(event) || super.onTouchEvent(event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(listener, accelerometer);
        Log.d("onPause", "App Paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameState.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        sensorManager.registerListener(listener, accelerometer,
                SensorManager.SENSOR_DELAY_NORMAL);
        Log.d("onResume", "App Resumed");
    }

    class AccelerometerListener implements SensorEventListener {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            gameState.getPhysics().handleAccelerometer(sensorEvent.values[0]);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }
}
