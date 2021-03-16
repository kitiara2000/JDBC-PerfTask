package com.example.dao;

import com.example.model.SalesOrders;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersDAO implements Table{
    @Override
    public ResultSet selectAll() throws SQLException {
        return null;
    }

    @Override
    public ResultSet selectById(int id) throws SQLException {
        return null;
    }

    @Override
    public void update() throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    public int insert(SalesOrders values) throws SQLException {
        return 0;
    }

    @Override
    public int bulkInsert(File csv) throws SQLException {
        return 0;
    }

    @Override
    public void printResult(ResultSet result) {

    }
}
