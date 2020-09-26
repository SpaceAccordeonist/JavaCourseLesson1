package ru.spaceaccordeonist.task5;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return  String.format("radius: %.2f \nperimeter: %.2f \narea: %.2f", radius, area, perimeter);
    }

    @Override
    public double getArea() {
        area = Math.PI * radius * radius;
        return super.getArea();
    }

    @Override
    public double getPerimeter() {
        perimeter = 2 * Math.PI * radius;
        return super.getPerimeter();
    }
}
