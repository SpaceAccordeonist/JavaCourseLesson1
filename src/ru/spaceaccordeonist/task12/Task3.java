package ru.spaceaccordeonist.task12;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.nextLine();

        PhoneFormatter formatter = new PhoneFormatter();
        try{
            phone = formatter.formatPhone(phone);
            System.out.println(phone);
        } catch (PhoneFormatException e){
            System.out.println(e.getMessage());
        }

    }
}
