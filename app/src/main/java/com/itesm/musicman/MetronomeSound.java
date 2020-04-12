package com.itesm.musicman;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Button;

import java.util.TimerTask;

public class MetronomeSound extends TimerTask {
    Context context;
    private int buttonNumber = 1;
    private Button buttonOne;
    private Button buttonTwo;

    public MetronomeSound(Context contexto, Button buttonOne, Button buttonTwo){
        this.context = contexto;
        this.buttonOne = buttonOne;
        this.buttonTwo = buttonTwo;
    }
    @Override
    public void run() {
        playSound();
    }

    private void  playSound() {
        final MediaPlayer mp = MediaPlayer.create(this.context,R.raw.metro);
        mp.start();
        if(buttonNumber == 1){
            this.buttonNumber = 2;
            this.buttonOne.setBackgroundColor(Color.parseColor("#FDD835"));
        }else if(buttonNumber == 2){
            this.buttonNumber = 1;
            this.buttonTwo.setBackgroundColor(Color.parseColor("#FDD835"));
        }
        Log.d("test", "playSound: " + this.buttonNumber);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                if(buttonNumber == 1){
                    buttonTwo.setBackgroundColor(Color.parseColor("#C3C2C2"));
                }else if(buttonNumber == 2){
                    buttonOne.setBackgroundColor(Color.parseColor("#C3C2C2"));
                }
                mp.release();
            }
        });
    }
}
