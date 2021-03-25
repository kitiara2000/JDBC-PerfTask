package com.example.demo;

import com.example.dao.BrandsDao;
import com.example.dao.CustomersDAO;
import com.example.util.DatabaseConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class Task1ReadTest {
    private static BrandsDao brands = null;
    private static CustomersDAO customers = null;

    ResultSet result;

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
    public void testSelectAllBrandsTable() throws SQLException {
        result = brands.selectAll();
        assertThat("Result is not empty", result, notNullValue());
    }

    @Test
    public void testSelectAllCustomersTable() throws SQLException {
        result = customers.selectAll();
        assertThat("Result is not empty", result, notNullValue());
    }

    @Test
    public void testSelectByIdBrandsTable() throws SQLException {
        int id = 1;
        int resultId = 0;
        result = brands.selectById(id);

        if (result.next()) {
            resultId = result.getInt("brand_id");
        }

        assertThat(format("ID value is [%s]", id),
                resultId,
                is(id));
    }

    @Test
    public void testSelectByIdCustomersTable() throws SQLException {
        int id = 118;
        int resultId = 0;

        result = customers.selectById(118);

        if (result.next()) {
            resultId = result.getInt("customer_id");
        }

        assertThat(format("ID value is [%s]", id),
                resultId,
                is(id));
    }

    @Test
    public void testSelectBrandsTable() throws SQLException {
        String brandName = "Strider";
        String resultBrandName = "";

        result = brands.select("SELECT * FROM production.brands WHERE brand_name = '" + brandName + "'");

        if (result.next()) {
            resultBrandName = result.getString("brand_name");
        }

        assertThat(format("Brand name value is [%s]", brandName),
                resultBrandName,
                is(brandName));
    }

    @Test
    public void testSelectCustomersTable() throws SQLException {
        String lastName = "Black";
        String resultLastName = "";

        result = customers.select("SELECT * FROM sales.customers WHERE last_name = '" + lastName + "'");

        if (result.next()) {
            resultLastName = result.getString("last_name");
        }

        assertThat(format("Brand name value is [%s]", lastName),
                resultLastName,
                is(lastName));
    }
}
