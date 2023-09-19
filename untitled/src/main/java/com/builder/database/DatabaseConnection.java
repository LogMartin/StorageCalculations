package com.builder.database;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * The `DatabaseConnection class provides a simplified interface for establishing and managing
 * connections to a PostgreSQL database using the HikariCP connection pool.
 * It allows for flexible configuration of the database connection through constructors, making it
 * easy to connect to different databases with various authentication methods.
 *  * @see HikariDataSource
 *  * @see Connection
 */
public class DatabaseConnection {
    private static HikariDataSource dataSource= new HikariDataSource();

    /**
     * Constructs a new `DatabaseConnection` object with default settings for the PostgreSQL database.
     */
    public DatabaseConnection() {
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/loganmartin");
    }

    /**
     * Constructs a new `DatabaseConnection` object with default settings and sets the JDBC URL for
     * the PostgreSQL database.
     *
     * @param url The JDBC URL of the PostgreSQL database.
     */
    public DatabaseConnection(String url) {
        dataSource.setJdbcUrl(url);
    }

    /**
     * Constructs a new `DatabaseConnection` object with custom settings for the JDBC URL, username,
     * and password for the PostgreSQL database.
     *
     * @param url      The JDBC URL of the PostgreSQL database.
     * @param username The username for authentication.
     * @param password The password for authentication.
     */
    public DatabaseConnection(String url, String username, String password) {
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    /**
     * Retrieves a database connection from the connection pool.
     *
     * @return A `Connection` object representing a connection to the PostgreSQL database.
     * @throws SQLException If a database access error occurs.
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
