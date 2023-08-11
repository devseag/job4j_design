package ru.job4j.io.scanner;

import ru.job4j.io.ArgsName;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        Path path = Paths.get(argsName.get("path"));
        String delimiter = argsName.get("delimiter");
        String[] filters = argsName.get("filter").split(",");
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(path.toFile());
             PrintWriter writer = new PrintWriter(argsName.get("out").equals("stdout")
                     ? System.out
                     : new FileOutputStream(argsName.get("out")))) {
            if (scanner.hasNext()) {
                String[] separateFilter = scanner.nextLine().split(delimiter);
                List<Integer> listCount = Arrays.stream(filters)
                        .map(s -> new ArrayList<>(Arrays.asList(separateFilter))
                                .indexOf(s))
                        .collect(Collectors.toList());
                listCount.forEach(s -> stringBuilder.append(separateFilter[s])
                        .append(delimiter));
                writer.print(stringBuilder.deleteCharAt(stringBuilder.length() - 1)
                        + System.lineSeparator());
                while (scanner.hasNextLine()) {
                    StringBuilder str = new StringBuilder();
                    String[] lines = scanner.nextLine().split(delimiter);
                    listCount.forEach(s -> str.append(lines[s]).append(delimiter));
                    writer.println(str.deleteCharAt(str.length() - 1));
                }
            }
        }
    }

    private static String[] validate(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar search.jar ROOT_FOLDER.");
        }
        Path start = Paths.get(ArgsName.of(args).get("path"));
        if (!start.toFile().exists()) {
            throw new IllegalArgumentException("The file does not exist");
        }
        if (!start.toFile().isFile()) {
            throw new IllegalArgumentException("The file is not a file");
        }
        if (!ArgsName.of(args).get("delimiter").equals(";")
                && !ArgsName.of(args).get("delimiter").equals(",")) {
            throw new IllegalArgumentException("Wrong delimiter.");
        }
        if (ArgsName.of(args).get("filter").isEmpty()) {
            throw new IllegalArgumentException("No filter argument(s)");
        }
        return args;
    }

    public static void main(String[] args) throws Exception {
        String[] arg = validate(args);
        ArgsName argsName = ArgsName.of(arg);
        handle(argsName);
    }
}