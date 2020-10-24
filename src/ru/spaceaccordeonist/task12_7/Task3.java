package ru.spaceaccordeonist.task12_7;

import java.util.Scanner;

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
