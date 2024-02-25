package view;

import control.AdminController;
import control.UserController;
import java.sql.SQLException;
import java.util.Scanner;

public class fontview {
    public fontview(int n) throws SQLException {
        Scanner sc=new Scanner(System.in);
        switch (n){
            case 1:
                System.out.println("Enter Email_id: ");
                String user_id=sc.nextLine();
                System.out.println("Enter your Password: ");
                String password=sc.nextLine();
                String m= UserController.sign_in(user_id,password);
                if(m.equals("0")){
                    System.out.println("\t----------------");
                    System.out.println("\tSign in Error..!");
                    System.out.println("\t----------------");
                    System.out.println();
                    new Index();
                }
                else{
                    System.out.println(m);
                    UserView.userVisit(user_id);
                }
                break;
            case 2:
                System.out.println("Enter EmailID: ");
                String email=sc.nextLine();
                System.out.println("Enter Password: ");
                String passWord=sc.nextLine();
                System.out.println("Enter phone Number:");
                String num=sc.nextLine();
                System.out.println("Enter Your PinCode: ");
                String pin=sc.nextLine();
                System.out.println("Enter Driving License No: ");
                String dl=sc.nextLine();
                String val= UserController.signup(email,passWord,num,pin,dl);
                System.out.println(val);
                new Index();
                break;
            case 3:
                System.out.println("Enter Admin_id: ");
                String Adim=sc.nextLine();
                System.out.println("Enter PassWord: ");
                String pw=sc.nextLine();
                String ad=AdminController.admin(Adim,pw);
                if(ad.equals("0")){
                    System.out.println("\t-----------------------------------------------------------");
                    System.out.println("\tLogin Failed Please Enter Correct Admin_ID and Password..!!");
                    System.out.println("\t-----------------------------------------------------------");
                    new Index();
                }
                else{
                    System.out.println(ad);
                    new AdminView();
                }
                break;
        }
    }
}
