package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
public class Person {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String telephone;

    public Person() {
    }

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
