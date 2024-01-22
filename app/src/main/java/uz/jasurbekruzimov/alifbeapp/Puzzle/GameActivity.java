package uz.jasurbekruzimov.alifbeapp.Puzzle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Collections;

import uz.jasurbekruzimov.alifbeapp.R;

public class GameActivity extends AppCompatActivity {
    private TextView playerNameText;
    private TextView movesText;
    private Chronometer timer;
    private GridLayout gridLayout;
    private Button emptyButton;
    private LinearLayout pauseLayout;
    private final ArrayList<Integer> numberList = new ArrayList<>();
    private int x = 0;
    private int y = 0;
    private int moves = 0;
    private String playerName = "";
    private long timeWhenPause = 0;
    private boolean isGameStarted = false;
    private boolean soundState = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);
        findViews();
        setName();

        soundState = getIntent().getBooleanExtra("sound_state", true);
        if (getIntent().getLongExtra("time",5) == 0) {
            timer.setVisibility(View.INVISIBLE);
        }
        generataNumbers();
        checkToCorrectPlace();
    }

    private boolean isGameOver() {
        for (int i = 0; i < 15; i++) {
            if (!((Button)gridLayout.getChildAt(i)).getText().equals(String.valueOf(i+1)))
                return false;
        }
        return true;
    }

    @SuppressLint("SetTextI18n")
    private void updateUI() {
        movesText.setText("Moves: " + moves);
    }

    private void swap(Button clickedButton, int clickedX, int clickedY) {
        String text = clickedButton.getText().toString();
        clickedButton.setText("");
        clickedButton.setVisibility(View.INVISIBLE);
        emptyButton.setText(text);
        emptyButton.setVisibility(View.VISIBLE);
        emptyButton = clickedButton;
        checkToCorrectPlace();
        x = clickedX;
        y = clickedY;
    }

    private boolean movable(int clickedX, int clickedY) {
        return Math.abs((clickedX + clickedY) - (x + y)) == 1 && Math.abs(clickedX - x) != 2 && Math.abs(clickedY - y) != 2;
    }

    private boolean isSolvable() {
        int counter = 0;
        for (int i = 0; i < numberList.size(); i++) {
            if (numberList.get(i) == 16)
                counter += i / 4 + 1;
            else {
                for (int j = i+1; j < numberList.size(); j++) {
                    if (numberList.get(i) > numberList.get(j))
                        counter ++;
                }
            }
        }
        return  counter % 2 == 0;
    }

    private void generataNumbers() {
        numberList.clear();
        for (int i = 1; i <= 16; i++) {
            numberList.add(i);
        }
        do {
            Collections.shuffle(numberList);

        } while (!isSolvable());
        for (int i = 0; i < gridLayout.getChildCount(); i++){
            if (numberList.get(i) == 16) {
                String tag = gridLayout.getChildAt(i).getTag().toString();
                x = tag.charAt(0) - '0';
                y = tag.charAt(1) - '0';
                emptyButton = (Button) gridLayout.getChildAt(i);
                emptyButton.setVisibility(View.INVISIBLE);
            } else
                ((Button) gridLayout.getChildAt(i)).setText(String.valueOf(numberList.get(i)));
        }
    }

    private void setName() {
        Intent intent = getIntent();
        playerName = intent.getStringExtra("player_name");
        playerNameText.setText(playerName);
    }

    private void findViews() {
        playerNameText = findViewById(R.id.player_name);
        movesText = findViewById(R.id.moves);
        timer = findViewById(R.id.timer);
        gridLayout = findViewById(R.id.game_place);
        pauseLayout = findViewById(R.id.pause_layout);
        updateUI();

    }

    public void checkToCorrectPlace(){
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            Button button = (Button) gridLayout.getChildAt(i);
            LayerDrawable layerDrawable = (LayerDrawable) button.getBackground();
            GradientDrawable outer = (GradientDrawable) layerDrawable.findDrawableByLayerId(R.id.game_button_color);
            int CheckTrue = ContextCompat.getColor(this, R.color.CheckTrue);;
            int CheckWrong = ContextCompat.getColor(this, R.color.CheckWrong);;
            if (button.getText().equals(String.valueOf(i + 1)))
                outer.setColor(CheckTrue);
            else
                outer.setColor(CheckWrong);
        }

    }

    public void click(View view) {
        if (!isGameStarted) {
            timer.setBase(SystemClock.elapsedRealtime());
            timer.start();
            isGameStarted = true;
        }
        Button clickedButton = (Button) view;
        String tag = clickedButton.getTag().toString();
        int clickedX = tag.charAt(0) - '0';
        int clickedY = tag.charAt(1) - '0';
        MediaPlayer mp = MediaPlayer.create(this, R.raw.game_button_click);
        if (movable(clickedX, clickedY)) {
            if (soundState)
                mp.start();
            moves++;
            updateUI();
            swap(clickedButton, clickedX, clickedY);
            if (isGameOver()){
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("player_name", playerName);
                intent.putExtra("moves", moves);
                intent.putExtra("result", true);
                startActivity(intent);
                finish();
            }
        } else {
            mp = MediaPlayer.create(this, R.raw.error_button_click);
            if (soundState)
                mp.start();
            mp.stop();
        }
    }

    public void reset(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.menu_button_click);
        if (soundState)
            mp.start();
        mp.stop();
        isGameStarted = false;
        timer.stop();
        timer.setBase(SystemClock.elapsedRealtime());
        moves = 0;
        updateUI();
        emptyButton.setVisibility(View.VISIBLE);
        generataNumbers();
        checkToCorrectPlace();
    }

    public void resume(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.menu_button_click);
        if (soundState)
            mp.start();
        mp.stop();
        timer.setBase(timeWhenPause + SystemClock.elapsedRealtime());
        timer.start();
        pauseLayout.setVisibility(View.INVISIBLE);
    }

    public void pause(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.menu_button_click);
        if (soundState)
            mp.start();
        mp.stop();
        timeWhenPause = timer.getBase() - SystemClock.elapsedRealtime();
        timer.stop();
        pauseLayout.setVisibility(View.VISIBLE);
        pauseLayout.setFocusable(true);
        pauseLayout.setFocusable(true);

    }
}