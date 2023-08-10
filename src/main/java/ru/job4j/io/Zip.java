package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static ArgsName validateArgs(String[] args) {
        ArgsName arguments = ArgsName.of(args);
        Path directory = Path.of(arguments.get("d"));
        Path output = Path.of(arguments.get("o"));
        String exclude = arguments.get("e");
        if (args.length != 3
                || directory == null
                || output == null
                || exclude == null) {
            throw new IllegalArgumentException("Some arguments are missing");
        }
        if (!Paths.get(arguments.get("d")).toFile().exists()) {
            throw new IllegalArgumentException("The directory does not exist!");
        }
        return arguments;
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
        ArgsName arsName = validateArgs(args);
        List<Path> list = Search.search(Paths.get(arsName.get("d")),
                s -> !s.toFile().getName().endsWith(arsName.get("e")));
        new Zip().packFiles(list, new File(arsName.get("o")));
    }
}