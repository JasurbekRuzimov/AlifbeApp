package uz.jasurbekruzimov.alifbeapp.Alphabet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import uz.jasurbekruzimov.alifbeapp.R;

public class Languages extends AppCompatActivity {

    private Button buttonUzbek, buttonEnglish, buttonRussian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);
        buttonUzbek = findViewById(R.id.button_uzbek);
        buttonEnglish = findViewById(R.id.button_english);
        buttonRussian = findViewById(R.id.button_russian);

        buttonUzbek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlphabetActivity("uzbek");
            }
        });

        buttonEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlphabetActivity("english");
            }
        });

        buttonRussian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlphabetActivity("russian");
            }
        });
    }
    private void openAlphabetActivity(String language) {
        Intent intent = new Intent(Languages.this, Alphabet.class);
        intent.putExtra("language", language);
        startActivity(intent);
    }
}