package ru.job4j.list;

import java.util.*;

public class ListUsage {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
//        List<String> rsl = List.of("one", "two", "three");
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
//        rsl.add(1, "four");
////        List<String> list = new ArrayList<>();
////        list.add("four");
////        list.add("five");
////
////        rsl.addAll(list);
//        List<String> list = new ArrayList<>();
//        list.add("four");
//        list.add("five");
//
//        rsl.addAll(2, list);

//        for (int i = 0; i < rsl.size(); i++) {
//            System.out.println("Current element: " + rsl.get(i));
//        }

//        Iterator<String> iterator = rsl.iterator();
//        while (iterator.hasNext()) {
//            System.out.println("Current element: " + iterator.next());
//        }

//        ListIterator<String> iterator = rsl.listIterator();
//        while (iterator.hasNext()) {
//            System.out.println("Current element: " + iterator.next());
//        }
//        for (String s : rsl) {
//            System.out.println("Current element: " + s);
//        }
//        rsl.set(1, "two and second");
//        ListIterator<String> iterator = rsl.listIterator(2);
//        while (iterator.hasNext()) {
//            System.out.println("Current element: " + iterator.next());
//        }
//        rsl.replaceAll(String::toUpperCase);
//        rsl.remove(1);
//        rsl.remove("three");
//        List<String> list = new ArrayList<>();
//        list.add("one");
//        list.add("three");

//        rsl.removeAll(list);
//        rsl.retainAll(list);
//        rsl.removeIf(s -> s.length() <= 3);

//        ListIterator<String> iterator = rsl.listIterator();
//        while (iterator.hasNext()) {
//            System.out.println("Current element: " + iterator.next());
//        }
//        boolean b = rsl.contains("two");
//
//        System.out.println("List contains: " + b);
//
//        int i = rsl.indexOf("two");
//
//        System.out.println("Index of element in list: " + i);

//        rsl.add("one");
//
//        int i = rsl.lastIndexOf("one");
//
//        System.out.println("Index of element in list: " + i);

//      //  List<Integer> rsl = List.of(1, 2, 3);
//        int size = rsl.size();
//        System.out.println("Size list: " + size);

//        List<String> list = rsl.subList(1, 2);
//        for (String s : list) {
//            System.out.println("Current element: " + s);
//        }

        rsl.sort(Comparator.reverseOrder());

        ListIterator<String> iterator = rsl.listIterator();
        while (iterator.hasNext()) {
            System.out.println("Current element: " + iterator.next());
        }

    }
}