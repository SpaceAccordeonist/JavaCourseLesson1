package ru.spaceaccordeonist.task15_10;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopingFileVisitor implements FileVisitor<Path> {
    private Path rootLocation = null;
    private final Path destination;
    CopingFileVisitor(Path destination){
        this.destination = destination;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if(rootLocation == null)
            rootLocation = dir;
        else {
            if (attrs.isDirectory() && !Files.exists(destination.resolve(rootLocation.relativize(dir))))
                Files.createDirectory(destination.resolve(rootLocation.relativize(dir)));
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(attrs.isRegularFile())
            Files.copy(file, destination.resolve(rootLocation.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
