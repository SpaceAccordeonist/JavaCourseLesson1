package ru.spaceaccordeonist.task5;

public class Rectangle extends Shape{
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        area = width * height;
        return super.getArea();
    }

    @Override
    public double getPerimeter() {
        perimeter = 2 * width + 2 * height;
        return super.getPerimeter();
    }
}
