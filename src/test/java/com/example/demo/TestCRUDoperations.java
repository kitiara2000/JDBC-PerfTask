package com.example.demo;

import com.example.dao.BrandsDao;
import com.example.dao.CustomersDAO;
import com.example.model.ProductionBrands;
import com.example.model.SalesCustomers;
import com.example.statements.Insert;
import com.example.statements.Select;
import com.example.util.DatabaseConnection;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

@Slf4j
public class TestCRUDoperations {
    private static DatabaseConnection connection = null;
    private static BrandsDao brands = null;
    private static CustomersDAO customers = null;

    ResultSet result;
    ResultSetMetaData metadata;

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
    public void testTask1() {
        result = brands.selectAll();
        brands.printResult(result);
// add asserts
        result = brands.selectById(7);
        brands.printResult(result);

        result = customers.selectById(118);
        customers.printResult(result);

        result = customers.selectAll();
        customers.printResult(result);
    }

    @Test
    public void testTask2() {
        ProductionBrands newBrand = new ProductionBrands();
        newBrand.setBrandName("Shimano");
        brands.insert(newBrand);

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
    }
//=======================

//    @Test
//    public void testSelectAll() throws SQLException {
//        result = Select.all("production.brands");
//        while (result.next()) { //read data from each row
//            System.out.println(result.getString(1) + ". " + result.getString(2));
//        }
//    }

//    @Test
//    public void testSelectTop() throws SQLException {
//        result = Select.topNRows("sales.customers", 10);
//        while (result.next()) { //read data from each row
//            System.out.println(result.getString(1) + ". " + result.getString(2) + " " + result.getString(3));
//        }
//    }
//
//    @Test
//    public void testSelectWhere() throws SQLException {
//        result = Select.where("sales.customers", "customer_id <= 10");
//        while (result.next()) { //read data from each row
//            System.out.println(result.getString(1) + ". " + result.getString(2) + " " + result.getString(3));
//        }
//    }
//
//    @Test
//    public void testSelect() throws SQLException {
//        result = Select.select("SELECT * FROM sales.customers WHERE state = 'CA'");
//        while (result.next()) { //read data from each row
//            System.out.println(result.getString(1) + ". " + result.getString(2) + " " + result.getString(3));
//        }
//    }

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