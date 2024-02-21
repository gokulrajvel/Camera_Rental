package control;

import model.ProductModel;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductController {
    public static HashMap<String,String> displayProduct(){
        return ProductModel.displayAllProduct();
    }
    public static ArrayList<String> searchByModel(String model) {
            return ProductModel.searchByModel(model);
        }
    public static String changeRentAmount(int newrent,String model){
        return ProductModel.alterRentAmount(newrent, model);
    }
    public static String insertProduct(String brand,String model,int rentamount){
        return ProductModel.insertProduct(brand,model,rentamount);
    }
    public static String removeProduct(String model){
        return ProductModel.removeProduct(model);
    }
}
