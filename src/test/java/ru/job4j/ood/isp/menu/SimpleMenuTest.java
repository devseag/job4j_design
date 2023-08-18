package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.isp.menu.models.ActionDelegate;
import ru.job4j.ood.isp.menu.models.Menu;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Disabled
public class SimpleMenuTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddThenReturnSame() {

        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Shodit' v magazin", STUB_ACTION);
        menu.add(Menu.ROOT, "Pokormit' sobaku", STUB_ACTION);
        menu.add("Shodit' v magazin", "Kupit' produkty", STUB_ACTION);
        menu.add("Kupit' produkty", "Kupit' hleb", STUB_ACTION);
        menu.add("Kupit' produkty", "Kupit' moloko", STUB_ACTION);
        assertThat(new Menu.MenuItemInfo("Shodit' v magazin", List.of("Kupit' produkty"), STUB_ACTION, "1.")).isEqualTo(menu.select("Shodit' v magazin").get());
        assertThat(new Menu.MenuItemInfo("Kupit' produkty", List.of("Kupit' hleb", "Kupit' moloko"), STUB_ACTION, "1.1.")).isEqualTo(menu.select("Kupit' produkty").get());
        assertThat(new Menu.MenuItemInfo("Pokormit' sobaku", List.of(), STUB_ACTION, "2.")).isEqualTo(menu.select("Pokormit' sobaku").get());
        menu.forEach(i -> System.out.println(i.getNumber() + i.getName()));
    }
}