package com.example.demo;

import com.example.dao.BrandsDao;
import com.example.dao.CustomersDAO;
import com.example.model.ProductionBrands;
import com.example.model.SalesCustomers;
import com.example.util.DatabaseConnection;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Task2UpdateTest {
    private static BrandsDao brands = null;
    private static CustomersDAO customers = null;

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
    public void testUpdateBrands() {
        ProductionBrands brandToUpdate = new ProductionBrands();
        brandToUpdate.setBrandName("Giant");
        brands.printResult(brands.selectById(11));
        brands.update(brandToUpdate, 11);
        brands.printResult(brands.selectById(11));
        //add asserts
    }

    @Test
    public void testUpdateCustomers() {
        customers.printResult(customers.select("SELECT * FROM sales.customers WHERE last_name = 'White' "));
        customers.update("UPDATE sales.customers SET last_name = 'Red' WHERE last_name = 'White' and customer_id>1200");
        customers.printResult(customers.select("SELECT * FROM sales.customers WHERE last_name = 'White' or last_name = 'Red' "));
        //add asserts
    }

    @Test
    public void testUpdateCustomerById() {
        SalesCustomers customerToUpdate = new SalesCustomers();
        customerToUpdate.setEmail("joered@foo.com");

        customers.update(customerToUpdate, 1466);
        customers.printResult(customers.select("SELECT * FROM sales.customers WHERE last_name = 'Red' "));
        //add asserts
    }
}
