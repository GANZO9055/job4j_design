package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {
    @Test
    void whenPairWithoutComment() {
        String path = "./data/properties/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev=1");
    }

    @Test
    void whenPairWithCommentAndEmptyString() {
        String path = "./data/properties/pair_strings_empty.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isNull();
        assertThat(config.value("Test1")).isNull();
    }

    @Test
    void whenPairWithoutKey() {
        String path = "./data/properties/pair_without_key.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenPairWithoutValue() {
        String path = "./data/properties/pair_without_value.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenPairWithoutChar() {
        String path = "./data/properties/pair_without_char.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenPairWithoutKeyAndValue() {
        String path = "./data/properties/pair_without_key_and_value.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }
}