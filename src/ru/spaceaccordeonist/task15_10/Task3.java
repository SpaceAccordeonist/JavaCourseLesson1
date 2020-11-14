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


        try{
            if(!Files.exists(from) || !Files.isDirectory(from)){
                Main.logMessage("Can't reach coping directory!");
                throw new NoSuchFileException(from.toString());
            }
            if(!Files.exists(to) || !Files.isDirectory(to)){
                Main.logMessage("Can't reach destination directory!");
                throw new NoSuchFileException(to.toString());
            }
            Files.walkFileTree(from, new CopingFileVisitor(to));
            Main.logMessage("> Coping succeed!");
        } catch (IOException e){
            Main.logMessage("> Coping failed!");
            e.printStackTrace();
        }

    }
}
