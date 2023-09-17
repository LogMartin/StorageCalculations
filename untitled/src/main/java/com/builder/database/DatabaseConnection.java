package com.builder.database;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static HikariDataSource dataSource= new HikariDataSource();

    public DatabaseConnection() {
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/loganmartin");

    }
    public DatabaseConnection(String url) {
        dataSource.setJdbcUrl(url);
    }

    public DatabaseConnection(String url, String username, String password) {
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
