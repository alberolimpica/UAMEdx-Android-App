package com.example.r00143659.Juegos;

import java.util.Random;

public class GameConecta4 {
    static final int NFILAS = 6;
    static final int NCOLUMNAS = 7;
    static final int FIL = 3;
    static final int COL = 4;
    static final int VACIO = 0;
    static final int MAQUINA = 1;
    static final int JUGADOR = 2;

    private int tablero[][];

    public GameConecta4() {
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

    public boolean comprobarFilas(int turno){

        for(int x = 0; x<NCOLUMNAS; x++) {
            for(int y = 0; y<FIL; y++) {

            if (tablero[y][x] == turno) {
                if (tablero[y + 1][x] == turno) {
                    if (tablero[y + 2][x] == turno) {
                        if (tablero[y + 3][x] == turno) {
                            return true;
                        }
                    }
                }
            }
        }
    }
    return false;
    }
    public boolean comprobarColumnas(int turno){
        for(int x = 0; x<NFILAS; x++) {
            for(int y = 0; y<COL; y++) {
            if (tablero[x][y] == turno) {
                if (tablero[x][y + 1] == turno) {
                    if (tablero[x][y + 2] == turno) {
                        if (tablero[x][y + 3] == turno) {
                            return true;
                        }
                    }
                }
            }
        }
    }
        return false;
    }
    public boolean comprobarDiagonal(int turno){
        for(int x = 0; x<FIL; x++) {
            for(int y = 0; y<COL; y++) {
                if (tablero[x][y] == turno) {
                    if (tablero[x+1][y + 1] == turno) {
                        if (tablero[x+2][y + 2] == turno) {
                            if (tablero[x+3][y + 3] == turno) {
                                return true;
                            }
                        }
                    }
                } else if (tablero[x][y] == turno) {
                    if (tablero[x-1][y - 1] == turno) {
                        if (tablero[x-2][y - 2] == turno) {
                            if (tablero[x-3][y - 3] == turno) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean comprobarCuatro(int turno){
        if(comprobarDiagonal(turno)){
            return true;

        }else if(comprobarColumnas(turno)){
            return true;

        }else if(comprobarFilas(turno)){
            return true;

        }else{
            return false;
        }
    }

    public boolean sePuedeColocarFicha(int i, int j) {
        if(estaVacio(i,j)){
            if( i==0||!estaVacio((i-1),j)){
                return true;
            }else{return false;}
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