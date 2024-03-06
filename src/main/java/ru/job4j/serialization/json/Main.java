package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Dima", "+7(999)999-99-99");
        String[] specificationCar = {"Red", "Mechanical", "Electric"};

        Car car = new Car("Geely Tuareg", true, "2", person, specificationCar);

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));

        final String carJson =
                "{"
                        + "\"name\":\"Geely Tuareg\","
                        + "\"imported\":true,"
                        + "\"age\":2,"
                        + "\"person\":"
                        + "{"
                        + "\"name\":\"Dima\","
                        + "\"telephone\":\"+7(999)999-99-99\""
                        + "},"
                        + "\"specification\":"
                        + "[\"Red\",\"Mechanical\", \"Electric\"]"
                        + "}";
        final Car carMod = gson.fromJson(carJson, Car.class);
        System.out.println(carMod);
    }
}
