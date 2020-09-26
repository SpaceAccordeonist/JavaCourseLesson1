package ru.spaceaccordeonist.task5;

public class Square extends Shape{
    private double size;

    public Square(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public double getArea() {
        area = size * size;
        return super.getArea();
    }

    @Override
    public double getPerimeter() {
        perimeter = 4 * size;
        return super.getPerimeter();
    }
}
