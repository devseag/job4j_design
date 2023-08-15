package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

/**
 * Class represents itself a simple model of a DB editor
 *
 * @author devseag
 */
public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    /**
     * A method for getting connection to a database
     *
     * @throws Exception
     */
    private void initConnection() throws Exception {
        Class.forName(properties.getProperty("jdbc.driver"));
        String url = properties.getProperty("jdbc.url");
        String login = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    /**
     * A method contains a database query execution in addition to a console print
     *
     * @param sql       query
     * @param tableName name of the table
     * @throws Exception
     */
    public void query(String sql, String tableName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            if (!sql.toLowerCase().startsWith("drop")) {
                System.out.println(TableEditor.getTableScheme(connection, tableName));
            }
        }
    }

    /**
     * A method creates an empty table without columns
     *
     * @param tableName name of a table
     * @throws Exception
     */
    public void createTable(String tableName) throws Exception {
        query(String.format("create table if not exists %s();", tableName), tableName);
    }

    /**
     * A method deletes table
     *
     * @param tableName name of a table for deletion
     * @throws Exception
     */
    public void dropTable(String tableName) throws Exception {
        query(String.format("drop table if exists %s;", tableName), tableName);
    }

    /**
     * A method adds a column to a table
     *
     * @param tableName  name of a table
     * @param columnName column name for addition
     * @param type       type of column
     * @throws Exception
     */
    public void addColumn(String tableName, String columnName, String type) throws Exception {
        query(String.format("alter table if exists %s add column if not exists %s %s;",
                tableName, columnName, type), tableName);
    }

    /**
     * A method deletes a column in a table
     *
     * @param tableName  name of a table
     * @param columnName name of a column for deletion
     * @throws Exception
     */
    public void dropColumn(String tableName, String columnName) throws Exception {
        query(String.format("alter table if exists %s drop column if exists %s;",
                tableName, columnName), tableName);
    }

    /**
     * A method renames a column in a table
     *
     * @param tableName     name of a table
     * @param columnName    what column needs to be renamed
     * @param newColumnName new column name
     * @throws Exception
     */
    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        query(String.format("alter table if exists %s rename column %s to %s;",
                tableName, columnName, newColumnName), tableName);
    }

    /**
     * A method prints in the console table scheme
     *
     * @param connection
     * @param tableName
     * @return
     * @throws Exception
     */
    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
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

    /**
     * A method closes connection to a database
     *
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        try (InputStream in = TableEditor.class.getClassLoader()
                .getResourceAsStream("app.properties")
        ) {
            Properties properties = new Properties();
            properties.load(in);
            try (TableEditor tableEditor = new TableEditor(properties)) {
                tableEditor.createTable("someTable");
                tableEditor.addColumn("someTable", "id", "serial primary key");
                tableEditor.addColumn("someTable", "name", "text");
                tableEditor.addColumn("someTable", "date", "date");
                tableEditor.dropColumn("someTable", "name");
                tableEditor.renameColumn("someTable", "date", "date2");
                tableEditor.dropTable("someTable");
            }
        }
    }
}