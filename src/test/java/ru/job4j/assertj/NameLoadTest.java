package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    @Test
    void checkEmptyInGetMap() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkEmptyInParse() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }

    @Test
    void checkFirstExceptionInValidate() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("name"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: name does not contain the symbol '='");
    }

    @Test
    void checkSecondExceptionInValidate() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("=name"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: =name does not contain a key");
    }

    @Test
    void checkThirdExceptionInValidate() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("key="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: key= does not contain a value");
    }
}