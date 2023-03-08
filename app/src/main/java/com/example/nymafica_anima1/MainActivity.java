package com.example.nymafica_anima1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2;
    private MediaPlayer mp;
    private ImageView img;
    private AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imgDance);
        img.setBackgroundResource(R.drawable.animacion);
        anim = (AnimationDrawable)img.getBackground();

        btn1 = findViewById(R.id.btnPlay);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reproducir();
                anim.start();
            }
        });

        btn2 = findViewById(R.id.btnStop);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parar();
                anim.stop();
            }
        });

    }

    public void reproducir() {
        int song = this.getResources().getIdentifier("gangstar", "raw", getPackageName());
        mp = MediaPlayer.create(this, song);
        mp.seekTo(0);
        mp.start();
    }

    public void parar() {
        if (mp.isPlaying()) {
            mp.stop();
        }
    }
}