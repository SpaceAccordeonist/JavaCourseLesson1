package ru.spaceaccordeonist.task13_8;

import java.util.ArrayList;
import java.util.Scanner;

public class BusinessList {
    public static ArrayList<String> businesses = new ArrayList<>();

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
                    for(int i = 0; i < businesses.size(); i++){
                        System.out.printf("%d - %s\n", i, businesses.get(i));
                    }
                    return true;
                case "ADD":
                    if(reader.hasNext()){
                        String operand = reader.next();
                        try {
                            int id = Integer.parseInt(operand);
                            if(reader.hasNext()){
                                if(id < businesses.size() && id >= 0)
                                    businesses.add(id, reader.next());
                                else
                                    businesses.add(reader.next());
                                return true;
                            }else return false;
                        }catch (NumberFormatException e){
                            businesses.add(operand);
                            return true;
                        }
                    }else
                        return false;
                case "EDIT":
                    if(reader.hasNext()){
                        String operand = reader.next();
                        try {
                            int id = Integer.parseInt(operand);
                            if(reader.hasNext()){
                                if(id < businesses.size() && id >= 0) {
                                    businesses.set(id,reader.next());
                                    return true;
                                }
                                else
                                    return false;
                            }else return false;
                        }catch (NumberFormatException e){
                            return false;
                        }
                    }else
                        return false;
                case "DELETE":
                    if(reader.hasNext()){
                        String operand = reader.next();
                        try {
                            int id = Integer.parseInt(operand);
                            if(id < businesses.size() && id >= 0) {
                                businesses.remove(id);
                                return true;
                            }
                            else return false;
                        }catch (NumberFormatException e){
                            return false;
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
