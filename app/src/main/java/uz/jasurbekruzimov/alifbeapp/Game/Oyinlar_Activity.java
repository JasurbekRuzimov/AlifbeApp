package uz.jasurbekruzimov.alifbeapp.Game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import uz.jasurbekruzimov.alifbeapp.R;


public class Oyinlar_Activity extends AppCompatActivity {

    ImageView backHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyinlar);

        backHome = findViewById(R.id.backHomeGame);

        backHome.setOnClickListener(v -> finish());

    }

    public void StartGame(View view) {
        Intent intent = new Intent(Oyinlar_Activity.this, StartGame_Activity.class);
        startActivity(intent);
        finish();
    }
}