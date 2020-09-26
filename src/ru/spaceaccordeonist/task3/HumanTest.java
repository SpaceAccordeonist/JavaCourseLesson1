package ru.spaceaccordeonist.task3;

import ru.spaceaccordeonist.task3.model.Human;

public class HumanTest {
    public static void main(String[] args) {
        Human john = new Human("John", 179, 77, 20, "red", "brown");
        john.introduce();
        john.walk(5);
    }
}
