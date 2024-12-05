package Librarycatalog.classes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
public class Account {
    private final String Account_id;
    private String Username;
    private String Password;
    String Name;
    private String E_mail;
    private String Phone_Number;
    private String Address;
    public boolean IsLoggedIn = false;
    public static int UsersNom=0;
    public Account(String Username,String Password,String Name,String E_mail, String Phone_Number, String Address)  {
           this.Username=Username;
            this.Password=Password;
            this.Name = Name;
            this.E_mail = E_mail;
            this.Phone_Number = Phone_Number;
            this.Address = Address;
            this.Account_id = Id_Generator();
            UsersNom++;
        }

    String Id_Generator() {
        Random Id = new Random();
        return String.format("%06d", Id.nextInt(1000000));
    }

    public void LoggIn(String Username, String Password) {
        if(this.Username.equals(Username) && this.Password.equals(Password)){
            System.out.println("Logged In Successfully");
            IsLoggedIn=true;
        }
        else{
            System.out.println("Incorrect Username or Password");
        }
    }

    public void LogOut(){
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
    public String getUsername () {
        if(IsLoggedIn) {
            return Username;
        }
        else{
            return "Logged Out";
        }
    }
    public String getPassword () {
        if(IsLoggedIn) {
            return Password;
        }
        else{
            return "Logged Out";
        }
    }
    public String getName () {
        if(IsLoggedIn) {
            return Name;
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
    Scanner Input = new Scanner(System.in);
   public void Change_Password(String Current_Password,String Changed_Password) {

       int Try_Counter = 1;
       if (IsLoggedIn) {
       while (Try_Counter <= 4) {
               if (this.Password.equals(Current_Password)) {
                   this.Password=Changed_Password;
                   System.out.println("Password Changed Successfully");
                   break;
               } else {
                   System.out.println("Incorrect Password");
                   Try_Counter++;
                   System.out.println("1-Try Again"+"\n"+"2-Exit");
                   int Choice=Input.nextInt();
                   switch (Choice){
                       case 1:{Input.nextLine();
                              System.out.println("Enter Current Password:");
                              Current_Password = Input.nextLine();
                              System.out.println("Enter New Password:");
                              Changed_Password= Input.nextLine();
                               break;
                       }
                       case 2: {
                           return;
                       }
                   }
               }
           }
       if (Try_Counter == 5) {
           LogOut();
           System.out.println("You Are Logged Out");
           }
       }
   }
}


