package uz.jasurbekruzimov.alifbeapp.Game;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import uz.jasurbekruzimov.alifbeapp.R;


public class GameOver extends AppCompatActivity {

    // Declare TextView object references for showing points and personal best.
    TextView tvPoints, tvPersonalBest;
    // Declare a SharedPreferences object reference since we are going to store
    // the highest score or personal best using Android SharedPreferences class.
    SharedPreferences sharedPreferences;

    @SuppressLint({"MissingInflatedId", "SetTextI18n", "ApplySharedPref"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        // Receive the extra data from Intent that is sent from StartGame Activity.
        int points = getIntent().getExtras().getInt("points");
        // Get the handles of the TextViews for points and personal best
        tvPoints = findViewById(R.id.tvPoints);
        tvPersonalBest = findViewById(R.id.tvPersonalBest);
        // Set tvPoints with the value of points
        tvPoints.setText("" + points);
        // Instantiate the SharedPreferences object reference
        sharedPreferences = getSharedPreferences("pref", 0);
        // Here pref is the name of the file and 0 for private mode.
        // To read values from SharedPreferences, we'll use getInt() method on
        // sharedPreferences object.
        int pointsSP = sharedPreferences.getInt("pointsSP", 0);
        // The first parameter of getInt() is the key.
        // The second parameter is the default value that is, value to return if this preference
        // does not exist.
        // So, this is how we created a key named "pointsSP" using SharedPreferences,
        // retrieved value from it and stored in another integer variable
        // also named "pointsSP".
        // Next, Create a SharedPreferences.Editor object by calling edit() method
        // on sharedPreferences object.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Check, if points is greater than pointsSP
        if(points > pointsSP){
            // If true, store points in pointsSP
            pointsSP = points;
            // Put the value in editor with the key "pointsSP"
            editor.putInt("pointsSP", pointsSP);
            // This will overwrite existing value of the key "pointsSP".
            // To save the changes call commit() on editor.
            editor.commit();
        }
        // Set tvPersonalBest with the value of pointsSP
        tvPersonalBest.setText("" + pointsSP);
    }

    public void restart(View view) {
        // Create an Intent object to launch StartGame Activity
        Intent intent = new Intent(GameOver.this, StartGame_Activity.class);
        startActivity(intent);
        // Finish GameOver Activity
        finish();
    }

    public void exit(View view) {
        finish();
    }
}