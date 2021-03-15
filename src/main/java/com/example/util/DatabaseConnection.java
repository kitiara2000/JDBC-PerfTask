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

    public Connection getConnection() throws SQLException {

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/db.properties"));

            String user = properties.getProperty("dbUser");
            String password = properties.getProperty("dbPassword");
            String dbUrl = properties.getProperty("dbUrl");
//            String dbName = properties.getProperty("dbName");

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            if (connection == null) {
                log.info("Connection to database...");
                //connection = DriverManager.getConnection(dbUrl + ";user=" + user + ";password=" + password + ";databaseName=" + dbName);
                connection = DriverManager.getConnection(dbUrl, user, password);
                log.info("Connection successful!");
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return  connection;
    }

    public void close() {
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