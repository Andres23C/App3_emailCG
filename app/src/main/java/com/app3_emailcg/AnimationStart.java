package com.app3_emailcg;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.airbnb.lottie.LottieAnimationView;
import android.widget.TextView;

public class AnimationStart extends AppCompatActivity {

    private static final long DELAY_MILLIS = 7000; // 7 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_start);

        LottieAnimationView animationView = findViewById(R.id.animationView);
        TextView textViewWelcome = findViewById(R.id.textViewWelcome);

        // Inicia la animación
        animationView.setAnimation(R.raw.animation1);
        animationView.playAnimation();

        // Crear un Handler para la transición automática después de 7 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Pasar al Main
                Intent intent = new Intent(AnimationStart.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finalizar esta actividad para evitar que se vuelva atrás
            }
        }, DELAY_MILLIS);
    }
}
