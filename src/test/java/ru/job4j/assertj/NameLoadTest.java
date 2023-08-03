package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {

    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkParse() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() ->
                nameLoad.parse()
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty")
                .hasMessageMatching("^.+");
    }

    @Test
    void checkValidateWhenNotContainSymbol() {
        NameLoad nameLoad = new NameLoad();
        String name = "a";
        assertThatThrownBy(() ->
                nameLoad.parse(name)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain the symbol")
                .hasMessageContaining(name);
    }
    @Test
    void checkValidateWhenNotContainKey() {
        NameLoad nameLoad = new NameLoad();
        String name = "=a";
        assertThatThrownBy(() ->
                nameLoad.parse(name)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a key")
                .hasMessageContaining(name);
    }
    @Test
    void checkValidateWhenNotContainValue() {
        NameLoad nameLoad = new NameLoad();
        String name = "a=";
        assertThatThrownBy(() ->
                nameLoad.parse(name)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a value")
                .hasMessageContaining(name);
    }
}