package ru.spaceaccordeonist.task15_10;

import com.sun.source.tree.Tree;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.TreeSet;

public class Task2 {
    static long dirSize = 0;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter directory path: ");
        String path = scan.nextLine();
        Path dir = Paths.get(path);
        if(Files.exists(dir) && Files.isDirectory(dir)){
            Files.walkFileTree(dir, new TreeSet<>(), Integer.MAX_VALUE , new FileVisitor<Path>() {
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
        if (dirSize < 1024L) {
            size = String.format("%d byte", dirSize);
        } else if (dirSize < 1024*1024L) {
            size = String.format("%.1f Kb", (double)dirSize/(1024d));
        } else if (dirSize < 1024*1024*1024L) {
            size = String.format("%.1f Mb", (double)dirSize/(1024d*1024d));
        } else {
            size = String.format("%.1f Gb", (double)dirSize/(1024d*1024d*1024d));
        }
        Main.logMessage(dir + " size is " + size);
    }
}
