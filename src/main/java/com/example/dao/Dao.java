package com.example.dao;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Dao<T> {

    public ResultSet selectAll() throws SQLException;
    public ResultSet selectById(int id) throws SQLException;
    public ResultSet select(String sqlRequest) throws SQLException;

    public boolean update(T values, int id) throws SQLException;

    public boolean delete(String clause) throws SQLException;
    public boolean deleteById(int id) throws SQLException;

    public int insert (T values) throws SQLException;

    public boolean bulkInsert(File csv) throws SQLException;

//    public interface Dao<T> {
//        Optional<T> get(long id);
//        List<T> getAll();
//        void save(T t);
//        void update(T t, String[] params);
//        void delete(T t);
//    }

}
