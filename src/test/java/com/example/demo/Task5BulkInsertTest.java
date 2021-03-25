package com.example.demo;

import com.example.dao.BrandsDao;
import com.example.dao.CustomersDAO;
import com.example.util.DatabaseConnection;
import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.sql.SQLException;

public class Task5BulkInsertTest {
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
    public void testInsertCustomersFromCSV() throws SQLException {
        boolean isUpdated = false;

        File file = new File( "src/main/resources/customers.csv");
        isUpdated = customers.bulkInsert(file);

        assertThat("Customers are added from .csv file", isUpdated, is(true));
    }

    @Test
    public void testInsertBrandsFromCSV() throws SQLException {
        boolean isUpdated = false;

        File file = new File( "src/main/resources/brands.csv");
        isUpdated = brands.bulkInsert(file);

        assertThat("Brands are added from .csv file", isUpdated, is(true));
    }
}
