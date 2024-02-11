package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() throws FileNotFoundException {
        return new BufferedReader(new FileReader(file))
                .lines()
                .filter(value -> value.contains(" 404 "))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws FileNotFoundException {
        LogFilter logFilter = new LogFilter("data/log.txt");
        logFilter.filter().forEach(System.out::println);
    }
}