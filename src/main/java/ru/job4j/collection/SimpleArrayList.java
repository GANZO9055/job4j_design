package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        modCount++;
        if (size == container.length) {
            container = expansion(container);
        }
        container[size++] = value;
    }

    private T[] expansion(T[] array) {
        int number = array.length;
        if (number == 0) {
            number++;
        }
        return Arrays.copyOf(array, number * 2);
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        T value = container[index];
        container[index] = newValue;
        return value;
    }

    @Override
    public T remove(int index) {
        modCount++;
        Objects.checkIndex(index, size);
        T value = container[index];
        System.arraycopy(
                container,
                index + 1,
                container,
                index,
                container.length - index - 1
        );
        size--;
        container[container.length - 1] = null;
        return value;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            final int expectedModCount = modCount;
            int count;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[count++];
            }
        };
    }
}