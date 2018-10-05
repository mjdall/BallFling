package highscores;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

import highscores.SoccerMumName;
import highscores.SoccerMumNameGeneratorGoodnessXD;
import name.small.ballflinggame.R;

public class HighScores extends AppCompatActivity {
    private SoccerMumNameGeneratorGoodnessXD getNamesPl0x;
    private ArrayList<SoccerMumName> highscores;
    private TextView[] highscore_labels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscores_screen);
        getHighScoreTVs();
        getNamesPl0x = new SoccerMumNameGeneratorGoodnessXD();
        highscores = new ArrayList<>();
        generateRandomHS();
    }

    private void getHighScoreTVs () {
        highscore_labels = new TextView[5];
        TextView tv1 = findViewById(R.id.score1);
        TextView tv2 = findViewById(R.id.score2);
        TextView tv3 = findViewById(R.id.score3);
        TextView tv4 = findViewById(R.id.score4);
        TextView tv5 = findViewById(R.id.score5);
        highscore_labels[4] = tv1;
        highscore_labels[3] = tv2;
        highscore_labels[2] = tv3;
        highscore_labels[1] = tv4;
        highscore_labels[0] = tv5;
    }

    private void generateRandomHS () {
        try {
            highscores = new ArrayList<>();
            int score = 0;
            for (int i = 0; i < 5; i++) {
                try {
                     SoccerMumName newName = getNamesPl0x.getName(highscores);
                     Random rand = new Random();
                     score += rand.nextInt(5000);
                     newName.setScore(score);
                     highscores.add(newName);
                     highscore_labels[i].setText(newName.toString());
                } catch (Exception e){
                    highscore_labels[i].setText("***");
                }

            }
        }
        catch (Exception e) {

        }
    }

    public void returnToMain (View v) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
}
