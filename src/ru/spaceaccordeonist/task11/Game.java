package ru.spaceaccordeonist.task11;

import java.lang.reflect.GenericArrayType;

public class Game {
    private Field gameField;
    private Player player1, player2, currentPlayer;
    private GameOverListener gameOverListener;


    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = this.player1;
        gameField = new Field();
    }

    enum Figure{CROSS, ROUND, NONE}

    private void activatePlayer(Player player){
        currentPlayer = player;
        currentPlayer.makeStep(gameField);
    }

    public void step(int x, int y){
        if(gameField.setFigure(x, y, currentPlayer.figure)){
            switch(gameField.isWon(currentPlayer)) {
                case 1:
                    gameOverListener.gameover(currentPlayer.name + " wins");
                    break;
                case -1:
                    if (currentPlayer == player1)
                        activatePlayer(player2);
                    else if (currentPlayer == player2)
                        activatePlayer(player1);
                    break;
                case 0:
                    gameOverListener.gameover("It's draw");
                    break;
            }
        } else {
            activatePlayer(currentPlayer);
        }
    }

    public Field getGameField() {
        return gameField;
    }

    public void setGameOverListener(GameOverListener gameOverListener){
        this.gameOverListener = gameOverListener;
    }

    public void refresh(){
        gameField = new Field();
        currentPlayer = player1;
    }
}
