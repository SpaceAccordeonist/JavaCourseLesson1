package ru.spaceaccordeonist.task2.model;

public class Shape {
    private String name;
    private Double area, perimeter;

    public Shape(String name, Double area, Double perimeter) {
        this.name = name;
        this.area = area;
        this.perimeter = perimeter;
    }

    public String getName() {
        return name;
    }

    public Double getArea() {
        return area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    @Override
    public String toString() {
        return "name: " + name + "\n" +
                "area: " + area + "\n" +
                "perimeter: " + perimeter + "\n";
    }
}
