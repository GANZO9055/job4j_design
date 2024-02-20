package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, Set<Path>> filesMap = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attributes) throws IOException {
        FileProperty fileProperty = new FileProperty(attributes.size(),
                file.getFileName().toString());

        filesMap.computeIfAbsent(fileProperty, k -> new HashSet<>()).add(file);

        return super.visitFile(file, attributes);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {

        for (Map.Entry<FileProperty, Set<Path>> entry : filesMap.entrySet()) {
            Set<Path> duplicates = entry.getValue();
            if (duplicates.size() > 1) {
                System.out.println("Duplicates: \n"
                        + entry.getKey().getName()
                        + " - "
                        + entry.getKey().getSize()
                        + " bytes");
                for (Path duplicate : duplicates) {
                    System.out.println("  " + duplicate.toAbsolutePath());
                }
                System.out.println();
            }
        }
        filesMap.clear();
        return super.postVisitDirectory(dir, exc);
    }
}
