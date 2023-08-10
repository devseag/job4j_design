package ru.job4j.io;

import java.io.File;
import java.io.IOException;

//public class FileExample {
//    public static void main(String[] args) throws IOException {
////        File file = new File("file.txt");
////        File file = new File("src/main/java/ru/job4j/io/files/file.txt");
////        File file = new File("data/file.txt");
//        File directory = new File("src/main/java/ru/job4j/io/files");
//        directory.mkdir();
//        File file = new File("src/main/java/ru/job4j/io/files/file.txt");
//        file.createNewFile();
//    }
//}

public class FileExample {
    public static void main(String[] args) throws IOException {
        File directory = new File("src/main/java/ru/job4j/io/files");
        directory.mkdir();
        File file = new File("src/main/java/ru/job4j/io/files/file.txt");
        file.createNewFile();
        System.out.println("Fajl/direktorija sushhestvuet?: " + file.exists());
        System.out.println("Jeto direktorija?: " + file.isDirectory());
        System.out.println("Jeto fajl?: " + file.isFile());
        System.out.println("Imja fajla: " + file.getName());
        System.out.println("Put' k fajlu: " + file.getPath());
        System.out.println("Put' k fajlu absoljutnyj?: " + file.isAbsolute());
        System.out.println("Otnositel'nyj put' k roditel'skoj direktorii fajla: " + file.getParent());
        System.out.println("Absoljutnyj put' k fajlu: " + file.getAbsoluteFile());
        System.out.println("Absoljutnyj put' k direktorii: " + directory.getAbsolutePath());
        System.out.println("Dostupen dlja chtenija?: " + file.canRead());
        System.out.println("Dostupen dlja zapisi?: " + file.canWrite());
        System.out.println("Dlina fajla: " + file.length());
        File newFile = new File("src/main/java/ru/job4j/io/files/newFile.txt");
        System.out.println("Pereimenovanie fajla v newFile. Uspeshno?: " + file.renameTo(newFile));
    }
}