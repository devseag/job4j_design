package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
//    public static void main(String[] args) throws IOException {
////        Path dir = Paths.get("path/paths");
////        Files.createDirectories(dir);
//////        Files.createDirectory() if other directories already exist like mkdir(), not mkdirs()
////        Path path = Path.of("path/paths/path.txt");
////        Files.createFile(path);
//
////        Path path = Path.of("path/paths/path.txt");
////        Files.createFile(path);
//
//        Path path = Path.of("path/paths/path.txt");
//        File file = path.toFile();
//        System.out.println(file);
//        Path pathAgain = file.toPath();
//        System.out.println(pathAgain);
//
//
//    }

//    public static void main(String[] args) throws IOException {
//        Path dir = Paths.get("path/paths");
//        Files.createDirectories(dir);
//        Path path = Path.of("path/paths/path.txt");
//        Files.createFile(path);
//        System.out.println("Fajl/direktorija sushhestvuet?: " + Files.exists(path));
//        System.out.println("Jeto direktorija?: " + Files.isDirectory(path));
//        System.out.println("Jeto fajl?: " + Files.isRegularFile(path));
//        System.out.println("Imja fajla: " + path.getFileName());
//        System.out.println("Put' k fajlu absoljutnyj?: " + path.isAbsolute());
//        System.out.println("Roditel'skaja direktorija fajla: " + path.getParent());
//        System.out.println("Absoljutnyj put' k fajlu: " + path.toAbsolutePath());
//        System.out.println("Absoljutnyj put' k direktorii: " + dir.toAbsolutePath());
//        System.out.println("Dostupen dlja chtenija?: " + Files.isReadable(path));
//        System.out.println("Dostupen dlja zapisi?: " + Files.isWritable(path));
//    }

//    Fajl/direktorija sushhestvuet?: true
//    Jeto direktorija?: false
//    Jeto fajl?: true
//    Imja fajla: path.txt
//    Put' k fajlu absoljutnyj?: false
//    Roditel'skaja direktorija fajla: path\paths
//    Absoljutnyj put' k fajlu: C:\projects\job4j_design\path\paths\path.txt
//    Absoljutnyj put' k direktorii: C:\projects\job4j_design\path\paths
//    Dostupen dlja chtenija?: true
//    Dostupen dlja zapisi?: true


//        public static void main(String[] args) throws IOException {
//            Path dir = Paths.get("path/paths");
//            Files.createDirectories(dir);
//            Path path = Path.of("path/paths/path.txt");
//            Files.createFile(path);
//            Files.move(path, Path.of("path/path.txt"));
//            Files.delete(dir);
//        }

    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("path/paths");
        Files.createDirectories(dir);
        Path target = Paths.get("path");
        Path path1 = Path.of("path/paths/path1.txt");
        Files.createFile(path1);
        Path path2 = Path.of("path/path2.txt");
        Files.createFile(path2);
        DirectoryStream<Path> paths = Files.newDirectoryStream(target);
        paths.forEach(System.out::println);
    }
}
