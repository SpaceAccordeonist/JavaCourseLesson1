package ru.spaceaccordeonist.task11;

import java.util.Arrays;

public class TacticalPlayer extends Player{
    public TacticalPlayer(String name, Game.Figure figure) {
        super(name, figure);
    }

    @Override
    void makeStep(Field field) {
        int[][] biases = new int[3][3];
        Game.Figure[][] gameFiled = field.getGameField();
        for(int i = 0; i < 3; i++){
            biases[i] = new int[3];
        }

        //Horizontal lines
        for(int x = 0; x < 3; x++){
            biases[x] = getWeight(gameFiled[x]);
        }
        //Vertical lines
        for(int y = 0; y < 3; y++){
            Game.Figure[] temp = {gameFiled[0][y], gameFiled[1][y],gameFiled[2][y]};
            int[] weights = getWeight(temp);
            for(int i = 0; i < 3; i++){
                biases[i][y] += weights[i];
            }
        }
        //Diagonals
        Game.Figure[] tempMain = {gameFiled[0][0], gameFiled[1][1],gameFiled[2][2]};
        Game.Figure[] tempAdverse = {gameFiled[0][2], gameFiled[1][1],gameFiled[2][0]};
        int[] weightsMain = getWeight(tempMain);
        int[] weightsAdverse = getWeight(tempAdverse);
        for(int x = 0; x < 3; x++){
            biases[x][x] += weightsMain[x];
            biases[x][2-x] += weightsAdverse[x];
        }

        //Find maximum
        int max = -1;
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                if(biases[x][y] > max)
                    max = biases[x][y];
            }
        }

        //Make step
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                if(biases[x][y] == max) {
                    Main.loader.doClick(x, y);
                    return;
                }
            }
        }
    }

    private int[] getWeight(Game.Figure[] line){
        int countNone = 0;
        int countRound = 0;
        int countCross = 0;
        int[] result = new int[3];
        for(Game.Figure current: line){
            switch (current){
                case ROUND:
                    countRound++;
                    break;
                case CROSS:
                    countCross++;
                    break;
                case NONE:
                    countNone++;
                    break;
            }
        }
        if(countNone == 2){
            for(int i = 0; i < 3; i++){
                if(line[i] == Game.Figure.NONE){
                    result[i] = 1;
                }
            }
        } else if(countNone == 1){
            if(countCross != countRound)
                for(int i = 0; i < 3; i++){
                    if(line[i] == Game.Figure.NONE){
                        result[i] = 5;
                    }
                }
        }
        return result;
    }
}
