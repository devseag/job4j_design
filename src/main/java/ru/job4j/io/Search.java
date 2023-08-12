package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    //    public static void main(String[] args) throws IOException {
//        Path start = Paths.get(".");
//        Files.walkFileTree(start, new PrintFiles());
//    }
    public static void main(String[] args) throws IOException {
//        Path start = Paths.get(".");
//        search(start, p -> p.toFile().getName().endsWith(".js")).forEach(System.out::println);
//    }
        new Search().validation(args);
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile()
                .getName()
                .endsWith(args[1]))
                .forEach(System.out::println);
    }

    public void validation(String[] arg) {
        if (arg.length != 2) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar search.jar ROOT_FOLDER.");
        }
        if (!Paths.get(arg[0]).toFile().exists()) {
            throw new IllegalArgumentException("File does not exist.");
        }
        if (!Paths.get(arg[0]).toFile().isDirectory()) {
            throw new IllegalArgumentException("Not a directory.");
        }
        if (!arg[1].startsWith(".")) {
            throw new IllegalArgumentException("Not a directory.");
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}