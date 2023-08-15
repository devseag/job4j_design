package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Objects;
import java.util.StringJoiner;

public class ConnectionDemo {

    private static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "password";
        return DriverManager.getConnection(url, login, password);
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
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

    public static void main(String[] args) throws Exception, ClassNotFoundException, SQLException, IOException {
//        ClassLoader cl = ConnectionDemo.class.getClassLoader();
//        String path = Objects.requireNonNull(cl.getResource("app.properties")).getPath();
//        Config config = new Config(path);
//        config.load();
//        Class.forName(config.value("driver_class"));

//        statement.execute(sql);
//        int count = statement.getUpdateCount();
//        /* jekvivalentno */
//        int count = statement.executeUpdate(sql);
//
//        statement.execute(sql);
//        ResultSet result = statement.getResultSet();
//        /* jekvivalentno */
//        ResultSet result = statement.executeQuery(sql);

        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "CREATE TABLE IF NOT EXISTS demo_table(%s, %s);",
                        "id SERIAL PRIMARY KEY",
                        "name TEXT"
                );
                statement.execute(sql);
                System.out.println(getTableScheme(connection, "demo_table"));
            }
        }
    }
}
//
//------------------------------
//        NAME           |TYPE
//        ------------------------------
//        id             |serial
//        ------------------------------
//        name           |text
//        ------------------------------



