package view;

import control.CartController;
import control.ProductController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserView {
    public static void userVisit(String user_id) throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("|--  1. Display all Products               --|");
        System.out.println("|--  2. Cart and Payment Description       --|");
        System.out.println("|--  3. Add to Cart                        --|");
        System.out.println("|--  4. Show Cart                          --|");
        System.out.println("|--  5. Remove From Cart                   --|");
        System.out.println("|--  6. Exit                               --|");
        System.out.println("----------------------------------------------");
        int n=sc.nextInt();
        userFunction(n,user_id);
    }
    public static void userFunction(int n,String user_id) throws SQLException {
        Scanner sc=new Scanner(System.in);
        switch (n){
            case 1:
                HashMap<String,String> product= ProductController.displayProduct();
                for (Map.Entry<String,String> pair : product.entrySet()) {
                    System.out.println(String.format("Model: %s, Brand is : %s", pair.getValue(), pair.getKey()));
                }
                UserView.userVisit(user_id);
                break;
            case 2:
                for(int i=0;i<120;i++)
                    System.out.print("-");
                System.out.println();
                System.out.println("When adding a product to the cart, please note that we do not process the rent amount online.\nYou can only finalize the transaction by visiting our shop in person. Upon visiting, please ensure\nto provide original identification documents such as Aadhaar or a driving license for verification purposes.\nWe do not accept online payments for rent; all transactions must be completed physically at our shop.");
                for(int i=0;i<120;i++)
                    System.out.print("-");
                System.out.println();
                UserView.userVisit(user_id);
                break;
            case 3:
                System.out.println("Enter the Model: ");
                String md=sc.nextLine();
                ArrayList<String> cart=ProductController.searchByModel(md);
                String cart1=CartController.addToCart(cart,user_id);
                System.out.println(cart1);
                UserView.userVisit(user_id);
                break;
            case 4:
                String show=CartController.showCart(user_id);
                System.out.println(show);
                UserView.userVisit(user_id);
                break;
            case 5:
                System.out.println("Enter the Model Name to Remove From Cart: ");
                String modelre=sc.nextLine();
                String remove=CartController.removeCart(modelre,user_id);
                System.out.println(remove);
                UserView.userVisit(user_id);
                break;
            case 6:
                System.out.println("--------------------------");
                System.out.println("Thank You For Using.......");
                System.out.println("--------------------------");
                new Index();
        }
    }
}
