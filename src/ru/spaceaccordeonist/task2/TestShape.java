package ru.spaceaccordeonist.task2;

import ru.spaceaccordeonist.task2.model.Shape;

public class TestShape {
    public static void main(String[] args) {
        Shape shape = new Shape("Triangle",  6d, 12d);
        System.out.println(shape.toString());
    }
}
