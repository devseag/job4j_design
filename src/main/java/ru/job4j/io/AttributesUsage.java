package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

public class AttributesUsage {
    public static void main(String[] args) throws IOException {
//        Path file = Path.of("data/Attributes.txt");
//        Files.createFile(file);
//        BasicFileAttributeView attrView = Files.getFileAttributeView(file, BasicFileAttributeView.class);
//        BasicFileAttributes attributes = attrView.readAttributes();

        Path file = Path.of("data/Attributes.txt");
//        Files.createFile(file);
        BasicFileAttributes attributes = Files.readAttributes(file, BasicFileAttributes.class);
        System.out.println(attributes.getClass());
        System.out.println("Jeto obychnyj fajl? " + attributes.isRegularFile());
        System.out.println("Jeto direktorija? " + attributes.isDirectory());
        System.out.println("Jeto simvolicheskaja ssylka? " + attributes.isSymbolicLink());
        System.out.println("Jeto ne fajl, direktorija ili simvolicheskaja ssylka? " + attributes.isOther());
        System.out.println("Data sozdanija fajla: " + attributes.creationTime());
        System.out.println("Razmer fajla: " + attributes.size());
        System.out.println("Vremja poslednego dostupa: " + attributes.lastAccessTime());
        System.out.println("Vremja poslednego izmenenija: " + attributes.lastModifiedTime());
    }

//    class sun.nio.fs.WindowsFileAttributes
//    Jeto obychnyj fajl? true
//    Jeto direktorija? false
//    Jeto simvolicheskaja ssylka? false
//    Jeto ne fajl, direktorija ili simvolicheskaja ssylka? false
//    Data sozdanija fajla: 2023-08-10T18:34:35.0926571Z
//    Razmer fajla: 0
//    Vremja poslednego dostupa: 2023-08-10T18:35:30.0074085Z
//    Vremja poslednego izmenenija: 2023-08-10T18:35:30.0074085Z
}