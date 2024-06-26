package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.getProperty("driver_class"));
        connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password")
        );
    }

    public void createTable(String tableName) throws SQLException {
        String sql = String.format("CREATE TABLE %s();", tableName);
        statement(sql);
    }

    public void dropTable(String tableName) throws SQLException {
        String sql = String.format("DROP TABLE %s;", tableName);
        statement(sql);
    }

    public void addColumn(String tableName,
                                 String columnName,
                                 String type) throws SQLException {
        String sql = String.format("ALTER TABLE %s ADD COLUMN %s %s;",
                tableName, columnName, type);
        statement(sql);
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        String sql = String.format("ALTER TABLE %s DROP COLUMN %s;",
                tableName, columnName);
        statement(sql);
    }

    public void renameColumn(String tableName,
                                    String columnName,
                                    String newColumnName) throws SQLException {
        String sql = String.format("ALTER TABLE %s RENAME COLUMN %s TO %s;",
                tableName, columnName, newColumnName);
        statement(sql);
    }

    private void statement(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }


    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream in = TableEditor.class
                .getClassLoader()
                .getResourceAsStream("app.properties")) {
            config.load(in);
        }
        TableEditor table = new TableEditor(config);
        table.createTable("Test1");
        table.addColumn("Test1", "Test_column1", "TEXT");
        System.out.println(table.getTableScheme("Test1"));
        table.renameColumn("Test1", "Test_column1", "Test_column2");
        System.out.println(table.getTableScheme("Test1"));
        table.dropColumn("Test1", "Test_column2");
        System.out.println(table.getTableScheme("Test1"));
        table.dropTable("Test1");
        table.close();
    }
}