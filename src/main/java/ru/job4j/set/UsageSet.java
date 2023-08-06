package ru.job4j.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UsageSet {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
//        strings.add("two");
//        strings.addAll(List.of("one", "four", "five"));
//        Set<String> strings = Set.of("one", "two", "three");
//        for (String s : strings) {
//            System.out.println("Current element: " + s);
//        }
        strings.remove("one");
        strings.add("one");

        Iterator<String> it = strings.iterator();
        while (it.hasNext()) {
            System.out.println("Current element: " + it.next());
        }
//        strings.remove("two");
//        strings.removeAll(List.of("two", "three"));
//        strings.retainAll(List.of("one")); // Current element: one
//        strings.removeIf(s -> s.startsWith("t")); // Current element: one


//        System.out.println("Output after deletion...");
//
//        for (String s : strings) {
//            System.out.println("Current element: " + s);
//        }

//        boolean b = strings.contains("two");
//        System.out.println("Set contains element: " + b);

//        int size = strings.size();
//        System.out.println("Our set contains: " + size + " elements.");

        strings.stream()
                .filter(s -> s.length() < 5)
                .forEach(st -> System.out.println("Current element: " + st));

    }
}