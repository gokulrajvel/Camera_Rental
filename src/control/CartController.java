package control;

import model.CartModel;

import java.util.ArrayList;

public class CartController {
    public static String addToCart(ArrayList<String> arr,String user_id){
        return CartModel.addToCart(arr,user_id);
    }
    public static String showCart(String user_id) {
        return CartModel.showCart(user_id);
    }
    public static String removeCart(String model,String user_id){
        return CartModel.removeCart(model,user_id);
    }
}
