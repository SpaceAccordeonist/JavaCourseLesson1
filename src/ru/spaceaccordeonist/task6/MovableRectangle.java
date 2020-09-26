package ru.spaceaccordeonist.task6;

import ru.spaceaccordeonist.task5.Rectangle;

public class MovableRectangle extends Rectangle implements Movable {
    private MovablePoint upperLeft, bottomRight;

    public MovableRectangle(double width, double height){
        super(width, height);
        upperLeft = new MovablePoint(0, 0);
        upperLeft = new MovablePoint(width, height);
    }

    public MovablePoint getUpperLeft() {
        return upperLeft;
    }

    public MovablePoint getBottomRight() {
        return bottomRight;
    }

    @Override
    public void move(Vector vector) {
        upperLeft.move(vector);
        bottomRight.move(vector);
    }
}
