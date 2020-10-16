package ru.spaceaccordeonist.task11;

public abstract class Player {
    protected String name;
    protected Game.Figure figure;

    public Player(String name, Game.Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    abstract void makeStep(Field field);

    public String getName() {
        return name;
    }

    public Game.Figure getFigure() {
        return figure;
    }
}
