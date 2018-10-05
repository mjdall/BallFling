package highscores;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

import highscores.SoccerMumName;
import highscores.SoccerMumNameGeneratorGoodnessXD;
import name.small.ballflinggame.R;

public class HighScoresActivity extends AppCompatActivity {
    private TextView[] highscore_labels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscores_screen);
        getHighScoreTVs();
        HighScoreManager.initHighScores();
        displayHighScores();
        Log.d("HighScoreManager", "Created High Score Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        displayHighScores();
        Log.d("HighScoreManager", "Resumed High Score Activity");
    }

    private void displayHighScores() {
        ArrayList<SoccerMumName> highScores = HighScoreManager.getHighScores();
        Log.d("HighScoreManager", "Processing " + highScores.size());
        for(int i = 0; i < Math.min(5, highScores.size()); i++) {
            String score = highScores.get(i).toString();
            Log.d("HighScoreManager", "Score: " + score);
            highscore_labels[i].setText(score);
            highscore_labels[i].invalidate();
        }
    }

    private void getHighScoreTVs () {
        highscore_labels = new TextView[5];
        TextView tv1 = findViewById(R.id.score1);
        TextView tv2 = findViewById(R.id.score2);
        TextView tv3 = findViewById(R.id.score3);
        TextView tv4 = findViewById(R.id.score4);
        TextView tv5 = findViewById(R.id.score5);
        highscore_labels[0] = tv1;
        highscore_labels[1] = tv2;
        highscore_labels[2] = tv3;
        highscore_labels[3] = tv4;
        highscore_labels[4] = tv5;
    }


    public void returnToMain (View v) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
}
