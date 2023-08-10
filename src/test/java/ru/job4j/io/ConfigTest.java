package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
//        String path = "....";
        String path = "data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username")).isEqualTo("postgres");
        assertThat(config.value("hibernate.connection")).isNull();
        assertThat(config.value("#CheckForComment")).isNull();
    }

    @Test
    void whenPairWithCommentAndEmptyString() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect")).isEqualTo("org.hibernate.dialect.PostgreSQLDialect");
        assertThat(config.value("hibernate.connection.password")).isEqualTo("password");
        assertThat(config.value("# PostgreSQL")).isNull();
    }

    @Test
    void whenPairWithoutValue() {
        String path = "./data/pair_throw_without_value.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }
}