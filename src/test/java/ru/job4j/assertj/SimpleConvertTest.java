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
                .contains("second")
                .contains("first", "three")
                .startsWith("first", "second")
                .endsWith("five")
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("One", "Two")
                .allSatisfy(element -> {
                    assertThat(element.length()).isLessThan(10);
                    assertThat(element.length()).isGreaterThan(3);
                });
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five", "six");
        assertThat(set).hasSize(6)
                .contains("first", "six")
                .anyMatch(element -> element.length() == 3)
                .noneMatch(String::isEmpty)
                .allMatch(element -> element.length() > 2);
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four");
        assertThat(map).hasSize(4)
                .containsKeys("three", "four", "first")
                .containsValues(0, 3, 1)
                .doesNotContainKey("zero")
                .doesNotContainValue(4)
                .containsEntry("first", 0);
    }
}