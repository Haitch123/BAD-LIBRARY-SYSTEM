package Librarycatalog.classes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class Account {
    private  String Account_id;
    String Name;
    private String E_mail;
    private String Phone_Number;
    private String Address;
    public boolean IsLoggedIn = false;
    HashMap<String, String> username_Password=new HashMap<>();
    public void SignUp(String Name, String username, String Password, String E_mail, String Phone_Number, String Address, BufferedWriter Writer,BufferedReader Reader) throws IOException {//(sign up)

        boolean UserExist=false;
        String Check;
        while((Check=Reader.readLine())!=null) {
            if (Check.startsWith("Username & Password: ")) {
                Check = Check.substring("Username & Password: ".length());
                String[] user=Check.split("=");
                if(user[0].replace("{","").trim().equals(username)){
                    System.out.println("User Already Exists");
                    UserExist=true;
                    break;
                }

            }
        }
        if(!UserExist) {
            this.Name = Name;
            this.E_mail = E_mail;
            this.Phone_Number = Phone_Number;
            this.Address = Address;
            this.Account_id = Id_Generator();
            username_Password.put(username, Password);
            Writer.write("Username & Password: " + username_Password + "\n" + "Name: " + Name + "\n" + "E_mail: " + E_mail + "\n" + "Phone Number: " + Phone_Number + "\n" + "Address: " + Address + "\n");
        }
    }

    String Id_Generator() {
        Random Id = new Random();
        return String.format("%06d", Id.nextInt(1000000));
    }

    public void LoggIn(String username, String Password, BufferedReader Reader) throws IOException {
        String Tempuser;

        while((Tempuser=Reader.readLine())!=null){
            if(Tempuser.startsWith("Username & Password: ")){
                Tempuser=Tempuser.substring("Username & Password: ".length());
                String[] Parts = Tempuser.split("=");
                if(Parts[0].replace("{","").trim().equals(username)){
                    if(Parts[1].replace("}","").trim().equals(Password)){
                        System.out.println("Logged in successfully");
                        IsLoggedIn=true;


                    }
                    else{
                        System.out.println("Invalid Password");
                    }

                }
            }

        }
          if(!IsLoggedIn){
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
