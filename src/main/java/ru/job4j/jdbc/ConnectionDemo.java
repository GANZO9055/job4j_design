package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Config config = new Config("data/properties/app1.properties");
        config.load();
        Class.forName(config.value("hibernate.connection.driver_class"));
        try (Connection connection = DriverManager.getConnection(
                config.value("hibernate.connection.url"),
                config.value("hibernate.connection.username"),
                config.value("hibernate.connection.password"))) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
