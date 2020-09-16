package ru.spaceaccordeonist.task2.model;

public class Shape {
    protected String name;
    protected Double area, perimeter;

    public Shape(String name) {
        this.name = name;
    }

    public Shape(String name, double area, double perimeter) {
        this.name = name;
        this.area = area;
        this.perimeter = perimeter;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public String toString() {
        return "name: " + name + "\n" +
                "area: " + area + "\n" +
                "perimeter: " + perimeter + "\n";
    }
}
