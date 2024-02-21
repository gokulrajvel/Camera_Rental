package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mvcmodel",
                    "root",
                    "mrdio2");
        } catch (Exception e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        }
    }
}
