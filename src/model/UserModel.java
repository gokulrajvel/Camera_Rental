package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    public static String login(String user_id,String password){
        try {
            DbConnection dbConnection = new DbConnection();
            Connection con = dbConnection.getConnection();
            String query = "SELECT * FROM user WHERE user_id = ? AND password = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, user_id);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return "Login successful!";
                } else {
                    return "0";
//                    new req();
                }
            }
        } catch (Exception e) {
//                e.printStackTrace();
        }
        return "";
    }
    public static String user(String user_id, String password, String phone, String pin, String dl) throws SQLException {
        DbConnection dbConnection = new DbConnection();
        Connection con = dbConnection.getConnection();
        String selectQuery = "SELECT * FROM user WHERE user_id = ?";
        try (PreparedStatement selectStatement = con.prepareStatement(selectQuery)) {
            selectStatement.setString(1, user_id);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                // User already exists, handle accordingly (e.g., display an error message)
                System.out.println("User already exists. Registration failed!");
            } else {
                // User doesn't exist, proceed with registration (INSERT operation)
                String insertQuery = "INSERT INTO user (user_id, password,phoneno,pincode,license) VALUES (?, ?,?,?,?)";
                try (PreparedStatement insertStatement = con.prepareStatement(insertQuery)) {
                    insertStatement.setString(1, user_id);
                    insertStatement.setString(2, password);
                    insertStatement.setString(3, phone);
                    insertStatement.setString(4, pin);
                    insertStatement.setString(5, dl);

                    int rowsAffected = insertStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        return "\tRegistration successful!";
                    } else {
                        return "\tRegistration failed";
                    }
                }
            }
        }
        return "";
    }
}
