package control;
import model.UserModel;
import view.UserValue;

import java.sql.SQLException;
public class UserController {
    public static String sign_in(String user_id,String password){
        UserValue userValue=new UserValue();
        userValue.setUserid(user_id);
        userValue.setPassword(password);
        String userid=userValue.getUserid();
        String passWord=userValue.getPassword();
        return UserModel.login(userid,passWord);
    }
    public static String signup(String email,String password,String num,String pin,String Drivingl) throws SQLException {
        UserValue userValue=new UserValue();
        userValue.setUserid(email);
        userValue.setPassword(password);
        userValue.setNum(num);
        userValue.setPin(pin);
        userValue.setDriving(Drivingl);
        String userid=userValue.getUserid();
        String passWord=userValue.getPassword();
        String Num=userValue.getNum();
        String Pin=userValue.getPin();
        String drivingl=userValue.getDriving();
        return UserModel.user(userid,passWord,Num,Pin,drivingl);
    }
}