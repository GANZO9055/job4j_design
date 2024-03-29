package ru.job4j.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void checkRemoveIf() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.addAfter(input, 1, 4);
        assertThat(input).hasSize(4).containsSequence(1, 2, 4, 3);

        ListUtils.removeIf(input, num -> num % 2 == 0);
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }

    @Test
    void checkReplaceIf() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.addBefore(input, 2, 4);
        ListUtils.addBefore(input, 3, 3);

        ListUtils.replaceIf(input, num -> num % 3 == 0, 4);
        assertThat(input).hasSize(5).containsSequence(1, 2, 4, 4, 4);
    }

    @Test
    void checkRemoveAll() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.addBefore(input, 2, 4);
        ListUtils.addBefore(input, 3, 3);
        ListUtils.addBefore(input, 4, 2);
        assertThat(input).hasSize(6).containsSequence(1, 2, 4, 3, 2, 3);

        ListUtils.removeAll(input, new ArrayList<>(Arrays.asList(1, 2, 3)));
        assertThat(input).hasSize(1).contains(4);
    }
}