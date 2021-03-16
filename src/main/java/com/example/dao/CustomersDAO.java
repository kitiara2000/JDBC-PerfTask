package com.example.dao;

import com.example.model.SalesCustomers;
import com.example.util.DatabaseConnection;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.sql.*;

@Slf4j
public class CustomersDAO implements Table {
    private Connection connection;
    public Statement statement;

    {
        try {
            //get connection to DB
            connection = new DatabaseConnection().getConnection();
            //create a statement
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public ResultSet selectAll() {
        ResultSet rs = null;
        log.info("Execute query: SELECT * FROM production.brands");
        try {
            rs = statement.executeQuery("SELECT * FROM production.brands");
            log.info("Query was executed successfully");
        } catch (SQLException throwables) {
            log.error("Query was not executed!");
            throwables.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet selectById(int id) {
        log.info("SELECT * FROM sales.customers WHERE customer_id = " + id);
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("SELECT * FROM sales.customers WHERE customer_id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            log.info("Query was executed successfully");
        } catch (SQLException e) {
            log.error("Query was not executed!", e);
        }

        return rs;
    }

    @Override
    public void update() throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    public int insert(SalesCustomers values) {
        int rs = 0;
        log.info("Add new customer to sales.customers table");
        try {
            rs = statement.executeUpdate("INSERT INTO sales.customers " +
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
        return rs;
    }

    @Override
    public int bulkInsert(File csv) throws SQLException {
        return 0;
    }

    @Override
    public void printResult(ResultSet result) {
        try {
            while (result.next()) { //read data from each row
                System.out.println(result.getString("customer_id") + ". " +
                                result.getString("first_name") + " " +
                                result.getString("last_name") + " " +
                                result.getString("phone") + " " +
                                result.getString("email") + " " +
                                result.getString("street") + " " +
                                result.getString("city") + " " +
                                result.getString("state") + " " +
                                result.getString("zip_code") );
            }
        } catch (SQLException e) {
            log.error("Result cannot be printed", e);
        }
    }
}
