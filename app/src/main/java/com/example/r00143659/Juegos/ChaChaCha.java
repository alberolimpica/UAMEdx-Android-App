package com.example.r00143659.Juegos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.Toast;

public class ChaChaCha extends AppCompatActivity implements OnClickListener {
    int SIZE = 7;
    GameChaChaCha gameChaChaCha;

    private final int ids[][]={
            {0, 0, com.example.r00143659.Juegos.R.id.f1, com.example.r00143659.Juegos.R.id.f2, com.example.r00143659.Juegos.R.id.f3, 0, 0},
            {0, 0, com.example.r00143659.Juegos.R.id.f4, com.example.r00143659.Juegos.R.id.f5, com.example.r00143659.Juegos.R.id.f6, 0, 0},
            {com.example.r00143659.Juegos.R.id.f7, com.example.r00143659.Juegos.R.id.f8, com.example.r00143659.Juegos.R.id.f9, com.example.r00143659.Juegos.R.id.f10, com.example.r00143659.Juegos.R.id.f11, com.example.r00143659.Juegos.R.id.f12, com.example.r00143659.Juegos.R.id.f13},
            {com.example.r00143659.Juegos.R.id.f14, com.example.r00143659.Juegos.R.id.f15, com.example.r00143659.Juegos.R.id.f16, com.example.r00143659.Juegos.R.id.f17, com.example.r00143659.Juegos.R.id.f18, com.example.r00143659.Juegos.R.id.f19, com.example.r00143659.Juegos.R.id.f20},
            {com.example.r00143659.Juegos.R.id.f21, com.example.r00143659.Juegos.R.id.f22, com.example.r00143659.Juegos.R.id.f23, com.example.r00143659.Juegos.R.id.f24, com.example.r00143659.Juegos.R.id.f25, com.example.r00143659.Juegos.R.id.f26, com.example.r00143659.Juegos.R.id.f27},
            {0, 0, com.example.r00143659.Juegos.R.id.f28, com.example.r00143659.Juegos.R.id.f29, com.example.r00143659.Juegos.R.id.f30, 0, 0},
            {0, 0, com.example.r00143659.Juegos.R.id.f31, com.example.r00143659.Juegos.R.id.f32, com.example.r00143659.Juegos.R.id.f33, 0, 0},
    };


    private void log(String text) {
        Log.d("LifeCycleTest", text);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.r00143659.Juegos.R.layout.activity_chachacha);

        registerListeners();
        gameChaChaCha = new GameChaChaCha();
        setFigureFromGrid();
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
        }
        return super.onOptionsItemSelected(item);
    }
    public void onStart() {
        super.onStart();
        log("started");
    }
    private void registerListeners(){
        RadioButton button;
        for(int i = 0; i < SIZE ; i++){
            for(int j = 0; j < SIZE ; j++){
                if(ids[i][j] != 0){
                    button = (RadioButton) findViewById(ids[i][j]);
                    button.setOnClickListener(this);
                }
            }
        }
    }

    public void onClick(View v){
        int id = ((RadioButton)v).getId();
        for(int i = 0; i < SIZE ; i++){
            for(int j = 0; j < SIZE ; j++){
                if(ids[i][j] == id){
                    gameChaChaCha.play(i,j);
                    break;
                }
            }
        }
        setFigureFromGrid();
        if(gameChaChaCha.isGameFinished()){
            Toast.makeText(this, com.example.r00143659.Juegos.R.string.gameOverTitle, Toast.LENGTH_LONG).show();
            new AlertDialogFragment().show(getFragmentManager(), "ALERT DIALOG");
        }
    }
    public void setFigureFromGrid(){
        RadioButton button;

        for(int i = 0; i < SIZE ; i++){
            for(int j = 0; j < SIZE ; j++){
                if(ids[i][j] != 0){
                    int value = gameChaChaCha.getGrid(i,j);
                    button = (RadioButton) findViewById(ids[i][j]);

                    if(value == 1){
                        button.setChecked(true);
                    }else{
                        button.setChecked(false);
                    }
                }
            }
        }
    }

    public void onRestoreInstanceState (Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        String grid = savedInstanceState.getString("GRID");
        gameChaChaCha.stringToGrid(grid);
        setFigureFromGrid();
    }

    protected void onResume() {
        super.onResume();

        log("resumed");
    }

    protected void onPause() {
        super.onPause();

        log("paused");
    }

    public void onSaveInstanceState (Bundle outState) {
        outState.putString("GRID", gameChaChaCha.gridToString());
        super.onSaveInstanceState(outState);
    }

    protected void onStop() {
        super.onStop();
        log("stopped");
    }

    protected void onDestroy() {
        super.onDestroy();
        log("destroyed");
    }

    protected void onRestart() {
        super.onRestart();
        log("restarted");
    }
}