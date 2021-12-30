package com.example.streetfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    private int duracion=1500;
    private int duracion_despues= 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        animar();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(intent);
                finish();
            }
        },10000);

    }

    public void instancias(){
        textView = (TextView) findViewById(R.id.editTexto_inicio);
    }

    public void animar(){
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f,1.0f);
        alphaAnimation.setDuration(duracion);
        alphaAnimation.setStartOffset(duracion_despues);
        alphaAnimation.setFillAfter(true);


        AlphaAnimation alphaAnimation1 = new AlphaAnimation(1.0f,0.0f);
        alphaAnimation1.setDuration(duracion);
        alphaAnimation1.setStartOffset(duracion_despues);
        alphaAnimation1.setFillAfter(true);

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                textView.setText("Pulsa para jugar");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                textView.startAnimation(alphaAnimation1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        alphaAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                textView.startAnimation(alphaAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        textView.setAnimation(alphaAnimation);
    }

}