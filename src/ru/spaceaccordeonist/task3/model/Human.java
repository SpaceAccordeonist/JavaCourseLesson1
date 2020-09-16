package ru.spaceaccordeonist.task3.model;

public class Human {
    private String name;
    private double height, weight;
    private int age;
    Head head;
    Leg leftLeg = new Leg("left");
    Leg rightLeg = new Leg("right");
    Hand leftHand = new Hand("left");
    Hand rightHand = new Hand("right");

    public Human(String name, double height, double weight, int age) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;
        head = new Head("blond", "blue");
    }

    public Human(String name, double height, double weight, int age, String hairColor, String eyeColor) {
        this(name, height, weight, age);
        head = new Head(hairColor, eyeColor);
    }

    public void walk(int times){
        for(int i = 0; i < times; i++){
            leftLeg.step();
            rightLeg.step();
        }
    }

    public void introduce(){
        System.out.println("Hello, my name is " + name + ". I'm " + age + " years old.");
    }

    private class Head{
        private String hairColor, eyesColor;

        public Head(String hairColor, String eyesColor) {
            this.hairColor = hairColor;
            this.eyesColor = eyesColor;
        }

        public String getHairColor() {
            return hairColor;
        }

        public String getEyesColor() {
            return eyesColor;
        }
    }
    private class Leg{
        public Leg(String type) {
            this.type = type;
        }
        private String type;
        public void step(){System.out.println(name + " stepped " + type + " leg.");}

        public String getType() {
            return type;
        }
    }
    private class Hand{
        public Hand(String type) {
            this.type = type;
        }
        private String type;
        private String taken;

        public void take(String obj){ taken = obj;}
        public void drop(){ taken = ""; }

        public String whatTaken() {
            return taken;
        }

        public String getType() {
            return type;
        }
    }
}
