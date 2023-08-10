package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (values.get(key) == null) {
            throw new IllegalArgumentException("Does not exist");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        Arrays.stream(args)
                .peek(s -> {
                    if (!s.startsWith("-")
                            || !s.contains("=")) {
                        throw new IllegalArgumentException("Not correct request");
                    }
                })
                .map(s -> s.split("=", 2))
                .peek(s -> {
                    if (s[0].isEmpty() || s[1].isEmpty()) {
                        throw new IllegalArgumentException("Key or value are null");
                    }
                })
                .forEach(s -> values.put(s[0].substring(1), s[1]));
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Do not have arguments");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx====512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));

        ArgsName zip2 = ArgsName.of(new String[]{"-encoding=UTF-8", "-out="});
        System.out.println(zip2.get("out"));
    }
}