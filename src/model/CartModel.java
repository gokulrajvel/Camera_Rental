package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartModel {
    public static String addToCart(ArrayList<String> arr,String user_id){
        try {
            DbConnection dbConnection = new DbConnection();
            Connection con = dbConnection.getConnection();
            String insertQuery = "INSERT INTO cart (user_id, brandname, model,rentamount) VALUES (?, ?, ?,?)";

            try (PreparedStatement insertStatement = con.prepareStatement(insertQuery)) {
                insertStatement.setString(1, user_id);
                insertStatement.setString(2, arr.get(0));
                insertStatement.setString(3, arr.get(1));
                insertStatement.setInt(4, Integer.parseInt(arr.get(2)));

                int rowsAffected = insertStatement.executeUpdate();
                if (rowsAffected > 0) {
                    return "Product added to cart successfully";
                } else {
                    return "Failed to add product to cart";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while adding product to cart: " + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "Unexpected error occurred: " + e.getMessage();
        }
    }
    public static String showCart(String userId) {
        try {
            DbConnection dbConnection = new DbConnection();
            Connection con = dbConnection.getConnection();
            String selectQuery = "SELECT * FROM cart WHERE user_id = ?";

            try (PreparedStatement selectStatement = con.prepareStatement(selectQuery)) {
                selectStatement.setString(1, userId);

                ResultSet resultSet = selectStatement.executeQuery();
                StringBuilder cartContents = new StringBuilder();

                while (resultSet.next()) {
                    String brandname = resultSet.getString("brandname");
                    String model = resultSet.getString("model");
                    String rentamount = resultSet.getString("rentamount");

                    // Append product information to StringBuilder
                    cartContents.append("Brand Name: ").append(brandname)
                            .append(", Model: ").append(model)
                            .append(", Rent Price: ").append(rentamount)
                            .append("\n");
                }

                if (cartContents.length() > 0) {
                    return "Cart contents for user " + userId + ":\n" + cartContents;
                } else {
                    return "Cart is empty for user " + userId;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while retrieving cart: " + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "Unexpected error occurred: " + e.getMessage();
        }
    }
    public static String removeCart(String model,String user_id) {
        try {
            DbConnection dbConnection = new DbConnection();
            Connection con = dbConnection.getConnection();
            String deleteQuery = "DELETE FROM cart WHERE model = ? AND user_id=?";

            try (PreparedStatement deleteStatement = con.prepareStatement(deleteQuery)) {
                deleteStatement.setString(1, model);
                deleteStatement.setString(2, user_id);
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
