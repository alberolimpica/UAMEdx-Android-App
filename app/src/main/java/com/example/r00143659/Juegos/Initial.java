package com.example.r00143659.Juegos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by R00143659 on 05/09/2016.
 */
public class Initial extends Activity implements View.OnClickListener {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.inicio);
        setContentView(R.layout.initial2);
        ImageButton button = (ImageButton) findViewById(R.id.buttonInitial);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
