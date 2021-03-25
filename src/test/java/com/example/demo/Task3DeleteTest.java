package com.example.demo;

import com.example.dao.BrandsDao;
import com.example.dao.CustomersDAO;
import com.example.util.DatabaseConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
        boolean isDeleted = false;
        String dataToDelete = "Giant";

        isDeleted = brands.delete("brand_name = '" + dataToDelete + "'");

        assertThat("Brand record is deleted", isDeleted, is(true));
    }

    @Test
    public void testDeleteCustomers() {
        boolean isDeleted = false;

        isDeleted = customers.delete("customer_id >= '2526' ");

        assertThat("Customer is deleted", isDeleted, is(true));
    }

    @Test
    public void testDeleteBrandById() {
        boolean isDeleted = false;
        int idToDelete = 07;

        isDeleted = brands.deleteById(idToDelete);

        assertThat("Brand record is deleted", isDeleted, is(true));
    }

    @Test
    public void testDeleteCustomersById() {
        boolean isDeleted = false;
        int idToDelete = 1400;

        isDeleted = customers.deleteById(idToDelete);

        assertThat("Customer is deleted", isDeleted, is(true));
    }
}
