package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoolTest {
    @Test
    void testFizzBuzz() {
        assertEquals("1", Fool.getFizzBuzz(1));
        assertEquals("2", Fool.getFizzBuzz(2));
        assertEquals("Fizz", Fool.getFizzBuzz(3));
        assertEquals("4", Fool.getFizzBuzz(4));
        assertEquals("Buzz", Fool.getFizzBuzz(5));
        assertEquals("Fizz", Fool.getFizzBuzz(6));
        assertEquals("7", Fool.getFizzBuzz(7));
        assertEquals("8", Fool.getFizzBuzz(8));
        assertEquals("Fizz", Fool.getFizzBuzz(9));
        assertEquals("Buzz", Fool.getFizzBuzz(10));
        assertEquals("11", Fool.getFizzBuzz(11));
        assertEquals("Fizz", Fool.getFizzBuzz(12));
        assertEquals("13", Fool.getFizzBuzz(13));
        assertEquals("14", Fool.getFizzBuzz(14));
        assertEquals("FizzBuzz", Fool.getFizzBuzz(15));
    }

    @Test
    void testValidation() {
        assertTrue(Fool.validation(1, "1"));
        assertTrue(Fool.validation(3, "Fizz"));
        assertTrue(Fool.validation(5, "Buzz"));
        assertTrue(Fool.validation(15, "FizzBuzz"));
        assertFalse(Fool.validation(1, "2"));
        assertFalse(Fool.validation(3, "Buzz"));
        assertFalse(Fool.validation(5, "Fizz"));
        assertFalse(Fool.validation(15, "Fizz"));
    }
}