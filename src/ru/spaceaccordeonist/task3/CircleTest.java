package ru.spaceaccordeonist.task3;

import ru.spaceaccordeonist.task3.model.Circle;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle(24d);
        System.out.println(circle.toString());
        circle.setRadius(50d);

        System.out.println("------------");
        System.out.println(circle.toString());
    }
}
