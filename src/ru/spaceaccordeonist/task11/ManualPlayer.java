package ru.spaceaccordeonist.task11;

public class ManualPlayer extends Player{
    public ManualPlayer(String name, Game.Figure figure) {
        super(name, figure);
    }

    @Override
    void makeStep(Field field) { }
}
