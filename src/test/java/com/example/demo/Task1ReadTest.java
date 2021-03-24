package com.example.demo;

import com.example.dao.BrandsDao;
import com.example.dao.CustomersDAO;
import com.example.util.DatabaseConnection;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Task1ReadTest {
    private static BrandsDao brands = null;
    private static CustomersDAO customers = null;

    ResultSet result;

    @BeforeAll
    static void setup() {
        DatabaseConnection.getConnection();
        brands = new BrandsDao();
        customers = new CustomersDAO();
    }

    @AfterAll
    static public void tearDown() {
        DatabaseConnection.close();
    }


    @Test
    public void testSelectAllBrandsTable() throws SQLException {
        result = brands.selectAll();
        brands.printResult(result);
        assertThat("Result is not empty", !result.wasNull());
        // add asserts
    }

    @Test
    public void testSelectAllCustomersTable() {
        result = customers.selectAll();
        customers.printResult(result);
        // add asserts
    }

    @Test
    public void testSelectByIdBrandsTable() {
        result = brands.selectById(7);
        brands.printResult(result);
        //add asserts
    }

    @Test
    public void testSelectByIdCustomersTable() {
        result = customers.selectById(118);
        customers.printResult(result);
        // add asserts
    }

    @Test
    public void testSelectBrandsTable() {
        result = brands.select("SELECT * FROM production.brands WHERE brand_name = 'Shimano' ");
        brands.printResult(result);
        //add asserts
    }

    @Test
    public void testSelectCustomersTable() {
        result = customers.select("SELECT * FROM sales.customers WHERE last_name = 'Black' ");
        customers.printResult(result);
        // add asserts
    }
}
