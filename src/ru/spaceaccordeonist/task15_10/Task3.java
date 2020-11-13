package ru.spaceaccordeonist.task15_10;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter which directory to copy: ");
        String path = scan.nextLine();
        Path from = Paths.get(path);
        System.out.println("Enter where paste to: ");
        path = scan.nextLine();
        Path to = Paths.get(path);

        if(!Files.exists(from) || !Files.isDirectory(from)){
            Main.logMessage("Can't reach coping directory!");
        }
        if(!Files.exists(to) || !Files.isDirectory(to)){
            Main.logMessage("Can't reach destination directory!");
        }
        try{
            Files.walkFileTree(from, new CopingFileVisitor(to));
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
