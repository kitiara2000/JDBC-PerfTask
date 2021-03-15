package com.example.statements;

import com.example.util.DatabaseConnection;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class Select {

    private static Connection connection;
    private static Statement statement;

    static {
        try {
            //get connection to DB
            connection = new DatabaseConnection().getConnection();
            //create a statement
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ResultSet all(String tableName) {
        ResultSet rs = null;
        log.info("Execute query: SELECT * FROM " + tableName);
        try {
            rs = statement.executeQuery("SELECT * FROM " + tableName);
            log.info("Query was executed successfully");
        } catch (SQLException throwables) {
            log.error("Query was not executed!");
            throwables.printStackTrace();
        }
        return rs;
    }

    public static ResultSet topNRows(String tableName, int n) throws SQLException {
        ResultSet rs = null;
        log.info("Execute query: SELECT TOP(" + n + ") * FROM " + tableName);
        try {
            rs = statement.executeQuery("SELECT TOP(" + n + ") * FROM " + tableName);
            log.info("Query was executed successfully");
        } catch (SQLException throwables) {
            log.error("Query was not executed!");
            throwables.printStackTrace();
        }
        return rs;
    }

    public static ResultSet where(String tableName, String clause) throws SQLException {
        ResultSet rs = null;
        log.info("Execute query: SELECT * FROM " + tableName + " WHERE " + clause);
        try {
            rs = statement.executeQuery("SELECT * FROM " + tableName + " WHERE " + clause);
            log.info("Query was executed successfully");
        } catch (SQLException throwables) {
            log.error("Query was not executed!");
            throwables.printStackTrace();
        }
        return rs;
    }

    public static ResultSet select(String sqlRequest) throws SQLException {
        ResultSet rs = null;
        log.info("Execute query: " + sqlRequest);
        try {
            rs = statement.executeQuery(sqlRequest);
            log.info("Query was executed successfully");
        } catch (SQLException throwables) {
            log.error("Query was not executed!");
            throwables.printStackTrace();
        }
        return rs;
    }
}
