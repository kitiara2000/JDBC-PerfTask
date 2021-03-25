package com.example.demo;

import com.example.dao.BrandsDao;
import com.example.dao.CustomersDAO;
import com.example.model.ProductionBrands;
import com.example.model.SalesCustomers;
import com.example.util.DatabaseConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task4InsertTest {
    private static BrandsDao brands = null;
    private static CustomersDAO customers = null;

    @BeforeAll
    static void setup() {
        DatabaseConnection.getInstance().getConnection();
        brands = new BrandsDao();
        customers = new CustomersDAO();
    }

    @AfterAll
    static public void tearDown() {
        DatabaseConnection.close();
    }

    @Test
    public void testInsertIntoBrandsTable() {
        int rowsUpdated = 0;

        ProductionBrands newBrand = new ProductionBrands();
        newBrand.setBrandName("Shimano");

        rowsUpdated = brands.insert(newBrand);

        assertThat("Brand is added", rowsUpdated > 0, is(true));
    }

    @Test
    public void testInsertIntoCustomersTable() {
        int rowsUpdated = 0;

        SalesCustomers newCustomer = new SalesCustomers();
        newCustomer.setFirstName("Joe");
        newCustomer.setLastName("Black");
        newCustomer.setPhone("null");
        newCustomer.setEmail("olga@foo.com");
        newCustomer.setStreet("25 Avenue");
        newCustomer.setCity("New York");
        newCustomer.setState("NY");
        newCustomer.setZipCode("22222");

        rowsUpdated = customers.insert(newCustomer);

        assertThat("Customer is added", rowsUpdated > 0, is(true));
    }
}
