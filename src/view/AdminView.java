package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import control.*;
import model.ProductModel;

public class AdminView {
    public AdminView() throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("|-   1. Sort by the name                   --|");
        System.out.println("|-   2. Display All Product                --|");
        System.out.println("|-   3. Search a Model                     --|");
        System.out.println("|-   4. Change the Security deposit amount --|");
        System.out.println("|-   5. Add New Product                    --|");
        System.out.println("|-   6. Delete Product From the DataBase   --|");
        System.out.println("|-   7. Exit                               --|");
        System.out.println("----------------------------------------------");
        int n=sc.nextInt();
        switch (n){
            case 1:
                ArrayList<String> pro= ProductModel.sortByName();
                for(String li:pro)
                System.out.println("ProductName: "+li);
                new AdminView();
                break;
            case 2:
                HashMap<String,String> arr=ProductModel.displayAllProduct();
                for (Map.Entry<String,String> pair : arr.entrySet()) {
                    System.out.println(String.format("Model: %s, Product_Name is : %s", pair.getValue(), pair.getKey()));
                }
                new AdminView();
                break;
            case 3:
                sc.nextLine();
                System.out.println("Enter the Model: ");
                String model=sc.nextLine();
                ArrayList<String> product=ProductController.searchByModel(model);
                System.out.println("Product Name: "+product.get(0));
                System.out.println("Model:"+product.get(1));
                System.out.println("Rent Price: "+product.get(2));
                new AdminView();
                break;
            case 4:
                sc.nextLine();
                System.out.println("Enter the Model to Change the Rent Amount: ");
                String mo=sc.nextLine();
                System.out.println("Enter the Amount to Change the Rent Price");
                int newamount=sc.nextInt();
                String rent=ProductController.changeRentAmount(newamount,mo);
                System.out.println(rent);
                new AdminView();
                break;
            case 5:
                sc.nextLine();
                System.out.println("Enter Product Brand: ");
                String brand=sc.nextLine();
                System.out.println("Enter Model Name: ");
                String newmodel=sc.nextLine();
                System.out.println("Enter rent Price: ");
                int price=sc.nextInt();
                String val=ProductModel.insertProduct(brand,newmodel,price);
                System.out.println(val);
                new AdminView();
                break;
            case 6:
                sc.nextLine();
                System.out.println("Enter the Model Name the Remove the Product: ");
                String mod=sc.nextLine();
                String delete=ProductModel.removeProduct(mod);
                System.out.println(delete);
                new AdminView();
                break;
            case 7:
                System.out.println("----------------------------------------------");
                System.out.println("|-          Admin Page close               --|");
                System.out.println("----------------------------------------------");
                new Index();
                break;
        }
    }

}