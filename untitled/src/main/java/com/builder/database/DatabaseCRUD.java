package com.builder.database;

/**
 * The {@code DatabaseCRUD} interface defines a set of methods for basic database operations: create, read, update, and delete (CRUD).
 * It also includes a method to check the existence of a database connection. Opens a ConnectionPool for implementations to use.
 */
public interface DatabaseCRUD {
    public static DatabaseConnection DBConnect = new DatabaseConnection();

    /**
     * Creates a new record in the database.
     */
    static void create() {}

    /**
     * Reads data from the database.
     */
    static void read(){}

    /**
     * Updates an existing record in the database.
     */
    static void update(){}

    /**
     * Deletes a record from the database.
     */
    static void delete(){}

    /**
     * Checks if the object exists in the database.
     * @return {@code true} if the object exists in the database, {@code false} otherwise.
     */
    static boolean exists(){return false;}
}
