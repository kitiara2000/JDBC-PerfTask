package com.example.statements;

import com.example.entity.ProductionBrands;
import com.example.entity.SalesCustomers;

import java.sql.*;

public class Insert {
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

    public static void intoProductionBrandsTable(ProductionBrands values) throws SQLException {
        statement.executeUpdate("INSERT INTO production.brands (brand_name) VALUES ('" +
                values.getBrandName() + "')");
    }

    public static void intoSalesCustomersTable(SalesCustomers values) throws SQLException {
        statement.executeUpdate("INSERT INTO sales.customers " +
                "(first_name, last_name, phone, email, street, city, state, zip_code)" +
                " VALUES " + "('" +
                values.getFirstName() + "', '" +
                values.getLastName() + "', '" +
                values.getPhone() + "', '" +
                values.getEmail() + "', '" +
                values.getStreet() + "', '" +
                values.getCity() + "', '" +
                values.getState() + "', '" +
                values.getZipCode() + "')");
    }
}
