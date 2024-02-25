package view;

public class UserValue {
    private String userid;
    private String password;
    private String num;
    private String pin;
    private String driving;
    public void setUserid(String userid){
        this.userid=userid;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setNum(String num){
        this.num=num;
    }
    public void setPin(String pin){
        this.pin=pin;
    }
    public void setDriving(String driving){
        this.driving=driving;
    }
    public String getUserid(){
        return userid;
    }
    public String getPassword(){
        return password;
    }
    public String getNum(){
        return num;
    }
    public String getPin(){
        return pin;
    }
    public String getDriving(){
        return driving;
    }
}
