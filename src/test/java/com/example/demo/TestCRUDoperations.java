package com.example.demo;

import com.example.model.ProductionBrands;
import com.example.model.SalesCustomers;
import com.example.statements.Insert;
import com.example.statements.Select;
import com.example.util.DatabaseConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class TestCRUDoperations {
    ResultSet result;
    ResultSetMetaData metadata;

    static DatabaseConnection dbConnection = null;

    @BeforeAll
    static void setup() throws SQLException {
        dbConnection = new DatabaseConnection();
        dbConnection.getConnection();
    }

    @AfterAll
    static public void tearDown() {
        dbConnection.close();
    }

    @Test
    public void testSelectAll() throws SQLException {
        result = Select.all("production.brands");
        while (result.next()) { //read data from each row
            System.out.println(result.getString(1) + ". " + result.getString(2));
        }
    }

    @Test
    public void testSelectTop() throws SQLException {
        result = Select.topNRows("sales.customers", 10);
        while (result.next()) { //read data from each row
            System.out.println(result.getString(1) + ". " + result.getString(2) + " " + result.getString(3));
        }
    }

    @Test
    public void testSelectWhere() throws SQLException {
        result = Select.where("sales.customers", "customer_id <= 10");
        while (result.next()) { //read data from each row
            System.out.println(result.getString(1) + ". " + result.getString(2) + " " + result.getString(3));
        }
    }

    @Test
    public void testSelect() throws SQLException {
        result = Select.select("SELECT * FROM sales.customers WHERE state = 'CA'");
        while (result.next()) { //read data from each row
            System.out.println(result.getString(1) + ". " + result.getString(2) + " " + result.getString(3));
        }
    }

    @Test
    public void testInsertIntoSalesCustomersTable() throws SQLException {
        SalesCustomers salesCustomer = new SalesCustomers();
        salesCustomer.setFirstName("Joe");
        salesCustomer.setLastName("Black");
        salesCustomer.setPhone("null");
        salesCustomer.setEmail("olga@foo.com");
        salesCustomer.setStreet("25 Avenue");
        salesCustomer.setCity("New York");
        salesCustomer.setState("NY");
        salesCustomer.setZipCode("22222");

        Insert.intoSalesCustomersTable(salesCustomer);

        result = Select.select("SELECT * FROM sales.customers WHERE first_name = 'Joe' and last_name = 'Black' ");
        metadata = result.getMetaData();

        while (result.next()) {
            for (int i = 1; i <= metadata.getColumnCount(); i++) {
                System.out.println(result.getString(i));
            }
        }
    }

    @Test
    public void testInsertIntoProductionBrandsTable() throws SQLException {
        ProductionBrands productionBrand = new ProductionBrands();
        productionBrand.setBrandName("Shimano");

        Insert.intoProductionBrandsTable(productionBrand);

        result = Select.select("SELECT * FROM production.brands WHERE brand_name = 'Shimano'");
        metadata = result.getMetaData();

        while (result.next()) {
            for (int i = 1; i <= metadata.getColumnCount(); i++) {
                System.out.println(result.getString(i));
            }
        }
    }
}