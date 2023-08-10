package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

//public class ResultFile {
//    public static void main(String[] args) {
//        try (FileOutputStream out = new FileOutputStream("data/dataresult.txt")) {
////            out.write("Hello, world!".getBytes());
////            out.write(System.lineSeparator().getBytes());
//            for (int i = 1; i <= 9; i++) {
//                for (int j = 1; j <= 9; j++) {
//                    String rsl = i + " * " + j + " = " + i * j;
//                    out.write(rsl.getBytes());
//                    out.write(System.lineSeparator().getBytes());
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

public class ResultFile {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("data/result.txt")
                ))) {
            out.println("Hello, world!");
            out.printf("%s%n", "Some string");
            out.printf("%d%n", 10);
            out.printf("%f%n", 1.5f);
//            out.printf("%s", System.lineSeparator());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}