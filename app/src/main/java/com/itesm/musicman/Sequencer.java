package com.itesm.musicman;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class Sequencer extends AppCompatActivity implements OnItemSelectedListener{

    private ImageButton btnPlay;
    private MediaPlayer C,Cm,Abm,Ab,Am,A,Bbm,Bb,Bm,B,Dbm,Db,Dm,D,Ebm,Eb,Em,E,Fm,F,Gbm,Gb,Gm,G,empty;
    private Spinner spinner, spinner2,spinner3, spinner4;


    private Spinner [] arraySp={spinner, spinner2,spinner3, spinner4};
    private Runnable playback;
    private boolean playing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sequencer);

        //chords
        //C
        C = MediaPlayer.create(this, R.raw.cchord);
        Cm = MediaPlayer.create(this, R.raw.cmchord);
        //Ab
        Abm = MediaPlayer.create(this, R.raw.abmchord);
        Ab = MediaPlayer.create(this, R.raw.abchord);
        //A
        Am = MediaPlayer.create(this, R.raw.amchord);
        A = MediaPlayer.create(this, R.raw.achord);
        //Bb
        Bbm = MediaPlayer.create(this, R.raw.bbmchord);
        Bb = MediaPlayer.create(this, R.raw.bbchord);
        //B
        Bm = MediaPlayer.create(this, R.raw.bmchord);
        B = MediaPlayer.create(this, R.raw.bchord);
        //Db
        Dbm = MediaPlayer.create(this, R.raw.dbmchord);
        Db = MediaPlayer.create(this, R.raw.dbchord);
        //D
        Dm = MediaPlayer.create(this, R.raw.dmchord);
        D = MediaPlayer.create(this, R.raw.dchord);
        //Eb
        Ebm = MediaPlayer.create(this, R.raw.ebmchord);
        Eb = MediaPlayer.create(this, R.raw.ebchord);
        //E
        Em = MediaPlayer.create(this, R.raw.emchord);
        E = MediaPlayer.create(this, R.raw.echord);
        //F
        Fm = MediaPlayer.create(this, R.raw.fmchord);
        F = MediaPlayer.create(this, R.raw.fchord);
        //Gb
        Gbm = MediaPlayer.create(this, R.raw.gbmchord);
        Gb = MediaPlayer.create(this, R.raw.gbchord);
        //G
        Gm = MediaPlayer.create(this, R.raw.gmchord);
        G = MediaPlayer.create(this, R.raw.gchord);
        //
        empty = MediaPlayer.create(this, R.raw.empty);

        String[]chords= {"-","C","Cm","D♭","D♭m","D","Dm","E♭","E♭m","E","Em","F","Fm","G♭","G♭m","G","Gm","A♭","A♭m","A","Am","B♭","B♭m","B","Bm"};
        MediaPlayer[]chordsMP= {empty,C,Cm,Db,Dbm,D,Dm,Eb,Ebm,E,Em,F,Fm,Gb,Gbm,G,Gm,Ab,Abm,A,Am,Bb,Bbm,B,Bm};



        //spinners

        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);

        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setOnItemSelectedListener(this);

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, chords));
        spinner2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, chords));
        spinner3.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, chords));
        spinner4.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, chords));


        btnPlay = findViewById(R.id.btnPlay);


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Em.start();
            }
        });
    }

    @Override
   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        if(item!="-") {
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
        }


    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onClick(View v) {

        sCollector(spinner.getSelectedItem().toString());

    }

    /*
    public void play(View v) {
        // play sound periodically
        playback = new Runnable() {
            int bpm = 90;
            long millis = System.currentTimeMillis();
            long next = (60 * 1000) / bpm;

            public void run() {

                while (playing) {

                    for (int i = 0; i < 4; i++) {

                        sCollector(arraySp[i].getSelectedItem().toString());

                        try {
                            Thread.sleep(next - (System.currentTimeMillis() - millis));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        };

        playing = true;
        Thread thandler = new Thread(playback);
        thandler.start();
    }

    public void stop() {
        playing = false;
    }

    public void toggle() {
        if (playing) {
            stop();
        } else {
            //play();
        }
    }*/

    public void sCollector (String chord){
        switch(chord){
            case "C":
                System.out.println("DO");
                C.start();
                break;
            case "Cm":
                Cm.start();
                break;
            case "D♭":
                Db.start();
                break;
            case "D♭m":
                Dbm.start();
                break;
            case "D":
                D.start();
                break;
            case "Dm":
                Dm.start();
                break;
            case "E♭":
                Eb.start();
                break;
            case "E♭m":
                Ebm.start();
                break;
            case "E":
                E.start();
                break;
            case "Em":
                Em.start();
                break;
            case "F":
                F.start();
                break;
            case "Fm":
                Fm.start();
                break;
            case "G♭":
                Gb.start();
                break;
            case "G♭m":
                Gbm.start();
                break;
            case "G":
                G.start();
                break;
            case "Gm":
                Gm.start();
                break;
            case "A♭":
                Ab.start();
                break;
            case "A♭m":
                Abm.start();
                break;
            case "A":
                A.start();
                break;
            case "Am":
                Am.start();
                break;
            case "B♭":
                Bb.start();
                break;
            case "B♭m":
                Bbm.start();
                break;
            case "B":
                B.start();
                break;
            case "Bm":
                Bm.start();
                break;
            case "-":
                empty.start();
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}

