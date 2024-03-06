package ru.job4j.serialization.json;

public class Person {
    private final String name;
    private final String telephone;

    public Person(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Person{"
                + "name='" + name + '\''
                + ", telephone='" + telephone + '\''
                + '}';
    }
}
