package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisNotSphere() {
        Box box = new Box(4, 10);
        assertThat(box.whatsThis())
                .isNotEqualTo("Sphere")
                .isEqualTo("Tetrahedron");
    }

    @Test
    void whenVertexIs8() {
        Box box = new Box(8, 10);
        assertThat(box.getNumberOfVertices())
                .isEqualTo(8)
                .isEven()
                .isPositive()
                .isGreaterThan(1);
    }

    @Test
    void whenVertexIs6() {
        Box box = new Box(6, 10);
        assertThat(box.getNumberOfVertices())
                .isEqualTo(-1)
                .isNotEqualTo(4)
                .isNotEqualTo(0)
                .isNotEqualTo(8)
                .isNotPositive();
        assertThat(box.whatsThis()).isEqualTo("Unknown object");
    }

    @Test
    void whenExists() {
        Box box = new Box(8, 10);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void whenNotExists() {
        Box box = new Box(12, 10);
        assertThat(box.isExist()).isFalse();
    }

    @Test
    void whenAreaIs0() {
        Box box = new Box(12, 10);
        assertThat(box.getArea()).isEqualTo(0d, withPrecision(0.006d));
    }

    @Test
    void whenAreaIs600() {
        Box box = new Box(8, 10);
        assertThat(box.getArea()).isEqualTo(600d, withPrecision(0.006d));
    }
}