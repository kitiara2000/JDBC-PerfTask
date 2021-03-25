package com.example.dao;

import com.example.model.SalesOrders;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersDAO implements Dao<SalesOrders> {
    @Override
    public ResultSet selectAll() throws SQLException {
        return null;
    }

    @Override
    public ResultSet selectById(int id) throws SQLException {
        return null;
    }

    @Override
    public ResultSet select(String sqlRequest) throws SQLException {
        return null;
    }

    @Override
    public boolean update(SalesOrders values, int id) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String sqlQuery) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    public int insert(SalesOrders values) throws SQLException {
        return 0;
    }

    @Override
    public boolean bulkInsert(File csv) throws SQLException {
        return false;
    }

    public void printResult(ResultSet result) {

    }
}
