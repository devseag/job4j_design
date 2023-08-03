package ru.job4j.assertj;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

class SimpleCollectionTest {
    @Test
    void generalAssert() {
        SimpleCollection<Integer> simpleCollection = new SimpleCollection<>(1, 1, 3, 4, 5);
        assertThat(simpleCollection).isNotEmpty()
                /*razmer:*/
                .hasSize(5)
                /*soderzhit jelementy:*/
                .contains(1, 5, 4)
                /*soderzhit jeto v ljubom porjadke, dublikaty ne vazhny:*/
                .containsOnly(1, 5, 4, 3)
                /*soderzhit tol'ko jeto i tol'ko v ukazannom porjadke:*/
                .containsExactly(1, 1, 3, 4, 5)
                /*soderzhit tol'ko jeto v ljubom porjadke:*/
                .containsExactlyInAnyOrder(5, 1, 3, 4, 1)
                /*soderzhit hotja by odin iz:*/
                .containsAnyOf(200, 100, 3)
                /*ne soderzhit ni odnogo iz:*/
                .doesNotContain(0, 6)
                /*nachinaetsja s posledovatel'nosti:*/
                .startsWith(1, 1)
                /*zakanchivaetsja na posledovatel'nost':*/
                .endsWith(4, 5)
                /* soderzhit posledovatel'nost':*/
                .containsSequence(1, 3);
    }

    @Test
    void satisfyAssert() {
        SimpleCollection<Integer> simpleCollection = new SimpleCollection<>(1, 1, 3, 4, 5);
        assertThat(simpleCollection).isNotNull()
                /*vse jelementy vypolnjajut uslovie*/
                .allSatisfy(e -> {
                    assertThat(e).isLessThan(10);
                    assertThat(e).isGreaterThan(0);
                })
                /*hotja by odin jelement vypolnjaet uslovie*/
                .anySatisfy(e -> {
                    assertThat(e).isLessThan(5);
                    assertThat(e).isEqualTo(3);
                })
                .allMatch(e -> e < 10)
                .anyMatch(e -> e == 5)
                .noneMatch(e -> e < 1);
    }

    @Test
    void checkNavigationList() {
        SimpleCollection<Integer> simpleCollection = new SimpleCollection<>(1, 1, 3, 4, 5);
        /*pervyj jelement*/
        assertThat(simpleCollection).first().isEqualTo(1);
        /*jelement po indeksu*/
        assertThat(simpleCollection).element(0).isNotNull()
                .isEqualTo(1);
        /*poslednij jelement*/
        assertThat(simpleCollection).last().isNotNull()
                .isEqualTo(5);
    }

    @Test
    void checkFilteredList() {
        SimpleCollection<Integer> simpleCollection = new SimpleCollection<>(1, 1, 3, 4, 5);
        /*fil'truem istochnik po predikatu i rabotaem s rezul'tatom fil'tracii*/
        assertThat(simpleCollection).filteredOn(e -> e > 1).first().isEqualTo(3);
        /*fil'truem s pomoshh'ju assertThat() i rabotaem s rezul'tatom fil'tracii*/
        assertThat(simpleCollection).filteredOnAssertions(e -> assertThat(e).isLessThan(3))
                .hasSize(2)
                .first().isEqualTo(1);
    }

    @Test
    void assertMap() {
        Map<Integer, String> map = Map.of(
                1, "1", 2, "2", 3, "3");
        assertThat(map).hasSize(3)
                /*soderzhit kljuchi*/
                .containsKeys(1, 3, 2)
                /*soderzhit znachenija*/
                .containsValues("3", "1", "2")
                /*ne soderzhit kljuch*/
                .doesNotContainKey(0)
                /*ne soderzhit znachenie*/
                .doesNotContainValue("0")
                /*soderzhit paru kljuch-znachenie*/
                .containsEntry(2, "2");
    }
}