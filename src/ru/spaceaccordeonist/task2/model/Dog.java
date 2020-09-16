package ru.spaceaccordeonist.task2.model;

public class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public static int getHumanizedAge(int age){
        return age * 7;
    }

    @Override
    public String toString() {
        return "name: " + name + "\n" +
                "age: " + age;
    }
}
