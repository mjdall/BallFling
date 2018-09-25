package name.small.ballflinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        RelativeLayout layout = new RelativeLayout(this);

        // TODO: Make fullscreen properly
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        // TODO: Create an InteractiveBackground
        InteractiveBackground ib = new InteractiveBackground(this);

        layout.addView(ib);
        setContentView(layout);

    }
}
