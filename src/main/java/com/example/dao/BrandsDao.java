package com.example.dao;

import com.example.model.ProductionBrands;
import com.example.util.DatabaseConnection;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.sql.*;

@Slf4j
public class BrandsDao implements Table {
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
        } catch (SQLException e) {
            log.error("Query was not executed!", e);
        }
        return rs;
    }

    @Override
    public ResultSet selectById(int id) {
        log.info("Execute query: SELECT * FROM production.brands WHERE brand_id =" + id);
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("SELECT * FROM production.brands WHERE brand_id = ?");
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

    public int insert(ProductionBrands values) {
        int rs = 0;
        log.info("Add new brand to production.brands table");
        try {
            rs = statement.executeUpdate("INSERT INTO production.brands (brand_name) VALUES ('" +
                    values.getBrandName() + "')");
            log.info("New brand is added");
        } catch (SQLException e) {
            log.error("Brand was not added!", e);
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
                System.out.println(result.getString(1) + ". " + result.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
