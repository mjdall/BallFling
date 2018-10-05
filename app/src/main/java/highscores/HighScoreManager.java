package highscores;

import android.util.Log;

import java.util.ArrayList;

public class HighScoreManager {

    private static boolean init = false;

    public static boolean needsInit() {
        return !init;
    }

    public static void initHighScores() {
        if(!needsInit()) return;

        HighScoreManager.init = true;
        HighScoreManager.getNamesPl0x = new SoccerMumNameGeneratorGoodnessXD();
        HighScoreManager.highScores = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            addHighScore(0);
        }
    }

    private static SoccerMumNameGeneratorGoodnessXD getNamesPl0x;
    private static ArrayList<SoccerMumName> highScores;

    public static boolean addHighScore(int score) {
        if(needsInit()){
            initHighScores();
        }

        Log.d("HighScoreManager", "Got high score: " + score);

        SoccerMumName newName = getNamesPl0x.getName(highScores);
        newName.setScore(score);
        boolean gotHighScore = false;
        boolean inserted = false;
        for(int i = 0; i < highScores.size(); i++) {
            SoccerMumName name = highScores.get(i);
            if(name.getScore() < score) {
                highScores.add(i, newName);
                gotHighScore = i < 5;
                inserted = true;
                break;
            }
        }
        if(!inserted) {
            highScores.add(newName);
        }

        // Remove everything after index 100
        while (highScores.size() > 100) {
            highScores.remove(100);
        }

        return gotHighScore;
    }

    public static ArrayList<SoccerMumName> getHighScores() {
        return highScores;
    }
}
