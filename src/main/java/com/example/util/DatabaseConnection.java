package com.example.util;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
public class DatabaseConnection {

    private static Connection connection = null;

    public static Connection getConnection() {

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/db.properties"));

            String user = properties.getProperty("dbUser");
            String password = properties.getProperty("dbPassword");
            String dbUrl = properties.getProperty("dbUrl");

            if (connection == null) {
                log.info("Connection to database...");
                connection = DriverManager.getConnection(dbUrl, user, password);
                log.info("Connection successful!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void close() {
        if (connection != null) {
            try {
                log.info("Closing database connection");
                connection.close();
                log.info("Database connection closed");
            } catch (SQLException e) {
                log.error("Unable to close connection", e);
            }
            connection = null;
        }
    }
}