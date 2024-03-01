package ru.job4j.io;

import java.io.*;
import java.util.*;

public class CSVReader {
    private static String path;
    private static String delimiter;
    private static String out;
    private static String filter;

    private static List<List<String>> readFile() {
        List<List<String>> values = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(delimiter)) {
                    values.add(List.of(line.split(delimiter)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;
    }

    private static List<Integer> filters(List<String> element) {
        String[] strings = filter.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String value : strings) {
            numbers.add(element.indexOf(value));
        }
        return numbers;
    }

    public static void handle(ArgsName argsName) {
        path = argsName.get("path");
        delimiter = argsName.get("delimiter");
        out = argsName.get("out");
        filter = argsName.get("filter");
        List<List<String>> tables = readFile();
        List<Integer> indexes = filters(tables.get(0));
        try {
            PrintStream printStream = null;
            if ("stdout".equals(out)) {
                printStream = System.out;
            } else {
                printStream = new PrintStream(out);
            }
            for (List<String> table : tables) {
                for (Integer index : indexes) {
                    printStream.print(table.get(index));
                    if (!index.equals(indexes.get(indexes.size() - 1))) {
                        printStream.print(delimiter);
                    }
                }
                printStream.println();
            }
            printStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("Incorrect data");
        }
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}
