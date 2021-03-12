package com.example.statements;

import com.example.entity.ProductionBrands;

import java.sql.*;

public class Update {
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

    public static int intoProductionBrandsTable(ProductionBrands values) throws SQLException {
        int rowsUpdated = 0;

        return rowsUpdated;
    }
}
