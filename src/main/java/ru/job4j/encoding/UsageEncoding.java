package ru.job4j.encoding;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

public class UsageEncoding {
    public String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.lines().map(s -> s + System.lineSeparator()).forEach(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

//    public void writeDataInFile(String path, String data) {
//        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
//            pw.println(data);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void writeDataInFile(String path, List<String> data) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            data.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        String path = "./data/text.txt";
//        UsageEncoding encoding = new UsageEncoding();
//        String s = encoding.readFile(path);
//        System.out.println("Data from file: ");
//        System.out.println(s);
//    }

    public static void main(String[] args) {
        String path = "./data/text.txt";
        UsageEncoding encoding = new UsageEncoding();
        List<String> strings = List.of(
                "Новая строка 1",
                "Новая строка 2",
                "Новая строка 3",
                "Новая строка 4",
                "Новая строка 5"
        );
//        for (String str : strings) {
//            encoding.writeDataInFile(path, str);
//        }
        encoding.writeDataInFile(path, strings);
        String s = encoding.readFile(path);
        System.out.println("Data from file: ");
        System.out.println(s);
    }
}
