package ru.job4j.regex;

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

        Pattern pattern = Pattern.compile("123");
        String text = "1231 i 1232 i 1233";
        Matcher matcher = pattern.matcher(text);
        String rsl = matcher.replaceAll("Job4j");
        System.out.println(rsl);



    }
}