package ru.job4j.serialization;

import java.io.Serializable;

public class Test implements Serializable {
    private String color;
    private String number;

    public Test(String color, String number) {
        this.color = color;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Test{"
                + "color='" + color + '\''
                + ", number='" + number + '\''
                + '}';
    }
}
