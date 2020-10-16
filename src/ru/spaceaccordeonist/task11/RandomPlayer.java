package ru.spaceaccordeonist.task11;

import java.util.Date;
import java.util.Random;

public class RandomPlayer extends Player{
    Random rnd;
    public RandomPlayer(String name, Game.Figure figure) {
        super(name, figure);
        rnd = new Random(new Date().getTime());
    }

    @Override
    void makeStep(Field field) {
        Main.loader.doClick(rnd.nextInt(3), rnd.nextInt(3));
    }
}
