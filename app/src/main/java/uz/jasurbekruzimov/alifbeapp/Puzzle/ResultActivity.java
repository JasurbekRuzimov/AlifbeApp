package uz.jasurbekruzimov.smartchild.Puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import uz.jasurbekruzimov.smartchild.R;

public class ResultActivity extends AppCompatActivity {
    private ImageView resultImage;
    private TextView resultText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultImage = findViewById(R.id.result_background);
        resultText = findViewById(R.id.result_text);
        String playerName = getIntent().getStringExtra("player_name");
        int moves = getIntent().getIntExtra("moves", 0);
        boolean result = getIntent().getBooleanExtra("result",false);
        if (result){
            resultImage.setImageResource(R.drawable.result_background);
            resultText.setText(playerName + ", you have solved this puzzle in " + moves + " moves!!!");
        } else {
            resultImage.setImageResource(R.drawable.game_over_background);
            resultText.setText(playerName + " your time is up!!!");
        }
    }

    public void home(View view) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.menu_item_click);
        mp.start();
        startActivity(new Intent(getApplicationContext(), MenuActivity.class));
        finish();
    }
}