package Librarycatalog.classes;


import java.util.HashMap;
import java.util.Random;

public class Account {
    private final String Account_id;
    String Name;
    private String E_mail;
    private String Phone_Number;
    private String Address;
    public boolean IsLoggedIn = false;
    HashMap<String, String> username_Password=new HashMap<>();
    public Account(String Name, String username, String Password, String E_mail, String Phone_Number, String Address) {
        this.Name = Name;
        this.E_mail = E_mail;
        this.Phone_Number = Phone_Number;
        this.Address = Address;
        this.Account_id = Id_Generator();
        username_Password.put(username,Password);
    }

    String Id_Generator() {
        Random Id = new Random();
        return String.format("%06d", Id.nextInt(1000000));
    }

    public void LoggIn(String username, String Password) {
        if (username_Password.containsKey(username)){
           username_Password.get(username);
           if( username_Password.get(username).equals(Password)){
               System.out.println("Logged in successfully");
               IsLoggedIn=true;
           }
           else{
               System.out.println("Invalid Password");
           }
        }
        else{
            System.out.println("User Not Found");
        }
    }
    public void LoggOut(){
        IsLoggedIn=false;
    }
        public void setE_mail (String e_mail){
        if(IsLoggedIn) {
            E_mail = e_mail;
        }
    }
        public void setPhone_Number (String phone_Number){
            if(IsLoggedIn) {
                Phone_Number = phone_Number;
            }
    }
        public void setAddress (String address){
            if(IsLoggedIn) {
                Address = address;
            }
    }
        public String getAccount_id () {
            if(IsLoggedIn) {
                return Account_id;
            }
            else{
                return "Logged Out";
            }
    }
        public String getE_mail () {
            if(IsLoggedIn) {
                return E_mail;
            }
            else{
                return "Logged Out";
            }
    }
        public String getPhone_Number () {
            if(IsLoggedIn) {
                return Phone_Number;
            }
            else{
                return "Logged Out";
            }
    }
        public String getAddress () {
            if(IsLoggedIn) {
                return Address;
            }
            else{
                return "Logged Out";
            }
    }

   public void Change_Password(String username,String Current_Password,String Changed_Password){
        if(IsLoggedIn){
            if(Current_Password.equals(username_Password.get(username))){
                username_Password.replace(username,Changed_Password);
                System.out.println("Password Changed Successfully");
            }
            else{
                System.out.println("Incorrect Password");
            }

        }
    }

}
