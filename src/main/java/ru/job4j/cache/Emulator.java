package ru.job4j.cache;

import java.util.Scanner;

/**
 * Klass jemuljator raboty s keshem. Pozvoljaet pol'zovatelju zagruzit' soderzhimoe fajla v kesh,
 * vyvesti soderzhimoe kesha na jekran, udalit' soderzhimoe fajla iz kesha
 */
public class Emulator extends DirFileCache {
    public Emulator(String cachingDir) {
        super(cachingDir);
    }

    public static void main(String[] args) {
        Emulator emulator = new Emulator("C:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\cache\\");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ukazhite imja fajla:");
        String sb = emulator.get(sc.nextLine());
        System.out.println("Soderzhimoe fajla: " + sb);
    }
}