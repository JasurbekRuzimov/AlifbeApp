package uz.jasurbekruzimov.alifbeapp.MindGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import uz.jasurbekruzimov.alifbeapp.R;

public class MindGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind_game);

        Button lesson1Button = findViewById(R.id.lesson1_button);
        Button lesson2Button = findViewById(R.id.lesson2_button);
        Button lesson3Button = findViewById(R.id.lesson3_button);

        lesson1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLessonActivity(1);
            }
        });

        lesson2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLessonActivity(2);
            }
        });

        lesson3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLessonActivity(3);
            }
        });
    }

    private void startLessonActivity(int lessonNumber) {
        Intent intent = new Intent(MindGameActivity.this, LessonActivity.class);
        intent.putExtra("LESSON_NUMBER", lessonNumber);
        startActivity(intent);
    }
}