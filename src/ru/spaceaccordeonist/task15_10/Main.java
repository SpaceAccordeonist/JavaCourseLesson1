package ru.spaceaccordeonist.task15_10;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void logMessage(String message){
        Path logPath = Paths.get("logs/log.txt");

        try {
            if (!Files.exists(logPath.getParent())) {
                Files.createDirectory(logPath.getParent());
            }
            if (!Files.exists(logPath)) {
                Files.createFile(logPath);
            }

            PrintWriter writer = new PrintWriter(new FileOutputStream(logPath.toFile(), true));

            writer.append(message).append("\n");
            writer.flush();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        logMessage("Hello, log!");
    }
}
