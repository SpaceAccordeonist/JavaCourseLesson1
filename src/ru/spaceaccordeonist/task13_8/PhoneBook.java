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
                    System.out.printf("%s %s\n", key, phoneBook.get(key));
                }
            }else {
                if(namePattern.matcher(command).matches()){
                    if(phoneBook.containsKey(command))
                        System.out.printf("%s %s\n", command, phoneBook.get(command));
                    else{
                        System.out.println("Enter phone: ");
                        try{
                            String phone = formatter.formatPhone(scanner.next());
                            phoneBook.put(command, phone);
                        }catch (PhoneFormatException e){
                            System.out.println("Invalid phone format");
                        }
                    }
                } else if(!command.isBlank()){
                    try{
                        command = formatter.formatPhone(command);
                        String name = null;
                        for (String key : phoneBook.keySet()){
                            if(command.equals(phoneBook.get(key))){
                                name = key;
                                break;
                            }
                        }
                        if(name != null){
                            System.out.printf("%s %s\n", name,command);
                        } else{
                            System.out.println("No such phone");
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
