package ru.job4j.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//public class RegexExample {
//    public static void main(String[] args) {
////        Pattern pattern = Pattern.compile("Ja uchus' na Job4j");
////        Pattern pattern = Pattern.compile("Job4j");
//
//        Pattern pattern = Pattern.compile("Job4j", Pattern.CASE_INSENSITIVE);
//
////        String text1 = "Ja uchus' na Job4j"; // false
//        String text1 = "Job4j"; // true
//        Matcher matcher1 = pattern.matcher(text1);
//        boolean isPresent1 = matcher1.matches();
//        System.out.println(isPresent1); // true
//
////        String text2 = "Ja uchus' na kurse Job4j"; // false
////        String text2 = "job4j"; // false
//        String text2 = "Ja uchus' na kurse Job4j";
//        Matcher matcher2 = pattern.matcher(text2);
//        boolean isPresent2 = matcher2.matches();
//        System.out.println(isPresent2); // false
//        boolean isPresent = matcher2.find();
//        System.out.println(isPresent); // true
//
//    }
//}

public class RegexExample {
    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("Job4j");
//        String text = "Job4j1  i Job4j2  i Job4j3";
//        Matcher matcher = pattern.matcher(text);
//        while (matcher.find()) {
////            System.out.println("Najdeno sovpadenie " + matcher.group());
//            System.out.println("Najdeno sovpadenie. iStart: " + matcher.start()
//                    + " iEnd: " + matcher.end());

//        Pattern pattern = Pattern.compile("123");
//        String text = "1231 i 1232 i 1233";
//        Matcher matcher = pattern.matcher(text);
//        String rsl = matcher.replaceAll("Job4j");
//        System.out.println(rsl);

//        Pattern pattern = Pattern.compile("11");
//        String text = "111111";
//        Matcher matcher = pattern.matcher(text);
//        while (matcher.find()) {
//            System.out.println("Najdeno sovpadenie: " + matcher.group());
//        }

//        String str = "123+=-456:/789";
//        String[] rsl = str.split("\\D+");
//        System.out.println(Arrays.toString(rsl)); // [123, 456, 789]

//        Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
//        Najdeno sovpadenie: 24.04.1987
//        Najdeno sovpadenie: 11.11.1111
//        Najdeno sovpadenie: 99.99.9999
//        Najdeno sovpadenie: 99.99.9999
//        Pattern pattern = Pattern.compile("\\b\\d{2}\\.\\d{2}\\.\\d{4}\\b");
////        Najdeno sovpadenie: 24.04.1987
////        Najdeno sovpadenie: 99.99.9999
//        String text = "24.04.1987 11.11.111111 99.99.99991 99.99.9999 99999999 0000.00.00";
//        Matcher matcher = pattern.matcher(text);
//        while (matcher.find()) {
//            System.out.println("Najdeno sovpadenie: " + matcher.group());
//        }


        Pattern pattern = Pattern.compile("\\S{1,}@\\S{1,}\\.\\S{1,}");
        String text = "peter-2022@example.com example65@mail_box.ru 123_45@example-mailbox.com";
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Najdeno sovpadenie: " + matcher.group());
        }
    }
}