package com.itesm.musicman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button seq, met, key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seq = findViewById(R.id.btnSeq);
        met = findViewById(R.id.btnMet);
        key = findViewById(R.id.btnKey);
    }

    public void Sequencer(View v){
        Intent intentoS = new Intent(this, Sequencer.class);
        startActivity(intentoS);
    }

    public void Keyboard(View v){
        Intent intentoK = new Intent(this, Keyboard.class);
        startActivity(intentoK);
    }
}
