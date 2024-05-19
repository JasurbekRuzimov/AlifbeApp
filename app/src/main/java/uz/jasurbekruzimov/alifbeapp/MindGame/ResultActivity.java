package uz.jasurbekruzimov.alifbeapp.MindGame;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;

import uz.jasurbekruzimov.alifbeapp.R;

public class ResultActivity extends AppCompatActivity {

    private TextView resultText;
    private LottieAnimationView celebrationAnimation;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultText = findViewById(R.id.result_text);
        celebrationAnimation = findViewById(R.id.celebration_animation);

        int mistakes = getIntent().getIntExtra("MISTAKES", 0);
        resultText.setText("Mistakes: " + mistakes);

        if (mistakes == 0) {
            celebrationAnimation.setVisibility(View.VISIBLE);
            celebrationAnimation.playAnimation();
        }
    }
}
