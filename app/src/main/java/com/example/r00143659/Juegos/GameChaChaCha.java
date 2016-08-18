package com.example.r00143659.Juegos;

/**
 * Created by R00143659 on 29/07/2016.
 */
public class GameChaChaCha {
    int SIZE = 7;
    private int grid[][];
    private static final int CROSS[][]={
            {0, 0, 1, 1, 1, 0, 0},
            {0, 0, 1, 1, 1, 0, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 0, 0},
            {0, 0, 1, 1, 1, 0, 0}
    };
    private static final int BOARD[][]={
            {0, 0, 1, 1, 1, 0, 0},
            {0, 0, 1, 1, 1, 0, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 0, 0},
            {0, 0, 1, 1, 1, 0, 0}
    };
    private int pickedI, pickedJ; //Coordenada de la ficha que se quiere mover
    private int jumpedI, jumpedJ; //Coordenada de la ficha que se ha saltado

    private enum State{READY_TO_PICK, READY_TO_DROP, FINISHED};
    // Ready to pick: Antes de pulsar una ficha que se quiera mover
    //Ready to drop: espera que indiquemos donde dejar una ficha
    //Finished: no es posible mover ninguna ficha
    private State gameState;

    //Constructor de la clase
    public GameChaChaCha(){
        //Inicializacion del estado del juego
        grid = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = CROSS[i][j];
            }
        }
        gameState = State.READY_TO_PICK; //Inicializar el juego con ready to pick
    }

    public int getGrid(int i, int j){
        return grid[i][j];
    }
    //Para comprobar si se puede efectuar el salto
    public boolean isAvailable(int i1, int j1, int i2, int j2){
        if(grid[i1][j1]==0 || grid[i2][j2]==1){
            return false;
        }
        if(Math.abs(i2-i1)==2 && j1==j2){
            if(i2 < i1){
                jumpedI = i2 + 1;
            }else{
                jumpedI = i1 + 1;
            }
            jumpedJ = j1;
            if (grid[jumpedI][jumpedJ] ==1){
                return true;
            }
        }
        if(Math.abs(j2-j1)==2 && i1 == i2){
            jumpedI = i1;
            if(j2 < j1){
                jumpedJ = j2 + 1;
            }else{
                jumpedJ = j1 + 1;
            }
            if (grid[jumpedI][jumpedJ] ==1){
                return true;
            }
        }
        return false;
    }
    //Que hacer cuando se pulsa un boton de la pantalla
    public void play(int i, int j){
        if(gameState == State.READY_TO_PICK){
            //Si esta escogiendo el origen, set picked las coordenadas de la pulascion/boton pulsado
            pickedI = i;
            pickedJ = j;
            gameState = State.READY_TO_DROP;
        }else if(gameState == State.READY_TO_DROP){
            //Si esta escogiendo donde quiere que vaya, chequear si puede hacer el movimiento
            if(isAvailable(pickedI, pickedJ, i, j)){
                gameState = State.READY_TO_PICK;
                grid[pickedI][pickedJ] = 0;
                grid[jumpedI][jumpedJ] = 0;
                grid[i][j] = 1;
            // Comprueba que hay mas movimientos posibles
                if(isGameFinished()){
                    gameState = State.FINISHED;
                }
            }
            //Si no puede hacer el movimiento, el destino es el nuevo origen
            else{
                pickedI = i;
                pickedJ= j;
            }

        }
    }
    public boolean isGameFinished(){
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++) {
                for (int p = 0; p < SIZE; p++){
                    for (int q = 0; q < SIZE; q++) {
                        if(grid[i][j] == 1 && grid[p][q] == 0 && BOARD[p][q] == 1){
                            if(isAvailable(i,j,p,q)){
                                return false;
                            }
                        }

                    }
                }
            }
        }
        return true;
    }
    public String gridToString (){
        String str = "";
        for (int i=0; i<SIZE; i++)
            for (int j=0; j<SIZE; j++)
                str += grid[i][j];
        return str;
    }

    public void stringToGrid (String str){
        for (int i=0, cont=0; i<SIZE; i++)
            for (int j=0; j<SIZE; j++)
                grid[i][j] = str.charAt(cont++)-'0';
    }
}
