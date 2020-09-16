package ru.spaceaccordeonist.task3.model;

import ru.spaceaccordeonist.task2.model.Shape;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        area = radius * radius * Math.PI;
        perimeter = 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return  String.format("radius: %.2f \nperimeter: %.2f \narea: %.2f", radius, area, perimeter);
    }
}
