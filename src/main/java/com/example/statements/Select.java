package com.example.statements;

import java.sql.*;

public class Select {
    private static String url = "jdbc:sqlserver://EN411445;user=user;password=Uu1234567890;databaseName=BikeStores";
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preStatement;

    static {
        try {
            //get connection to DB
            connection = DriverManager.getConnection(url);
            //create a statement
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ResultSet all(String tableName) throws SQLException {
        return statement.executeQuery("SELECT * FROM " + tableName);
    }

    public static ResultSet topNRows(String tableName, int n) throws SQLException {
        return statement.executeQuery("SELECT TOP(" + n + ") * FROM " + tableName);
    }

    public static ResultSet where(String tableName, String clause) throws SQLException {
        return statement.executeQuery("SELECT * FROM " + tableName + " WHERE " + clause);
    }

    public static ResultSet select(String sqlRequest) throws SQLException {
        return statement.executeQuery(sqlRequest);
    }
}
