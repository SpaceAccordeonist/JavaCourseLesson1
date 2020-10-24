package ru.spaceaccordeonist.task12_7;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        Pattern patternFull = Pattern.compile("[А-Яа-я\\-]+[ ][А-Яа-я\\-]+[ ][А-Яа-я\\-]+");
        Pattern patternShort = Pattern.compile("[А-Яа-я\\-]+[ ][А-Яа-я\\-]+");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if(patternFull.matcher(name).matches()){
            List<String> parts = Arrays.asList(name.split(" "));
            System.out.printf("Фамилия: %s\nИмя: %s\nОтчество: %s", parts.get(0), parts.get(1), parts.get(2));
        }else if(patternShort.matcher(name).matches()){
            List<String> parts = Arrays.asList(name.split(" "));
            System.out.printf("Фамилия: %s\nИмя: %s", parts.get(0), parts.get(1));
        } else{
            System.out.println("Введенная строка не является ФИО");
        }
    }
}
