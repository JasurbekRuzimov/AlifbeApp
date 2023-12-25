package uz.jasurbekruzimov.alifbeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.card.MaterialCardView;

import uz.jasurbekruzimov.alifbeapp.Game.Oyinlar_Activity;

public class MainActivity extends AppCompatActivity {
    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialCardView alifbe = findViewById(R.id.alifbe);
        MaterialCardView color = findViewById(R.id.color);
        MaterialCardView etc = findViewById(R.id.etc);
        startPulseAnimationCardView(alifbe);
        startPulseAnimationCardView(color);
        startPulseAnimationCardView(etc);
    }

    private void startPulseAnimationCardView(MaterialCardView button) {
        ObjectAnimator pulseAnimator = ObjectAnimator.ofPropertyValuesHolder(button,
                PropertyValuesHolder.ofFloat("scaleX", 1.0f, 1.2f),
                PropertyValuesHolder.ofFloat("scaleY", 1.0f, 1.2f));
        pulseAnimator.setDuration(350);
        pulseAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        pulseAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        pulseAnimator.start();
    }

    public void goColorGame(View view) {
        Intent i = new Intent(MainActivity.this, Oyinlar_Activity.class);
        startActivity(i);
    }

    public void goHarfActivity(View view) {
        Intent i = new Intent(MainActivity.this, HarfActivity.class);
        startActivity(i);
    }

}