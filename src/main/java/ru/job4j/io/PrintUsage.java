package ru.job4j.io;

import java.io.*;

public class PrintUsage {

//    public static void main(String[] args) {
////        try (PrintStream stream = new PrintStream(new FileOutputStream("data/print.txt"))) {
////        try (PrintStream stream = new PrintStream("data/print.txt")) {
////        File file = new File("data/print.txt");
////        try (PrintStream stream = new PrintStream(file)) {
////            stream.println("From PrintStream in FileOutputStream");
//        try (PrintStream stream = new PrintStream(new FileOutputStream("data/print.txt"))) {
//            stream.println("From PrintStream in FileOutputStream");
//            stream.write("New row".getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        try (PrintStream stream = new PrintStream(new FileOutputStream("data/print.txt"));
             PrintWriter writer = new PrintWriter("data/write.txt")) {
            stream.println("From PrintStream in FileOutputStream");
            stream.write("New row".getBytes());
            writer.println("New message");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}