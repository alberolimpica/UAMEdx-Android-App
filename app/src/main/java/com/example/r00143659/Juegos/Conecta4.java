package com.example.r00143659.Juegos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Conecta4 extends AppCompatActivity {

    private final int ids[][] = {
            { com.example.r00143659.Juegos.R.id.c0, com.example.r00143659.Juegos.R.id.c1, com.example.r00143659.Juegos.R.id.c2, com.example.r00143659.Juegos.R.id.c3, com.example.r00143659.Juegos.R.id.c4, com.example.r00143659.Juegos.R.id.c5, com.example.r00143659.Juegos.R.id.c6 },
            { com.example.r00143659.Juegos.R.id.c7, com.example.r00143659.Juegos.R.id.c8, com.example.r00143659.Juegos.R.id.c9, com.example.r00143659.Juegos.R.id.c10, com.example.r00143659.Juegos.R.id.c11, com.example.r00143659.Juegos.R.id.c12, com.example.r00143659.Juegos.R.id.c13 },
            { com.example.r00143659.Juegos.R.id.c14, com.example.r00143659.Juegos.R.id.c15, com.example.r00143659.Juegos.R.id.c16, com.example.r00143659.Juegos.R.id.c17, com.example.r00143659.Juegos.R.id.c18, com.example.r00143659.Juegos.R.id.c19,
                    com.example.r00143659.Juegos.R.id.c20 },
            { com.example.r00143659.Juegos.R.id.c21, com.example.r00143659.Juegos.R.id.c22, com.example.r00143659.Juegos.R.id.c23, com.example.r00143659.Juegos.R.id.c24, com.example.r00143659.Juegos.R.id.c25, com.example.r00143659.Juegos.R.id.c26,
                    com.example.r00143659.Juegos.R.id.c27 },
            { com.example.r00143659.Juegos.R.id.c28, com.example.r00143659.Juegos.R.id.c29, com.example.r00143659.Juegos.R.id.c30, com.example.r00143659.Juegos.R.id.c31, com.example.r00143659.Juegos.R.id.c32, com.example.r00143659.Juegos.R.id.c33,
                    com.example.r00143659.Juegos.R.id.c34 },
            { com.example.r00143659.Juegos.R.id.c35, com.example.r00143659.Juegos.R.id.c36, com.example.r00143659.Juegos.R.id.c37, com.example.r00143659.Juegos.R.id.c38, com.example.r00143659.Juegos.R.id.c39, com.example.r00143659.Juegos.R.id.c40,
                    com.example.r00143659.Juegos.R.id.c41 } };

    private GameConecta4 gameConecta4;
    private TextView resultadoTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.r00143659.Juegos.R.layout.activity_main);


        gameConecta4 = new GameConecta4();

        resultadoTextView = (TextView) findViewById(com.example.r00143659.Juegos.R.id.resultadoTextView);
    }


    public void dibujarTablero() {
        int id = 0;

        for (int i = 0; i < GameConecta4.NFILAS; i++)
            for (int j = 0; j < GameConecta4.NCOLUMNAS; j++) {
                if(gameConecta4.estaJugador(i,j)){
                    id = com.example.r00143659.Juegos.R.drawable.c4_human_pressed_button;
                }else if(gameConecta4.estaVacio(i,j)) {
                    id = com.example.r00143659.Juegos.R.drawable.c4_button;
                }else if(gameConecta4.estaMaquina(i,j)){
                    id = com.example.r00143659.Juegos.R.drawable.c4_machine_pressed_button;
                }

                ImageButton imageButton = (ImageButton) findViewById(ids[i][j]);
                imageButton.setImageResource(id);
            }
    }

    public void pulsado(View v) {
        int fila, columna, id = v.getId();


        if (gameConecta4.tableroLleno()) {
            resultadoTextView.setText(com.example.r00143659.Juegos.R.string.fin_del_juego);
            Toast.makeText(this, com.example.r00143659.Juegos.R.string.fin_del_juego,
                    Toast.LENGTH_LONG).show();
            return;
        }

        fila = deIdentificadorAFila(id);
        columna = deIdentificadorAColumna(id);


        if (!gameConecta4.sePuedeColocarFicha(fila, columna)) {
            Toast.makeText(this, com.example.r00143659.Juegos.R.string.nosepuedecolocarficha,
                    Toast.LENGTH_SHORT).show();
            return;
        }

        gameConecta4.ponerJugador(fila, columna);
        int turnoJ = GameConecta4.JUGADOR;
        if(gameConecta4.comprobarCuatro(turnoJ)){
            Toast.makeText(this, com.example.r00143659.Juegos.R.string.ganaste,
                    Toast.LENGTH_LONG).show();
            dibujarTablero();
            return;
        }
        gameConecta4.juegaMaquina();
        int turnoM = GameConecta4.MAQUINA;
        if(gameConecta4.comprobarCuatro(turnoM)){
            Toast.makeText(this, com.example.r00143659.Juegos.R.string.gano,
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
