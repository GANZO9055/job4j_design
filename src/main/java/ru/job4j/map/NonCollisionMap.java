package ru.job4j.map;

import java.util.*;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean status = false;
        if (table.length * LOAD_FACTOR == count) {
            expand();
        }
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            status = true;
        }
        return status;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }
    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        MapEntry<K, V>[] newTable = new MapEntry[capacity * 2];
        for (MapEntry<K, V> value : table) {
            if (value != null) {
                int number = hash(Objects.hashCode(value.key)) & ((newTable.length) - 1);
                newTable[number] = value;
            }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        V status = null;
        int number = getIndex(key);
        MapEntry<K, V> numberOne = table[getIndex(key)];
        if (numberOne != null) {
            if (number == 0 || Objects.equals(numberOne.key.hashCode(), key.hashCode())) {
                if (Objects.equals(numberOne.key, key)) {
                    status = numberOne.value;
                }
            }
        }
        return status;
    }

    @Override
    public boolean remove(K key) {
        boolean status = false;
        int number = getIndex(key);
        MapEntry<K, V> numberTwo = table[number];
        if (numberTwo != null) {
            if (number == 0 || Objects.equals(numberTwo.key.hashCode(), key.hashCode())) {
                if (Objects.equals(numberTwo.key, key)) {
                    table[getIndex(key)] = null;
                    status = true;
                    modCount++;
                    count--;
                }
            }
        }
        return status;
    }

    private int getIndex(K key) {
        return indexFor(hash(Objects.hashCode(key)));
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {

            final int expectedModCount = modCount;
            private int index;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
