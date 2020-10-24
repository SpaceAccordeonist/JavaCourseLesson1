package ru.spaceaccordeonist.task13_8;

import ru.spaceaccordeonist.task12_7.PhoneFormatException;
import ru.spaceaccordeonist.task12_7.PhoneFormatter;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneBook {
    public static PhoneFormatter formatter = new PhoneFormatter();
    public static HashMap<String,String> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern namePattern = Pattern.compile("[А-Яа-яA-Za-z\\-\\s.]+");

        while(true){
            String command = scanner.next();
            if(command.equals("LIST")){
                for(String key: phoneBook.keySet()){
                    System.out.printf("%s %s\n", phoneBook.get(key), key);
                }
            } else {
                if(namePattern.matcher(command).matches()){
                    if(phoneBook.containsValue(command)) {
                        String phone = null;
                        for (String key : phoneBook.keySet()) {
                            if (command.equals(phoneBook.get(key))) {
                                phone = key;
                            }
                        }
                        if(phone != null)
                            System.out.printf("%s %s\n", command, phone);
                        else
                            System.out.println("No phone");
                    } else{
                        System.out.println("Enter phone: ");
                        try{
                            String phone = formatter.formatPhone(scanner.next());
                            phoneBook.put(phone, command);
                        }catch (PhoneFormatException e){
                            System.out.println("Invalid phone format");
                        }
                    }
                } else if(!command.isBlank()){
                    try{
                        command = formatter.formatPhone(command);
                        if(phoneBook.containsKey(command)) {
                            System.out.printf("%s %s\n", phoneBook.get(command) ,command );
                        } else{
                            System.out.println("Enter name: ");
                            try{
                                String name = scanner.next();
                                if(namePattern.matcher(name).matches())
                                    phoneBook.put(command, name);
                                else
                                    System.out.println("Invalid name");
                            }catch (PhoneFormatException e){
                                System.out.println("Invalid phone format");
                            }
                        }
                    } catch (PhoneFormatException e){
                        System.out.println("Invalid phone format");
                    }
                } else{
                    System.out.println("Unknown command");
                }
            }
        }
    }
}
