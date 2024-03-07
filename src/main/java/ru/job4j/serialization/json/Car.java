package ru.job4j.serialization.json;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private boolean imported;
    @XmlAttribute
    private String age;
    private Person person;
    @XmlElementWrapper(name = "specifications")
    @XmlElement(name = "specification")
    private String[] specification;


    public Car() {
    }

    public Car(String name, boolean imported, String age, Person person, String[] specification) {
        this.name = name;
        this.imported = imported;
        this.age = age;
        this.person = person;
        this.specification = specification;
    }

    public String getName() {
        return name;
    }

    public boolean isImported() {
        return imported;
    }

    public String getAge() {
        return age;
    }

    public Person getPerson() {
        return person;
    }

    public String[] getSpecification() {
        return specification;
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
