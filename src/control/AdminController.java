package control;
import model.*;
import view.AdminValue;

public class AdminController {
    public static String admin(String adminId, String password){
        AdminValue adminValue = new AdminValue();
        adminValue.setAdminId(adminId);
        adminValue.setPassword(password);
        String admin_id = adminValue.getAdminId();
        String passwordValue = adminValue.getPassword();
        return AdminModel.Admin(admin_id, passwordValue);
    }
}
