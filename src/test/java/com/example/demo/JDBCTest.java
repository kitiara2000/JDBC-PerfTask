package com.example.demo;

import java.sql.*;

public class JDBCTest {
//    public static void main(String[] args) throws SQLException {
//        String url = "jdbc:sqlserver://EN411445;user=user;password=Uu1234567890;databaseName=BikeStores";
//        //get connection to DB
//        Connection connection = DriverManager.getConnection(url);
//        //create a statement
//        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//        ResultSet result;
//        ResultSetMetaData metadata;
//        PreparedStatement preStatement;
//
//        //execute SQL SELECT query
//        result = statement.executeQuery("SELECT * FROM [BikeStores].[production].[brands]");
//        while (result.next()) { //read data from each row
//            System.out.println(result.getString("brand_id") + ". " + result.getString("brand_name"));
//        }
//
//        //execute SQL INSERT query
//        statement.executeUpdate("INSERT INTO sales.customers " +
//                "(first_name, last_name, phone, email, street, city, state, zip_code)" +
//                " VALUES " +
//                "('John', 'Wright', 'NULL', 'Ewright@foo.com', '1222 First Avenue', 'New York', 'NY', '12222')");
//        result = statement.executeQuery("SELECT * FROM [BikeStores].[sales].[customers] WHERE first_name = 'John'");
//        metadata = result.getMetaData();
//        result.absolute(1);
//        for (int i = 1; i <= metadata.getColumnCount(); i++) {
//            System.out.println(result.getString(i));
//        }
//
//        //execute SQL UPDATE query
//        statement.executeUpdate("UPDATE sales.customers SET phone = '54654566566' WHERE first_name = 'John' AND last_name = 'Wright'");
//        System.out.println("After UPDATE");
//        result = statement.executeQuery("SELECT * FROM [BikeStores].[sales].[customers] WHERE first_name = 'John'");
//        metadata = result.getMetaData();
//        result.absolute(1);
//        for (int i = 1; i <= metadata.getColumnCount(); i++) {
//            System.out.println(result.getString(i));
//        }
//
//        //execute SQL DELETE query
//        statement.executeUpdate("DELETE sales.customers WHERE first_name = 'John' AND last_name = 'Wright'");
//
//        //execute BULK INSERT
//
//        //prepared statement
//        preStatement = connection.prepareStatement("SELECT * FROM sales.customers WHERE state = ?");
//        preStatement.setString(1, "NY");
//
//        result = preStatement.executeQuery();
//        while (result.next()) {
//            System.out.println(result.getString("first_name") + " " + result.getString("last_name") + " - " + result.getString("email"));
//        }
//
//        //Get list of table names
//        DatabaseMetaData databaseMetaData = connection.getMetaData();
//        String catalog=null, schema=null, tableName=null, columnName=null;
//        String[] types = null;
//
//        System.out.println("\n\nList of Tables");
//        System.out.println("--------------");
//
//        result = databaseMetaData.getTables(catalog, schema, tableName, types);
//
//        while (result.next()){
//            System.out.println(result.getString("TABLE_NAME"));
//        }
//
//        //Get list of columns in a table
//        System.out.println("\n\nList of Columns for 'customers' Table");
//        System.out.println("-------------------------------------");
//
//        result=databaseMetaData.getColumns(catalog, schema, "customers", columnName);
//
//        while (result.next()){
//            System.out.println(result.getString("COLUMN_NAME"));
//        }
//    }
}