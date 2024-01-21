package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArraySet<T> implements SimpleSet<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        boolean status = false;
        if (!contains(value)) {
            set.add(value);
            status = true;
        }
        return status;
    }

    @Override
    public boolean contains(T value) {
        boolean status = false;
        for (T valueWithSet : set) {
            if (Objects.equals(valueWithSet, value)) {
                status = true;
                break;
            }
        }
        return status;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
