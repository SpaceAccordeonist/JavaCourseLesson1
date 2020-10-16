package ru.spaceaccordeonist.task11;

public class Field {
    private final Game.Figure[][] gameField = new Game.Figure[3][3];
    public Field(){
        for (int x = 0; x < 3; x++) {
            gameField[x] = new Game.Figure[3];
            for (int y = 0; y < 3; y++) {
                gameField[x][y] = Game.Figure.NONE;
            }
        }
    }

    public boolean setFigure(int x, int y, Game.Figure figure){
        if(x < 3 && y < 3 && gameField[x][y] == Game.Figure.NONE){
            gameField[x][y] = figure;
            return true;
        }
        return false;
    }

    public Game.Figure[][] getGameField() {
        return gameField;
    }

    public int isWon(Player player){
        for (int x = 0; x < 3; x++) {
            if(gameField[x][0] == player.figure
                    && gameField[x][1] == player.figure
                    && gameField[x][2] == player.figure)
                return 1;
            if(gameField[0][x] == player.figure
                    && gameField[1][x] == player.figure
                    && gameField[2][x] == player.figure)
                return 1;
        }
        if(gameField[0][0] == player.figure
                && gameField[1][1] == player.figure
                && gameField[2][2] == player.figure)
            return 1;

        if(gameField[0][2] == player.figure
                && gameField[1][1] == player.figure
                && gameField[2][0] == player.figure)
            return 1;

        for (Game.Figure[] line: gameField) {
            for(Game.Figure cell: line){
                if(cell == Game.Figure.NONE)
                    return -1;
            }
        }

        return 0;
    }
}
