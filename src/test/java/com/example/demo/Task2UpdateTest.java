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
        String newData = "Giant";
        int idToUpdate = 07;
        boolean isUpdated = false;

        ProductionBrands brandToUpdate = new ProductionBrands();
        brandToUpdate.setBrandName(newData);

        isUpdated = brands.update(brandToUpdate, idToUpdate);

        assertThat("Brand name is updated", isUpdated, is(true));
    }

    @Test
    public void testUpdateCustomers() {
        boolean isUpdated = false;

        isUpdated = customers.update("UPDATE sales.customers SET last_name = 'Red' WHERE last_name = 'White' and customer_id>1200");

        assertThat("Customer data is updated", isUpdated, is(true));
    }

    @Test
    public void testUpdateCustomerById() {
        String newData = "joered@foo.com";
        int idToUpdate = 1111;
        boolean isUpdated = false;

        SalesCustomers customerToUpdate = new SalesCustomers();
        customerToUpdate.setEmail(newData);

        isUpdated = customers.update(customerToUpdate, idToUpdate);

        assertThat("Customer data is updated", isUpdated, is(true));
    }
}
