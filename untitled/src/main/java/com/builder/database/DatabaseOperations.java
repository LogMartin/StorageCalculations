package com.builder.database;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseOperations {
    public static DatabaseConnection DBConnect = new DatabaseConnection();

    static void create() {}
    static void read(){}
    static void update(){}
    static void delete(){}
    static boolean exists(){return false;}
}
