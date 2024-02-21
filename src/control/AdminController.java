package control;
import model.*;
public class AdminController {
    public static String admin(String admin_id,String password){
        return AdminModel.Admin(admin_id,password);
    }
}
