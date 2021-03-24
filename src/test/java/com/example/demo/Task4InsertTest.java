package com.example.demo;

import com.example.dao.BrandsDao;
import com.example.dao.CustomersDAO;
import com.example.model.ProductionBrands;
import com.example.model.SalesCustomers;
import com.example.util.DatabaseConnection;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;

public class Task4InsertTest {
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
    public void testInsertIntoBrandsTable() {
        ProductionBrands newBrand = new ProductionBrands();
        newBrand.setBrandName("Shimano");
        brands.insert(newBrand);

        result = brands.select("SELECT * FROM production.brands WHERE brand_name = 'Shimano' ");
        brands.printResult(result);
        // add assertions
    }

    @Test
    public void testInsertIntoCustomersTable() {
        SalesCustomers newCustomer = new SalesCustomers();
        newCustomer.setFirstName("Joe");
        newCustomer.setLastName("Black");
        newCustomer.setPhone("null");
        newCustomer.setEmail("olga@foo.com");
        newCustomer.setStreet("25 Avenue");
        newCustomer.setCity("New York");
        newCustomer.setState("NY");
        newCustomer.setZipCode("22222");
        customers.insert(newCustomer);

        result = customers.select("SELECT * FROM sales.customers WHERE last_name = 'Black' ");
        customers.printResult(result);
        //add assertions
    }
}
