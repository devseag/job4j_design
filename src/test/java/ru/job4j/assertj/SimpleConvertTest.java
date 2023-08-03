package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .isInstanceOf(List.class)
                .contains("five")
                .contains("second", Index.atIndex(1))
                .containsAnyOf("three", "nine", "ten")
                .doesNotContain("eleven")
                .startsWith("first", "second")
                .endsWith("four", "five")
                .isNotEmpty()
                .isNotNull()
                .allSatisfy(e ->
                        assertThat(e.length()).isGreaterThan(2)
                ).anySatisfy(e ->
                        assertThat(e.contains("con"))
                ).first().isEqualTo("first");

    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("red", "blue", "black", "white", "olive", "pink", "beige", "pink");
        assertThat(set).isInstanceOf(Set.class)
                .containsAnyOf("blue", "wine", "pink")
                .doesNotContainNull()
                .doesNotHaveAnyElementsOfTypes(Integer.class, Double.class, Character.class)
                .allSatisfy(e -> assertThat(e.length()).isGreaterThan(2))
                .containsOnlyOnce("white")
                .hasSize(7)
                .first().isEqualTo("red");

    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("bird", "dog", "bear", "cat", "fish", "bug");
        assertThat(map)
                .isNotEmpty()
                .isNotNull()
                .isInstanceOf(Map.class)
                .containsKey("dog")
                .containsKeys("bird", "fish")
                .doesNotContainKey("ferret")
                .hasSize(6)
                .containsValues(1, 2, 3, 4)
                .doesNotContainValue(10)
                .containsEntry("bird", 0);
    }
}