package ru.spaceaccordeonist.task15_10;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class Task2 {
    static long dirSize = 0;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter directory path: ");
        String path = scan.nextLine();
        Path dir = Paths.get(path);
        if(Files.exists(dir) && Files.isDirectory(dir)){
            Files.walkFileTree(dir, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    dirSize += attrs.size();
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    Main.logMessage("Can't get file size: " + file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        } else {
            Main.logMessage("No such directory!");
        }

        String size;
        if(dirSize < 8){
            size = String.format("%.0f bit", (double)dirSize);
        } else if (dirSize < 8*1024L) {
            size = String.format("%.0f byte", dirSize/(8f));
        } else if (dirSize < 8*1024*1024L) {
            size = String.format("%.0f Kb", dirSize/(1024f*8));
        } else if (dirSize < 8*1024*1024*1024L) {
            size = String.format("%.0f Mb", dirSize/(1024f*1024*8));
        } else {
            size = String.format("%.0f Gb", dirSize/(1024f*1024*1024*8));
        }
        Main.logMessage(dir + " size is " + size);
    }
}
