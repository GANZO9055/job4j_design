package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        int number = nodes.size();
        int count = 0;
        while (source.hasNext()) {
            if (number > 1) {
                for (int i = 0; i < number; i++) {
                    if (count == i || count == i + number) {
                        nodes.get(i).add(source.next());
                    }
                    if (i == number - 1) {
                        count++;
                    }
                }
            } else {
                nodes.get(0).add(source.next());
            }
        }
    }
}