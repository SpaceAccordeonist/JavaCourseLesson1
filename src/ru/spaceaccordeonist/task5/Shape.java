package ru.spaceaccordeonist.task5;

public abstract class Shape {
    protected Double area, perimeter;

    public Shape(){}

    public Shape(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public String toString() {
        return "area: " + area + "\n" +
                "perimeter: " + perimeter + "\n";
    }
}
