package com.example.r00143659.conecta4;

import java.util.Random;

public class Game {
    static final int NFILAS = 6;
    static final int NCOLUMNAS = 7;
    static final int VACIO = 0;
    static final int MAQUINA = 1;
    static final int JUGADOR = 2;

    private int tablero[][];

    public Game() {
        tablero = new int[NFILAS][NCOLUMNAS];

        for (int i = 0; i < NFILAS; i++)
            for (int j = 0; j < NCOLUMNAS; j++)
                tablero[i][j] = VACIO;
    }

    public boolean estaVacio(int i, int j) {

        if (tablero[i][j] == VACIO) {
            return true;
        } else {
            return false;
        }
    }

    public boolean estaJugador(int i, int j) {

        if (tablero[i][j] == JUGADOR) {
            return true;
        } else {
            return false;
        }

    }
    public boolean estaMaquina(int i, int j) {

        if (tablero[i][j] == MAQUINA) {
            return true;
        } else {
            return false;
        }

    }

    public void ponerJugador(int i, int j) {
        tablero[i][j] = JUGADOR;
    }

    public boolean tableroLleno() {
        for (int i=0; i<NFILAS; i++)
            for (int j=0; j<NCOLUMNAS; j++)
                if (tablero[i][j] == VACIO)
                    return false;

        return true;
    }

    public boolean sePuedeColocarFicha(int i, int j) {
        if((estaVacio(i,j)) && esPosicionMasBaja(i,j)){
            return true;
        }else{
            return false;
        }
    }

    public boolean esPosicionMasBaja(int i, int j){
        if((j<=NFILAS)&&(tablero[i][j+1]!=VACIO )){
            return true;
        }else{
            return false;
        }
    }

    public void juegaMaquina() {
        int i;
        int fila = -1, columna;
        Random r = new Random();

        do {
            columna = r.nextInt(NCOLUMNAS);

            for (i = 0; i < NFILAS; i++)
                if (tablero[i][columna] == VACIO) {
                    fila = i;
                    break;
                }
        } while (fila < 0);

        tablero[fila][columna] = MAQUINA;
    }
}