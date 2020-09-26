package ru.spaceaccordeonist.task6;

public class MovablePoint implements Movable {
    double x, y;

    public MovablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public void move(Vector vector) {
        x += vector.getX();
        y += vector.getY();
    }
}
