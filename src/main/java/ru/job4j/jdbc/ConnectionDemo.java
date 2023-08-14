package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Objects;
import java.util.StringJoiner;

public class ConnectionDemo {
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("org.postgresql.Driver");
//        String url = "jdbc:postgresql://localhost:5432/idea_db";
//        String login = "postgres";
//        String password = "password";
//        try (Connection connection = DriverManager.getConnection(url, login, password)) {
//            DatabaseMetaData metaData = connection.getMetaData();
//            System.out.println(metaData.getUserName());
//            System.out.println(metaData.getURL());
//        }
//    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        ClassLoader cl = ConnectionDemo.class.getClassLoader();
        String path = Objects.requireNonNull(cl.getResource("app.properties")).getPath();
        Config config = new Config(path);
        config.load();
        Class.forName(config.value("driver_class"));
        String url = config.value("url");
        String login = config.value("login");
        String password = config.value("password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}

