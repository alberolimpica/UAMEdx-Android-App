package com.example.r00143659.Juegos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by R00143659 on 15/08/2016.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.inicio);
        setContentView(R.layout.initial);

//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.initial);
//        ImageView imageView = (ImageView) findViewById(R.id.initial);
//        imageView.startAnimation(animation);



        Button button = (Button) findViewById(com.example.r00143659.Juegos.R.id.buttonChaChaCha);
        button.setOnClickListener(this);
        button = (Button) findViewById(com.example.r00143659.Juegos.R.id.buttonConecta4);
        button.setOnClickListener(this);
    }

    //Menu opciones
    public boolean onCreateOptionsMenu(Menu menu){
        //Primero llamamos al metodo de la superclase
        super.onCreateOptionsMenu(menu);
    //Obtenemos una instancia de la clase MenuInflater y llamamos al metodo inflate()
        MenuInflater inflater = getMenuInflater();
        //El metodo inflate anade al menu de opciones de la actividad la interfaz
        //grafica especificada en su primer argumento, que es el id del fichero xml
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    //Cuando se clickee en una de las opciones

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuAbout:
                startActivity(new Intent(this, About.class));
                return true;
            case R.id.menuSend:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("test/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Juegos app");
                intent.putExtra(Intent.EXTRA_TEXT, "Hola la app Juegos...");
                startActivity(intent);
                return true;
            case R.id.preferencias:
                startActivity(new Intent(this, CCCPreference.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
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
