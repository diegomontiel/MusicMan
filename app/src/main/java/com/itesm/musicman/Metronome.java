package com.itesm.musicman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;

public class Metronome extends AppCompatActivity {
    private TextView metronomeText;
    private Button play;
    private Button buttonOne;
    private Button buttonTwo;
    private boolean playing = false;
    Timer mainTimer;
    MetronomeSound mainTimerTask;
    int MILLIS_IN_MINUTE = 1000 * 60;
    int bpm = 40;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metronome);

        metronomeText = findViewById(R.id.MetronomeText);
        metronomeText.setText(this.bpm + "ppm");
        seekBar = findViewById(R.id.seekBarMetronome);
        play = findViewById(R.id.play);
        buttonOne = findViewById(R.id.buttonOne);
        buttonTwo = findViewById(R.id.buttonTwo);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (playing == false){
                    play();
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                bpm = i;
                metronomeText.setText(bpm + "ppm");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if(playing == true){
                    stop();
                }

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void play() {
        playing = true;
        mainTimer = new Timer();
        mainTimerTask = new MetronomeSound(Metronome.this, buttonOne, buttonTwo);
        mainTimer.schedule(mainTimerTask, 0, MILLIS_IN_MINUTE / bpm);
    }

    public void stop() {
        playing = false;
        mainTimer.cancel();
    }
}
