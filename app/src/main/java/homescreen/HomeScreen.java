package homescreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import highscores.HighScores;
import name.small.ballflinggame.GameActivity;
import name.small.ballflinggame.R;

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
            Intent myIntent = new Intent(this, GameActivity.class);
            startActivity(myIntent);
        } catch (Exception e) {

        }
    }
}
