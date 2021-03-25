package com.example.dao;

import com.example.model.ProductionBrands;
import com.example.util.DatabaseConnection;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.sql.*;

import static com.example.util.Input.fileToArray;

@Slf4j
public class BrandsDao implements Dao<ProductionBrands> {
    private Connection connection;
    public Statement statement;

    {
        try {
            //get connection to DB
            connection = DatabaseConnection.getInstance().getConnection();
            //create a statement
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet selectAll() {
        ResultSet rs = null;
        log.info("Execute query: SELECT * FROM production.brands");
        try {
            rs = statement.executeQuery("SELECT * FROM production.brands");

            log.info("Query was executed successfully");
        } catch (SQLException e) {
            log.error("Query was not executed!", e);
        }
        return rs;
    }

    @Override
    public ResultSet selectById(int id) {
        log.info("Execute query: SELECT * FROM production.brands WHERE brand_id =" + id);
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("SELECT * FROM production.brands WHERE brand_id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            log.info("Query was executed successfully");
        } catch (SQLException e) {
            log.error("Query was not executed!", e);
        }
        return rs;
    }

    @Override
    public ResultSet select(String sqlRequest) {
        ResultSet rs = null;
        log.info("Execute query: " + sqlRequest);
        try {
            rs = statement.executeQuery(sqlRequest);
            log.info("Query was executed successfully");
        } catch (SQLException e) {
            log.error("Query was not executed!", e);
        }
        return rs;
    }

    @Override
    public boolean update(ProductionBrands value, int id) {
        log.info("Update brand with ID " + id + " at production.brands table");
        String query = "UPDATE production.brands SET brand_name=? WHERE brand_id = ?";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, value.getBrandName());
            ps.setInt(2, id);
            ps.executeUpdate();

            log.info("Brand name is updated");
            return true;
        } catch (SQLException e) {
            log.error("Update was not executed", e);
        }
        return false;
    }

    @Override
    public boolean delete(String clause) {
        log.info("Delete brand from production.brands table where: " + clause);
        try {
            if (clause.isEmpty()) {
                log.info("The clause is not specified, cannot delete");
                return false;
            }
            statement.executeUpdate("DELETE FROM production.brands WHERE " + clause);
            log.info("Delete was executed successfully");
            return true;

        } catch (SQLException e) {
            log.error("Delete was not processed!", e);
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        log.info("Delete brand with ID " + id + " from production.brands table");
        String query = "DELETE FROM production.brands WHERE brand_id = ?";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();

            log.info("Brand is deleted");
            return true;
        } catch (SQLException e) {
            log.error("Delete was not processed", e);
        }
        return false;
    }

    public int insert(ProductionBrands values) {
        int rs = 0;
        log.info("Add new brand to production.brands table");
        try {
            rs = statement.executeUpdate("INSERT INTO production.brands (brand_name) VALUES ('" +
                    values.getBrandName() + "')");
            log.info("New brand is added");
        } catch (SQLException e) {
            log.error("Brand was not added!", e);
        }
        return rs;
    }

    @Override
    public boolean bulkInsert(File csv) throws SQLException {
        String[] values = fileToArray(csv.getPath());
        log.info("Add new brands from .csv file to production.brands table");

        try {
            for (int i = 0; i < values.length; i++) {
                statement.executeUpdate("INSERT INTO production.brands " +
                        "(brand_name)" +
                        " VALUES ('" + values[i] + "')");
            }
            log.info("New brands from .csv file were added with success");
            return true;
        } catch (SQLException e) {
            log.error("brands were not added!", e);
        }
        return false;
    }

    public void printResult(ResultSet result) {
        try {
            while (result.next()) { //read data from each row
                System.out.println(result.getString(1) + ". " + result.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
