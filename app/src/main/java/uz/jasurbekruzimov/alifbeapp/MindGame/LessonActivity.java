package uz.jasurbekruzimov.alifbeapp.MindGame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import uz.jasurbekruzimov.alifbeapp.MindGame.PracticeActivity;
import uz.jasurbekruzimov.alifbeapp.R;

public class LessonActivity extends AppCompatActivity {

    private TextView numberText;
    private ImageButton playAudioButton;
    private Button nextButton;
    private List<Integer> numbers;
    private int currentIndex = 0;
    private MediaPlayer mediaPlayer;
    private int lessonNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        numberText = findViewById(R.id.number_text);
        playAudioButton = findViewById(R.id.play_audio_button);
        nextButton = findViewById(R.id.next_button);

        lessonNumber = getIntent().getIntExtra("LESSON_NUMBER", 1);
        numbers = getNumbersForLesson(lessonNumber);

        showNumberAndSetupAudio(currentIndex);

        playAudioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudioForNumber(numbers.get(currentIndex));
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if (currentIndex < numbers.size()) {
                    showNumberAndSetupAudio(currentIndex);
                } else {
                    nextButton.setText("Practice");
                    nextButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startPracticeActivity();
                        }
                    });
                }
            }
        });
    }

    private List<Integer> getNumbersForLesson(int lessonNumber) {
        List<Integer> numbers = new ArrayList<>();
        switch (lessonNumber) {
            case 1:
                for (int i = 1; i <= 9; i++) numbers.add(i);
                break;
            case 2:
                for (int i = 10; i <= 19; i++) numbers.add(i);
                break;
            case 3:
                for (int i = 20; i <= 29; i++) numbers.add(i);
                break;
        }
        return numbers;
    }

    private void showNumberAndSetupAudio(int index) {
        int number = numbers.get(index);
        numberText.setText(String.valueOf(number));
        setupAudioForNumber(number);
    }

    private void setupAudioForNumber(int number) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        int audioResId = getResources().getIdentifier("number_" + number, "raw", getPackageName());
        mediaPlayer = MediaPlayer.create(this, audioResId);
    }

    private void playAudioForNumber(int number) {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    private void startPracticeActivity() {
        Intent intent = new Intent(LessonActivity.this, PracticeActivity.class);
        intent.putExtra("LESSON_NUMBER", lessonNumber);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
