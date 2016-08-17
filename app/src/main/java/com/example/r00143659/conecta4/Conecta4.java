package com.example.r00143659.conecta4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Conecta4 extends AppCompatActivity {

    private final int ids[][] = {
            { R.id.c0, R.id.c1, R.id.c2, R.id.c3, R.id.c4, R.id.c5, R.id.c6 },
            { R.id.c7, R.id.c8, R.id.c9, R.id.c10, R.id.c11, R.id.c12, R.id.c13 },
            { R.id.c14, R.id.c15, R.id.c16, R.id.c17, R.id.c18, R.id.c19,
                    R.id.c20 },
            { R.id.c21, R.id.c22, R.id.c23, R.id.c24, R.id.c25, R.id.c26,
                    R.id.c27 },
            { R.id.c28, R.id.c29, R.id.c30, R.id.c31, R.id.c32, R.id.c33,
                    R.id.c34 },
            { R.id.c35, R.id.c36, R.id.c37, R.id.c38, R.id.c39, R.id.c40,
                    R.id.c41 } };

    private GameConecta4 gameConecta4;
    private TextView resultadoTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gameConecta4 = new GameConecta4();

        resultadoTextView = (TextView) findViewById(R.id.resultadoTextView);
    }


    public void dibujarTablero() {
        int id = 0;

        for (int i = 0; i < GameConecta4.NFILAS; i++)
            for (int j = 0; j < GameConecta4.NCOLUMNAS; j++) {
                if(gameConecta4.estaJugador(i,j)){
                    id = R.drawable.c4_human_pressed_button;
                }else if(gameConecta4.estaVacio(i,j)) {
                    id = R.drawable.c4_button;
                }else if(gameConecta4.estaMaquina(i,j)){
                    id = R.drawable.c4_machine_pressed_button;
                }

                ImageButton imageButton = (ImageButton) findViewById(ids[i][j]);
                imageButton.setImageResource(id);
            }
    }

    public void pulsado(View v) {
        int fila, columna, id = v.getId();


        if (gameConecta4.tableroLleno()) {
            resultadoTextView.setText(R.string.fin_del_juego);
            return;
        }

        fila = deIdentificadorAFila(id);
        columna = deIdentificadorAColumna(id);


        if (!gameConecta4.sePuedeColocarFicha(fila, columna)) {
            Toast.makeText(this, R.string.nosepuedecolocarficha,
                    Toast.LENGTH_SHORT).show();
            return;
        }

        gameConecta4.ponerJugador(fila, columna);
        int turnoJ = GameConecta4.JUGADOR;
        if(gameConecta4.comprobarCuatro(turnoJ)){
            Toast.makeText(this, R.string.ganaste,
                    Toast.LENGTH_LONG).show();
            dibujarTablero();
            return;
        }
        gameConecta4.juegaMaquina();
        int turnoM = GameConecta4.MAQUINA;
        if(gameConecta4.comprobarCuatro(turnoM)){
            Toast.makeText(this, R.string.gano,
                    Toast.LENGTH_LONG).show();
            dibujarTablero();
            return;
        }
        dibujarTablero();
    }

    private int deIdentificadorAFila(int id) {
        for (int i = 0; i < GameConecta4.NFILAS; i++)
            for (int j = 0; j < GameConecta4.NCOLUMNAS; j++)
                if (ids[i][j] == id)
                    return i;
        return -1;
    }

    private int deIdentificadorAColumna(int id) {
        for (int i = 0; i < GameConecta4.NFILAS; i++)
            for (int j = 0; j < GameConecta4.NCOLUMNAS; j++)
                if (ids[i][j] == id)
                    return j;
        return -1;
    }
}
