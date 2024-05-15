package uz.jasurbekruzimov.alifbeapp.MindGame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uz.jasurbekruzimov.alifbeapp.R;

public class LessonActivity extends AppCompatActivity {

    private TextView numberText;
    private Button nextButton;
    private int lessonNumber;
    private List<Integer> numbers;
    private int currentIndex = 0;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        numberText = findViewById(R.id.number_text);
        nextButton = findViewById(R.id.next_button);

        lessonNumber = getIntent().getIntExtra("LESSON_NUMBER", -1);
        if (lessonNumber == -1) {
            Log.e("LessonActivity", "Invalid lesson number");
            finish(); // Exit the activity if lesson number is invalid
            return;
        }
        numbers = getNumbersForLesson(lessonNumber);

        if (numbers == null || numbers.isEmpty()) {
            Log.e("LessonActivity", "No numbers for lesson: " + lessonNumber);
            finish(); // Exit the activity if there are no numbers
            return;
        }

        updateUI();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex < numbers.size() - 1) {
                    currentIndex++;
                    updateUI();
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

    private void updateUI() {
        int number = numbers.get(currentIndex);
        numberText.setText(String.valueOf(number));
        playAudioForNumber(number);
    }

    private void playAudioForNumber(int number) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        @SuppressLint("DiscouragedApi") int audioResId = getResources().getIdentifier("number_" + number, "raw", getPackageName());
        if (audioResId == 0) {
            Log.e("LessonActivity", "Audio resource not found for number: " + number);
            return;
        }
        mediaPlayer = MediaPlayer.create(this, audioResId);
        mediaPlayer.start();
    }

    private void startPracticeActivity() {
        // TODO: Implement practice activity logic
    }
}