package com.itesm.musicman;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Keyboard extends Activity {
    MediaPlayer notaDo, notaRe, notaMi, notaFa, notaSol, notaLa, notaSi, rebemol, mibemol, solbemol, labemol, sibemol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);

        // Reproductores de las notas:
        notaDo = MediaPlayer.create(this, R.raw.c5);
        notaRe = MediaPlayer.create(this, R.raw.d5);
        notaMi = MediaPlayer.create(this, R.raw.e5);
        notaFa = MediaPlayer.create(this, R.raw.f5);
        notaSol = MediaPlayer.create(this, R.raw.g5);
        notaLa = MediaPlayer.create(this, R.raw.a5);
        notaSi = MediaPlayer.create(this, R.raw.b5);

        rebemol = MediaPlayer.create(this, R.raw.db5);
        mibemol = MediaPlayer.create(this, R.raw.eb5);
        solbemol = MediaPlayer.create(this, R.raw.gb5);
        labemol = MediaPlayer.create(this, R.raw.ab5);
        sibemol = MediaPlayer.create(this, R.raw.bb5);

    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.piano, menu);
        return true;
    }*/


    public void tocarNota(View view) {
        switch (view.getId()) {
            case R.id.nota_do:
                notaDo.start();
                break;
            case R.id.nota_re:
                notaRe.start();
                break;
            case R.id.nota_reb:
                rebemol.start();
                break;
            case R.id.nota_mi:
                notaMi.start();
                break;
            case R.id.nota_mib:
                mibemol.start();
                break;
            case R.id.nota_fa:
                notaFa.start();
                break;
            case R.id.nota_solb:
                solbemol.start();
                break;
            case R.id.nota_sol:
                notaSol.start();
                break;
            case R.id.nota_lab:
                labemol.start();
                break;
            case R.id.nota_la:
                notaLa.start();
                break;
            case R.id.nota_sib:
                sibemol.start();
                break;
            case R.id.nota_si:
                notaSi.start();
                break;

            default:
                break;
        }
    }
}