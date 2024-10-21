package com.eco.ecomarket.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.eco.ecomarket.R;
import com.eco.ecomarket.databinding.SlideScreenBinding;


public class SplashScreenActivity extends AppCompatActivity {
    LottieAnimationView lottie;
    TextView text;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        initWidget();

        lottie.animate().translationX(-2000).setDuration(2000).setStartDelay(2900);
       text.animate().translationX(-2000).setDuration(2000).setStartDelay(2900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                 intent=new Intent(getApplicationContext(), NavigationActivity.class);
                 startActivity(intent);
            }
        },5000
        );

    }
    void initWidget(){
        lottie=findViewById(R.id.lottie);
        text=findViewById(R.id.tv);

    }
}

