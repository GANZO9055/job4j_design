package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        JSONObject jsonPerson = new JSONObject("{\"name\":\"Dima\","
                + "\"telephone\":\"+7(999)999-99-99\"}");

        List<String> list = new ArrayList<>();
        list.add("Red");
        list.add("Mechanical");
        list.add("Electric");
        JSONArray jsonSpecifications = new JSONArray(list);

        final Car car = new Car("Geely Tuareg", true, "2",
                new Person("Dima", "+7(999)999-99-99"),
                new String[]{"Red", "Mechanical", "Electric"});

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", car.getName());
        jsonObject.put("imported", car.isImported());
        jsonObject.put("age", car.getAge());
        jsonObject.put("person", jsonPerson);
        jsonObject.put("specification", jsonSpecifications);

        System.out.println(jsonObject);

        System.out.println(new JSONObject(car));
    }
}
