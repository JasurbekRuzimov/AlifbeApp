package uz.jasurbekruzimov.alifbeapp.Alphabet;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

import uz.jasurbekruzimov.alifbeapp.R;

public class Alphabet extends AppCompatActivity {
    private GridLayout alphabetGrid;
    private String language;
    private String[] uzbekAlphabet = {"A", "B", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "X", "Y", "Z"};
    private String[] englishAlphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String[] russianAlphabet = {"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        alphabetGrid = findViewById(R.id.alphabet_grid);
        language = getIntent().getStringExtra("language");

        loadAlphabet();
    }

    private void loadAlphabet() {
        String[] alphabet = {};
        switch (language) {
            case "uzbek":
                alphabet = uzbekAlphabet;
                break;
            case "english":
                alphabet = englishAlphabet;
                break;
            case "russian":
                alphabet = russianAlphabet;
                break;
        }
        for (String letter : alphabet) {
            Button button = new Button(this);
            button.setText(letter);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playSoundForLetter(letter);
                }
            });
            alphabetGrid.addView(button);
        }
    }

    private void playSoundForLetter(String letter) {
        int resId = getResources().getIdentifier(language + "_letter_" + letter.toLowerCase(), "raw", getPackageName());
        MediaPlayer mediaPlayer = MediaPlayer.create(this, resId);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }
}