package uz.jasurbekruzimov.alifbeapp.MindGame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uz.jasurbekruzimov.alifbeapp.R;

public class PracticeActivity extends AppCompatActivity {

    private GridLayout numberGrid;
    private GridLayout audioGrid;
    private LottieAnimationView celebrationAnimation;
    private LinearLayout buttonsLayout;
    private Button againButton;
    private Button backLessonsButton;
    private List<Integer> numbers;
    private List<Integer> audioNumbers;
    private int selectedNumber = -1;
    private MediaPlayer mediaPlayer;
    private MediaPlayer celebrationMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        numberGrid = findViewById(R.id.number_grid);
        audioGrid = findViewById(R.id.audio_grid);
        celebrationAnimation = findViewById(R.id.celebration_animation);
        buttonsLayout = findViewById(R.id.buttons_layout);
        againButton = findViewById(R.id.again_button);
        backLessonsButton = findViewById(R.id.back_lessons_button);

        // Enable merge paths for Lottie animation
        celebrationAnimation.enableMergePathsForKitKatAndAbove(true);

        numbers = getNumbersForLesson();
        audioNumbers = new ArrayList<>(numbers);

        populateGrids();

        againButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPractice();
            }
        });

        backLessonsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracticeActivity.this, MindGameActivity.class); // Navigate back to LessonActivity
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK); // Ensure the previous activities are cleared
                startActivity(intent);
                finish();
            }
        });
    }

    private List<Integer> getNumbersForLesson() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 3); // Get 3 random numbers
    }

    private void populateGrids() {
        numberGrid.removeAllViews();
        audioGrid.removeAllViews();

        for (int number : numbers) {
            addNumberButton(number);
        }

        Collections.shuffle(audioNumbers);
        for (int number : audioNumbers) {
            addAudioButton(number);
        }
    }

    private void addNumberButton(final int number) {
        final Button button = new Button(this);
        button.setText(String.valueOf(number));
        button.setTag(number);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedNumber == number) {
                    button.setVisibility(View.INVISIBLE);
                    setSelectedAudioButtonInvisible();
                    selectedNumber = -1;
                    checkGameCompletion(); // Check game completion after setting buttons invisible
                }
            }
        });
        numberGrid.addView(button);
    }

    private void addAudioButton(final int number) {
        final ImageButton button = new ImageButton(this);
        button.setImageResource(R.drawable.ic_audio);
        // button.setBackgroundResource(R.drawable.button_background); // Add a custom background if needed
        button.setTag(number);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudioForNumber(number);
                selectedNumber = number;
            }
        });
        audioGrid.addView(button);
    }

    private void playAudioForNumber(int number) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        int audioResId = getResources().getIdentifier("number_" + number, "raw", getPackageName());
        mediaPlayer = MediaPlayer.create(this, audioResId);
        mediaPlayer.start();
    }

    private void setSelectedAudioButtonInvisible() {
        for (int i = 0; i < audioGrid.getChildCount(); i++) {
            View view = audioGrid.getChildAt(i);
            if (view instanceof ImageButton && view.getTag() != null && (int) view.getTag() == selectedNumber) {
                view.setVisibility(View.INVISIBLE);
                break;
            }
        }
    }

    private void checkGameCompletion() {
        boolean allNumbersInvisible = true;
        boolean allAudioButtonsInvisible = true;

        for (int i = 0; i < numberGrid.getChildCount(); i++) {
            if (numberGrid.getChildAt(i).getVisibility() == View.VISIBLE) {
                allNumbersInvisible = false;
                break;
            }
        }

        for (int i = 0; i < audioGrid.getChildCount(); i++) {
            if (audioGrid.getChildAt(i).getVisibility() == View.VISIBLE) {
                allAudioButtonsInvisible = false;
                break;
            }
        }

        if (allNumbersInvisible && allAudioButtonsInvisible) {
            showCelebration();
        }
    }

    private void showCelebration() {
        celebrationAnimation.setVisibility(View.VISIBLE); // Make animation visible
        celebrationAnimation.playAnimation();
        playCelebrationSound();
        buttonsLayout.setVisibility(View.VISIBLE); // Make buttons visible
    }

    private void playCelebrationSound() {
        if (celebrationMediaPlayer != null) {
            celebrationMediaPlayer.release();
        }
        celebrationMediaPlayer = MediaPlayer.create(this, R.raw.celebration_sound);
        celebrationMediaPlayer.start();
    }

    private void resetPractice() {
        celebrationAnimation.setVisibility(View.GONE); // Hide animation
        buttonsLayout.setVisibility(View.GONE); // Hide buttons
        numbers = getNumbersForLesson();
        audioNumbers = new ArrayList<>(numbers);
        populateGrids();
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
