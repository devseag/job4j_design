package ru.job4j.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.regex.Pattern;


public class FileSearcher {

    public void validate(String[] args) {
        ArgsName arguments = ArgsName.of(args);
        if (args.length != 4
                || arguments.get("d") == null
                || arguments.get("n") == null
                || arguments.get("t") == null
                || arguments.get("o") == null) {
            throw new IllegalArgumentException("Wrong arguments."
                    + "Example -> java -jar target/find.jar -d=C:/ -n=*.?xt -t=mask -o=data/Log.txt"
                    + "-d\" - directory for searching"
                    + "-n\" - file name, mask, or regular expression"
                    + "-t\" - searching type"
                    + "-o\" - file with result");
        }

        if (!Paths.get(arguments.get("d")).toFile().exists()) {
            throw new IllegalArgumentException("The directory does not exist");
        }
        if (!Paths.get(arguments.get("d")).toFile().isDirectory()) {
            throw new IllegalArgumentException("This is not a directory");
        }
        if (!arguments.get("t").equals("mask")
                && !arguments.get("t").equals("name")
                && !arguments.get("t").equals("regex")) {
            throw new IllegalArgumentException("Wrong search type, it must be: mask, name or regex.");
        }
    }

    public Predicate<Path> getPredicate(String type, String path) {
        Predicate<Path> predicate = null;
        if ("mask".equals(type)) {
            String mask = path.replaceAll("\\*", ".\\*");
            String finalMask = mask.replaceAll("\\?", ".\\?");
            Pattern pattern = Pattern.compile(finalMask);
            predicate = p -> pattern.matcher(p.toFile().getName()).matches();
        } else if ("regex".equals(type)) {
            Pattern pattern = Pattern.compile(path);
            predicate = p -> pattern.matcher(p.toFile().getName()).matches();
        } else if ("name".equals(type)) {
            predicate = p -> p.toFile().getName().equals(path);
        }
        return predicate;
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        FileSearcher fileSearcher = new FileSearcher();
        fileSearcher.validate(args);
        SearchFiles searchFiles = new SearchFiles(fileSearcher.getPredicate(argsName.get("t"), argsName.get("n")));
        Files.walkFileTree(Paths.get(argsName.get("d")), searchFiles);
        try (PrintWriter printWriter = new PrintWriter(argsName.get("o"))) {
            searchFiles.getPaths().forEach(printWriter::println);
        }
    }
}