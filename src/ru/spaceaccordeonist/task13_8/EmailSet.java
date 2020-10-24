package ru.spaceaccordeonist.task13_8;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class EmailSet {
    public static TreeSet<String> emails = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            String command = scanner.nextLine();
            if(!performCommand(command))
                System.out.println("Error");
        }
    }

    public static boolean performCommand(String command){
        Scanner reader = new Scanner(command);
        if(reader.hasNext()){
            switch (reader.next()){
                case "LIST":
                    for(String email : emails){
                        System.out.println(email);
                    }
                    return true;
                case "ADD":
                    if(reader.hasNext()){
                        String email = reader.next();
                        Pattern pattern = Pattern.compile("[^@]+@[^@]+\\.[^@\\.]+");
                        if(pattern.matcher(email).matches()){
                            emails.add(email);
                            return true;
                        }
                    }else
                        return false;
                default:
                    return false;
            }
        }
        return false;
    }
}
