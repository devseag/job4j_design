package ru.job4j.io;

import java.io.*;

public class Buffered {
    public static void main(String[] args) {
//        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("data/input.txt"));
//             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("data/output.txt"))) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("data/newData.txt"));
//        try (BufferedReader in = new BufferedReader(new FileReader("data/newData.txt"));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("data/output.txt", true))) {
            out.write(in.readAllBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}