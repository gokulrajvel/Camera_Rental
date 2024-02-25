package control;

import model.ProductModel;
import view.Productvalue;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductController {
    public static HashMap<String,String> displayProduct(){
        return ProductModel.displayAllProduct();
    }
    public static ArrayList<String> searchByModel(String model) {
        Productvalue productvalue=new Productvalue();
        productvalue.setModel(model);
        return ProductModel.searchByModel(productvalue.getModel());
    }
    public static String changeRentAmount(int newrent,String model){
        Productvalue productvalue=new Productvalue();
        productvalue.setNewprice(newrent);
        productvalue.setModel(model);
        return ProductModel.alterRentAmount(productvalue.getNewprice(),productvalue.getModel());
    }
    public static String insertProduct(String brand,String model,int rentamount){
        Productvalue productvalue=new Productvalue();
        productvalue.setBrandname(brand);
        productvalue.setModel(model);
        productvalue.setPrice(rentamount);
        return ProductModel.insertProduct(productvalue.getBrandname(),productvalue.getModel(), productvalue.getPrice());
    }
    public static String removeProduct(String model){
        Productvalue productvalue=new Productvalue();
        productvalue.setModel(model);
        return ProductModel.removeProduct(productvalue.getModel());
    }
}
