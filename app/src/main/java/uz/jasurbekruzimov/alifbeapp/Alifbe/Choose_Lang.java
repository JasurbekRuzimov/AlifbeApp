package uz.jasurbekruzimov.alifbeapp.Alifbe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import uz.jasurbekruzimov.alifbeapp.R;

public class Choose_Lang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_lang);

    }

    public void uzbek_alphabet(View view) {
        Intent i = new Intent(Choose_Lang.this, Alifbe_Uz.class);
        startActivity(i);
    }

    public void english_alphabet(View view) {
        Intent i = new Intent(Choose_Lang.this, Alifbe_En.class);
        startActivity(i);
    }

    public void russian_alphabet(View view) {
        Intent i = new Intent(Choose_Lang.this, Alifbe_Ru.class);
        startActivity(i);
    }

    public void backHome(View view) {
        finish();
    }
}