package control;

import model.UserModel;

import java.sql.SQLException;

public class UserController {
    public static String sign_in(String user_id,String password){
        return UserModel.login(user_id,password);
    }
    public static String signup(String email,String password,String num,String pin,String Drivingl) throws SQLException {
        return UserModel.user(email,password,num,pin,Drivingl);

    }
}
