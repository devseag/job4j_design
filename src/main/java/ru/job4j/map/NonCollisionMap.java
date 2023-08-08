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
        if (Float.valueOf(count) / capacity >= LOAD_FACTOR) {
            expand();
        }
        boolean rsl = false;
//        int index = indexFor(hash(key.hashCode()));
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    private int getIndex(K key) {
        return Objects.hashCode(key) == 0
                ? 0 : indexFor(hash(key.hashCode()));
    }

    private int hash(int hashCode) {
        return hashCode ^ hashCode >>> 16;
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] temp = table;
        table = new MapEntry[capacity];
        for (MapEntry t : temp) {
            if (t != null) {
                put((K) t.key, (V) t.value);
                count--;
            }
        }
    }

    @Override
    public V get(K key) {
//        int index = indexFor(hash(key.hashCode()));
        int index = getIndex(key);
        return table[index] != null
                && Objects.equals(key, table[index].key)
                ? table[index].value
                : null;
    }

    @Override
    public boolean remove(K key) {
//        int index = indexFor(hash(key.hashCode()));
        int index = getIndex(key);
        boolean rsl = false;
        if (table[index] != null && Objects.equals(key, table[index].key)) {
            table[index] = null;
            modCount++;
            count--;
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private int counter = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (counter < capacity && table[counter] == null) {
                    counter++;
                }
                return counter < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[counter++].key;
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


//    public static void main(String[] args) {
//        NonCollisionMap<User, Objects> nonCollisionMap = new NonCollisionMap<>();
//        System.out.println(nonCollisionMap.indexFor(8));
//    }
}