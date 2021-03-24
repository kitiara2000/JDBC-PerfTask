package com.example.demo;

import com.example.dao.BrandsDao;
import com.example.dao.CustomersDAO;
import com.example.util.DatabaseConnection;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Task3DeleteTest {
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
    public void testDeleteBrand() {
        brands.printResult(brands.selectAll());
        brands.delete("brand_name = 'Shimano' ");
        brands.printResult(brands.selectAll());
//        assertEquals(...);
//        assertTrue();
        //add asserts
    }

    @Test
    public void testDeleteCustomers() {
        customers.printResult(customers.select("SELECT * FROM sales.customers WHERE customer_id >= '1000' "));
        customers.delete("customer_id >= '2526' ");
        customers.printResult(customers.select("SELECT * FROM sales.customers WHERE customer_id >= '1000' "));
        //add asserts
    }

    @Test
    public void testDeleteBrandById() {
        brands.printResult(brands.selectAll());
        brands.deleteById(11);
        brands.printResult(brands.selectAll());
        //add asserts
    }

    @Test
    public void testDeleteCustomersById() {
        customers.printResult(customers.selectById(1466));
        customers.deleteById(1466);
        customers.printResult(customers.selectById(1466));
        //add asserts
    }
}
