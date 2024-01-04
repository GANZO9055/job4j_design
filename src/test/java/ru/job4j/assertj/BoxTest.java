package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name)
                .contains("here")
                .isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 4);
        String name = box.whatsThis();
        assertThat(name)
                .isNotEmpty()
                .startsWith("C")
                .isEqualTo("Cube");
    }

    @Test
    void whenNumberIsNegative() {
        Box box = new Box(10, 3);
        int number = box.getNumberOfVertices();
        assertThat(number)
                .isNotZero()
                .isLessThan(0)
                .isNegative()
                .isEqualTo(-1);
    }

    @Test
    void whenNumberIsPositive() {
        Box box = new Box(4, 3);
        int number = box.getNumberOfVertices();
        assertThat(number)
                .isNotZero()
                .isGreaterThan(1)
                .isLessThan(10)
                .isEven()
                .isPositive()
                .isEqualTo(4);
    }

    @Test
    void whenResultTrue() {
        Box box = new Box(8, 3);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void whenResultFalse() {
        Box box = new Box(10, 3);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void whenNumberIsTrueFirst() {
        Box box = new Box(4, 3);
        double number = box.getArea();
        int num = (int) number;
        int numOne = (int) ((number - num) * 100);
        number = num + (double) numOne / 100;
        assertThat(number)
                .isEqualTo(15.58d, withPrecision(0.02d))
                .isGreaterThan(15.55d)
                .isCloseTo(15.60d, withPrecision(0.03d))
                .isCloseTo(15.55d, withPrecision(0.03d));
    }

    @Test
    void whenNumberIsTrueSecond() {
        Box box = new Box(8, 3);
        double number = box.getArea();
        assertThat(number)
                .isEqualTo(54d, withPrecision(0.2d))
                .isGreaterThan(50d)
                .isCloseTo(53.5d, withPrecision(0.5d))
                .isCloseTo(54.5d, withPrecision(0.5d));
    }

    @Test
    void whenNumberIsFalse() {
        Box box = new Box(10, 3);
        double number = box.getArea();
        assertThat(number).isEqualTo(0.0d);
    }
}