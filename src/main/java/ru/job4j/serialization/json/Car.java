package ru.job4j.serialization.json;

import java.util.Arrays;

public class Car {
    private final String name;
    private final boolean imported;
    private final String age;
    private final Person person;
    private final String[] specification;

    public Car(String name, boolean imported, String age, Person person, String[] specification) {
        this.name = name;
        this.imported = imported;
        this.age = age;
        this.person = person;
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "Car{"
                + "name='" + name + '\''
                + "imported='" + imported + '\''
                + ", age='" + age + '\''
                + ", person=" + person
                + ", specification=" + Arrays.toString(specification)
                + '}';
    }
}
