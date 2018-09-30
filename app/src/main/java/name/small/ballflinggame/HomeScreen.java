package name.small.ballflinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        // RelativeLayout layout = new RelativeLayout(this);

        // TODO: Make fullscreen properly
        // View decorView = getWindow().getDecorView();
        // int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        // decorView.setSystemUiVisibility(uiOptions);

        // TODO: Create an InteractiveBackground
        // InteractiveBackground ib = new InteractiveBackground(this);

        // layout.addView(ib);
        // setContentView(layout);

    }

    public void goToHighscores (View v) {
        try {
            Intent myIntent = new Intent(this, HighScores.class);
            startActivity(myIntent);
        } catch (Exception e) {

        }
    }

    public void goToGame (View v) {
        try {
            Intent myIntent = new Intent(this, GameActiviy.class);
            startActivity(myIntent);
        } catch (Exception e) {

        }
    }

    public void exitApp (View v) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
