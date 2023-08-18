package ru.job4j.ood.isp.menu.print;

import ru.job4j.ood.isp.menu.models.ActionDelegate;
import ru.job4j.ood.isp.menu.models.Menu;
import ru.job4j.ood.isp.menu.SimpleMenu;

public class ConsoleMenuPrinter implements MenuPrinter {
    private final String divider = " ";

    @Override
    public void print(Menu menu) {
        menu.forEach(i -> {
            String number = i.getNumber();
            if (number.length() == 2) {
                System.out.printf("%s%s%s%s", number, divider, i.getName(), System.lineSeparator());
            } else {
                String repeated = "----".repeat(i.getNumber().length() / 2 - 1);
                System.out.printf("%s%s%s%s%s%s", repeated, divider, number, divider, i.getName(), System.lineSeparator());
            }
        });
    }

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        final ActionDelegate STUB_ACTION = System.out::println;
        menu.add(Menu.ROOT, "Shodit' v magazin", STUB_ACTION);
        menu.add(Menu.ROOT, "Pokormit' sobaku", STUB_ACTION);
        menu.add("Shodit' v magazin", "Kupit' produkty", STUB_ACTION);
        menu.add("Kupit' produkty", "Kupit' hleb", STUB_ACTION);
        menu.add("Kupit' produkty", "Kupit' moloko", STUB_ACTION);
        MenuPrinter printer = new ConsoleMenuPrinter();
        printer.print(menu);
    }
}
