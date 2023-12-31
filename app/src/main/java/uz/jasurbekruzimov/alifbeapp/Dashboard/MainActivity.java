package uz.jasurbekruzimov.alifbeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;

import uz.jasurbekruzimov.alifbeapp.Game.Oyinlar_Activity;

public class MainActivity extends AppCompatActivity {
    private boolean isMenuOpen = false;
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



        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
    ImageView navMenu = findViewById(R.id.nav_menu_icon);
        navMenu.setOnClickListener(v -> {
            Animation animation;
            if (isMenuOpen) {
                animation = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            } else {
                animation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            }
            animation.setDuration(300);
            animation.setFillAfter(true);
            navMenu.startAnimation(animation);
            drawerLayout.openDrawer(GravityCompat.START);
            isMenuOpen = !isMenuOpen;
        });
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            item.setChecked(true);
//            switch (item.getItemId()) {
//                case R.id.nav_profile:
//                    Intent intent = new Intent(MainActivity.this, Profile.class);
//                    startActivity(intent);
//                    break;
//                case R.id.nav_settings:
//                    Intent intent1 = new Intent(MainActivity.this, Settings_activity.class);
//                    startActivity(intent1);
//                    break;
//                case R.id.nav_share1:
//                    Intent intent2 = new Intent(Intent.ACTION_SEND);
//                    intent2.setType("text/plain");
//                    String shareBody = "https://play.google.com/store/apps/details?id=GeniusChild.uz";
//                    String shareSub = "GeniusChild";
//                    intent2.putExtra(Intent.EXTRA_SUBJECT, shareSub);
//                    intent2.putExtra(Intent.EXTRA_TEXT, shareBody);
//                    startActivity(Intent.createChooser(intent2, "Share Using"));
//                    break;
//                case R.id.nav_support:
//                    Intent intent3 = new Intent(MainActivity.this, Support_Activity.class);
//                    startActivity(intent3);
//                    break;
//                case R.id.nav_FAQ:
//                    Intent intent4 = new Intent(MainActivity.this, FAQ_activity.class);
//                    startActivity(intent4);
//                    break;
//                case R.id.nav_AboutUs:
//                    Intent intent5 = new Intent(MainActivity.this, AboutUs_activity.class);
//                    startActivity(intent5);
//                    break;
//            }
            return false;
        });

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