package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private static Map<FileProperty, List<Path>> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.toFile().getName());
        ArrayList<Path> list = new ArrayList<>();
        list.add(file);
        if (map.containsKey(fileProperty)) {
            map.get(fileProperty).add(file);
        } else {
            map.put(fileProperty, list);
        }
        return super.visitFile(file, attrs);
    }

    public void getDublicates() {
        map.entrySet()
                .stream()
                .filter(s -> s.getValue().size() > 1)
                .forEach(s -> s.getValue()
                        .forEach(u -> System.out.println(u.toAbsolutePath())));
    }
}