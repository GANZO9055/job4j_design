package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        validationArgs(args.length);
        validationFile(Paths.get(args[0]), args[1]);
        Path start = Paths.get(args[0]);
        search(start, path -> path.toFile()
                .getName()
                .endsWith(args[1]))
                .forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static void validationArgs(int number) {
        if (number != 2) {
            throw new IllegalArgumentException("Root folder is null. Usage  ROOT_FOLDER.");
        }
    }

    private static void validationFile(Path argOne, String argTwo) {
        if (!argOne.toFile().isDirectory()) {
            throw new IllegalArgumentException(
                    String.format("Not directory %s", argOne.toFile().getAbsoluteFile()));
        }
        if (!argTwo.startsWith(".")) {
            throw new IllegalArgumentException(String.format("Not exist %s", argTwo));
        }
    }
}