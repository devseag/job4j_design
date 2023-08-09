package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/dataresult.txt")) {
//            out.write("Hello, world!".getBytes());
//            out.write(System.lineSeparator().getBytes());
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    String rsl = i + " * " + j + " = " + i * j;
                    out.write(rsl.getBytes());
                    out.write(System.lineSeparator().getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}