package com.example.r00143659.Juegos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by R00143659 on 15/08/2016.
 */
public class Initial extends AppCompatActivity implements View.OnClickListener{

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(com.example.r00143659.Juegos.R.layout.initial);

        Button button = (Button) findViewById(com.example.r00143659.Juegos.R.id.buttonChaChaCha);
        button.setOnClickListener(this);
        button = (Button) findViewById(com.example.r00143659.Juegos.R.id.buttonConecta4);
        button.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if (v.getId() == com.example.r00143659.Juegos.R.id.buttonChaChaCha) {
            startActivity(new Intent(this, ChaChaCha.class));

        } else if (v.getId() == com.example.r00143659.Juegos.R.id.buttonConecta4) {
            startActivity(new Intent(this, Conecta4.class));

        }

    }
}
