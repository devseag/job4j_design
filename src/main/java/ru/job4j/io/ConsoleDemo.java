package ru.job4j.io;

import java.io.Console;
import java.util.Arrays;

public class ConsoleDemo {

    public static void main(String[] args) {
        String login;
        char[] charPassword;
        Console console = System.console();
        if (console == null) {
            System.out.println("Konsol' nedostupna");
            return;
        }
        login = console.readLine("%s", "Vvedite login: ");
        console.printf("Vash login: %s\n", login);
        charPassword = console.readPassword("%s", "Vvedite parol': ");
        System.out.println("Vash parol': " + String.valueOf(charPassword));
        Arrays.fill(charPassword, ' ');
    }

}