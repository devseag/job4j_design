package ru.job4j.io;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class Dir {
    public static void main(String[] args) {
//        File file = new File("c:\\projects");
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage  ROOT_FOLDER.");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subfile : file.listFiles()) {

            System.out.println(subfile.getAbsoluteFile());
        }
        Arrays.stream(Objects.requireNonNull(file.listFiles()))
                .forEach(s -> System.out.printf("Name: %s, size: %s%n", s.getName(), s.getAbsoluteFile().length()));

    }
}