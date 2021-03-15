package com.example.statements;

import com.example.model.ProductionBrands;
import com.example.model.SalesCustomers;
import com.example.util.DatabaseConnection;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class Insert {
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


    public static void intoProductionBrandsTable(ProductionBrands values) {
        log.info("Add new brand to production.brands table");
        try {
            statement.executeUpdate("INSERT INTO production.brands (brand_name) VALUES ('" +
                    values.getBrandName() + "')");
            log.info("New brand is added");
        } catch (SQLException throwables) {
            log.error("Brand was not added!");
            throwables.printStackTrace();
        }
    }

    public static void intoSalesCustomersTable(SalesCustomers values){
        log.info("Add new customer to sales.customers table");
        try {
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
            log.info("New customer added");
        } catch (SQLException throwables) {
            log.error("Customer was not added!");
            throwables.printStackTrace();
        }
    }
}
