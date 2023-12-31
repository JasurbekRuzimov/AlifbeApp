package uz.jasurbekruzimov.smartchild.Puzzle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.slider.Slider;

import uz.jasurbekruzimov.smartchild.R;

public class SettingsActivity extends AppCompatActivity {
    private long time = 0;
    private boolean soundState = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_settings);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Slider duration = findViewById(R.id.duration);
        @SuppressLint({"UseSwitchCompatOrMaterialCode", "MissingInflatedId", "LocalSuppress"}) Switch sound = findViewById(R.id.sound_switch);
        sound.setOnCheckedChangeListener((compoundButton, b) -> soundState = b);
        duration.addOnChangeListener((slider, value, fromUser) -> time = (long) value);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        intent.putExtra("time", time);
        intent.putExtra("sound_state", soundState);
        startActivity(intent);
        finish();
    }
}