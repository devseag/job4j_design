package ru.job4j.generics;

public class GenericsClass<K, V> {
    private K key;

    private V value;

    public GenericsClass(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "GenericsClass{"
                + "key=" + key
                + ", value=" + value
                + '}';
    }

    public static void main(String[] args) {
        GenericsClass<String, String> first = new GenericsClass<>("First key", "First value");
        System.out.println("Output: " + first);

        GenericsClass<Integer, String> second = new GenericsClass<>(12345, "Second value");
        System.out.println("Output: " + second);
    }
}