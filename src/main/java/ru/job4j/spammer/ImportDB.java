package ru.job4j.spammer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

//    create table users(
//            id serial primary key,
//            name text,
//            email text
//    );

    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines()
                    .filter(s -> s.contains(";"))
                    .map(s -> s.split(";"))
                    .peek(s -> {
                        if (s.length != 2 || s[0].isBlank() || s[1].isBlank()) {
                            throw new IllegalArgumentException("Wrong argument");
                        }
                    })
                    .forEach(s -> users.add(new User(s[0], s[1])));
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            try (PreparedStatement ps = cnt.prepareStatement("insert into users (name, email) values (?, ?)")) {
                for (User user : users) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    if (ps.executeUpdate() > 0) {
                        System.out.printf("User name: %s, email: %s was added to the database.%s",
                                user.name, user.email, System.lineSeparator());
                    }
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }


    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (InputStream in = ImportDB.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "data/dump.txt");
        db.save(db.load());
    }
}

//1	"Petr Petrov"	"petrpetrov@yahoo.com"
//2	"Ivan Ivanov"	"iivanov@gmail.com"