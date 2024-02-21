package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductModel {
    public static HashMap<String, String> displayAllProduct() {
        HashMap<String, String> product = new HashMap<>();
        try {
            DbConnection dbConnection = new DbConnection();
            Connection con = dbConnection.getConnection();
            String listQuery = "SELECT productname, model FROM product ORDER BY productname";
            try (PreparedStatement listStatement = con.prepareStatement(listQuery);
                 ResultSet listResultSet = listStatement.executeQuery()) {

                while (listResultSet.next()) {
                    String productName = listResultSet.getString("productname");
                    String Model = listResultSet.getString("model");
                    product.put(productName, Model);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    public static ArrayList<String> sortByName() {
        ArrayList<String> list = new ArrayList<>();
        try {
            DbConnection dbConnection = new DbConnection();
            Connection con = dbConnection.getConnection();
            String listQuery = "SELECT * FROM product ORDER BY productname";
            try (PreparedStatement listStatement = con.prepareStatement(listQuery);
                 ResultSet listResultSet = listStatement.executeQuery()) {
                while (listResultSet.next()) {
                    String bikeName = listResultSet.getString("productname");
                    list.add(bikeName);
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<String> searchByModel(String model) {
        ArrayList<String> list = new ArrayList<>();
        try {
            DbConnection dbConnection = new DbConnection();
            Connection con = dbConnection.getConnection();
            String listQuery = "SELECT * FROM product WHERE model= ?";
            try (PreparedStatement searchStatement = con.prepareStatement(listQuery)) {
                searchStatement.setString(1, model);

                try (ResultSet searchResultSet = searchStatement.executeQuery()) {
                    if (searchResultSet.next()) {
                        String productname = searchResultSet.getString("productname");
                        String model1 = searchResultSet.getString("model");
                        int rentprice = searchResultSet.getInt("rentprice");
                        list.add(productname);
                        list.add(model1);
                        list.add(String.valueOf(rentprice));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static String alterRentAmount(int newAmount, String model) {
        try {
            DbConnection dbConnection = new DbConnection();
            Connection con = dbConnection.getConnection();
            String updateQuery = "UPDATE product SET rentprice = ? WHERE model = ?";

            try (PreparedStatement updateStatement = con.prepareStatement(updateQuery)) {
                updateStatement.setInt(1, newAmount);
                updateStatement.setString(2, model);
                int rowsAffected = updateStatement.executeUpdate();
                if (rowsAffected > 0) {
                    return "Rent amount updated successfully for model ";
                } else {
                    return "Model not found. Rent amount not updated.";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
//            return "Error occurred while updating rent amount: " + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
//            return "Unexpected error occurred: " + e.getMessage();
        }
        return "";
    }
    public static String insertProduct(String brand,String model, int rentAmount) {
        try {
            DbConnection dbConnection = new DbConnection();
            Connection con = dbConnection.getConnection();
            String insertQuery = "INSERT INTO product (productname, model, rentprice) VALUES (?, ?, ?)";

            try (PreparedStatement insertStatement = con.prepareStatement(insertQuery)) {
                insertStatement.setString(1, brand);
                insertStatement.setString(2, model);
                insertStatement.setInt(3, rentAmount);

                int rowsAffected = insertStatement.executeUpdate();
                if (rowsAffected > 0) {
                    return "Product inserted successfully for model " + model;
                } else {
                    return "Failed to insert product for model " + model;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String removeProduct(String model) {
        try {
            DbConnection dbConnection = new DbConnection();
            Connection con = dbConnection.getConnection();
            String deleteQuery = "DELETE FROM product WHERE model = ?";

            try (PreparedStatement deleteStatement = con.prepareStatement(deleteQuery)) {
                deleteStatement.setString(1, model);

                int rowsAffected = deleteStatement.executeUpdate();
                if (rowsAffected > 0) {
                    return "Product with model " + model + " removed successfully";
                } else {
                    return "Product with model " + model + " not found, no removal performed";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while removing product: " + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "Unexpected error occurred: " + e.getMessage();
        }
    }
}