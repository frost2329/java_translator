package com.example.demo.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnector {

    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "root";

    public  Connection connection;

    public void init() throws SQLException {
        try {
            System.out.println("PostgreSQL JDBC Driver successfully connected");
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }
    public void closeConnection() {
        if (connection ==  null) return;
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("You successfully disconnected to database now");
    }

}
