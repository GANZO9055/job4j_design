package ru.job4j.template;


import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Disabled
class GeneratorStringTest {
    @Test
    public void whenAllKeysPresentThenSubstituteValues() {
        Generator generator = new GeneratorString();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        String result = generator.produce(template, args);
        assertEquals("I am a Petr Arsentev, Who are you?", result);
    }

    @Test
    public void whenMissingKeyThenThrowException() {
        Generator generator = new GeneratorString();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            generator.produce(template, args);
        });
        assertEquals("Missing key: subject", exception.getMessage());
    }
}