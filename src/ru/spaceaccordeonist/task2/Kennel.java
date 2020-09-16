package ru.spaceaccordeonist.task2;

import ru.spaceaccordeonist.task2.model.Dog;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Kennel {
    static ArrayList<String> names = new ArrayList<>();
    static {
        names.add("Rufus");
        names.add("Flora");
        names.add("Fido");
        names.add("Nora");
        names.add("Luna");
        names.add("Pancake");
        names.add("Milo");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rnd = new Random(new Date().getTime());
        System.out.println("How many dogs you need?");
        int count = scan.nextInt();
        ArrayList<Dog> dogs = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            dogs.add(i ,new Dog(names.get(rnd.nextInt(names.size())), rnd.nextInt(15) + 1));
            System.out.println(dogs.get(i).toString() + "\n");
        }
    }
}
