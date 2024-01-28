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
        if (count >= table.length * LOAD_FACTOR) {
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
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> value : table) {
            if (value != null) {
                int number = getIndex(value.key);
                newTable[number] = value;
            }
        }
        table = newTable;
    }

    @Override
    public V get(K key) {
        V status = null;
        MapEntry<K, V> valueOne = table[getIndex(key)];
        if (trueOrFalse(valueOne, key)) {
            status = valueOne.value;
        }
        return status;
    }

    @Override
    public boolean remove(K key) {
        boolean status = false;
        MapEntry<K, V> valueTwo = table[getIndex(key)];
        if (trueOrFalse(valueTwo, key)) {
            table[getIndex(key)] = null;
            status = true;
            modCount++;
            count--;
        }
        return status;
    }

    private boolean trueOrFalse(MapEntry<K, V> value, K key) {
        boolean status = false;
        int number = getIndex(key);
        if (value != null) {
            if (number == 0 || compare(value.key.hashCode(), key.hashCode())) {
                if (compare(value.key, key)) {
                    status = true;
                }
            }
        }
        return status;
    }

    private boolean compare(Object valueOne, Object valueTwo) {
        return Objects.equals(valueOne, valueTwo);
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
