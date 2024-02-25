package view;

public class Productvalue {
    private String model;
    private String brandname;
    private int price;
    private int newprice;
    public void setModel(String model){
        this.model=model;
    }
    public void setBrandname(String brandname){
        this.brandname=brandname;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public void setNewprice(int newprice){
        this.newprice=newprice;
    }
    public String getModel(){
        return model;
    }
    public String getBrandname(){
        return brandname;
    }
    public int getPrice(){
        return price;
    }
    public int getNewprice(){
        return newprice;
    }

}
