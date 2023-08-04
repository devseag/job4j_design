package ru.job4j.generics;

import java.util.*;

public class GenericUsage {

    public void printRsl(Collection<?> col) {
        for (Iterator<?> iterator = col.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Current element: " + next);
        }
    }

    public void printInfo(Collection<? extends Person> col) {
        for (Iterator<? extends Person> it = col.iterator(); it.hasNext();) {
            Person next = it.next();
            System.out.println(next);
        }
    }

    public void addAll(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        for (Object line : list) {
            System.out.println("Current element: " + line);
        }
    }

    public static void main(String[] args) {
//        List list = new ArrayList();
//        list.add("first");
//        list.add("second");
//        list.add("third");
////        for (int i = 0; i < list.size(); i++) {
////            String line = (String) list.get(i);
////            System.out.println("Current element: " + line);
////        }
//        list.add(new Person("name", 21, new Date(913716000000L)));
//        System.out.println("Number of elements in list: " + list.size());
//        for (int i = 0; i < list.size(); i++) {
//            String line = (String) list.get(i);
//            System.out.println("Current element: " + line);
//        }

//        List<Integer> list = List.of(1, 2, 3, 4, 5);
//        new GenericUsage().printRsl(list);

//        List<Person> per = List.of(new Person("name", 21, new Date(913716000000L)));
//        new GenericUsage().printInfo(per);
//
//        List<Programmer> pro = List.of(new Programmer("name123", 23, new Date(913716000000L)));
//        new GenericUsage().printInfo(pro);

        List<? super Integer> list = new ArrayList<>();
        new GenericUsage().addAll(list);
    }
}