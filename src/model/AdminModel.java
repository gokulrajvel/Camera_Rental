package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminModel {
    public static String Admin(String user_id,String password){
        try {
            DbConnection dbConnection = new DbConnection();
            Connection con = dbConnection.getConnection();
            String query = "SELECT * FROM admin WHERE admin = ? AND password = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, user_id);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return "Login successful!";
//                    AdminVist av= new AdminVist();

                } else {
                    return "0";
//                    req Req=new req();
                }
            }
        } catch (Exception e) {
//                e.printStackTrace();
        }
        return "";
    }
}
