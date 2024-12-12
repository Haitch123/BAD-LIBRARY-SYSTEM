package Librarycatalog.classes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
public abstract class Account implements Serializable {
    private final String Account_Id;
    private String Username;
    private String Password;
    private String Name;
    private String E_mail;
    private String Phone_Number;
    private String Address;
    private boolean IsLoggedIn = false;
    protected boolean Admin=false;
    private static int NomOfUsers=0;
    public Account(String Username,String Password,String Name,String E_mail, String Phone_Number, String Address,ArrayList<Customer>Accounts)  {
            this.Username = Username;
            if(UniquePassword(Password)) {
                this.Password = Password;
            }
            this.Name = Name;
            this.E_mail = E_mail;
            this.Phone_Number = Phone_Number;
            this.Address = Address;
            Account_Id = Id_Generator(Accounts);
            NomOfUsers++;
        }

    String Id_Generator(ArrayList<Customer> Accounts) {
        String TempAccountId;
        do {
            Random Id = new Random();
            TempAccountId=String.format("%06d", Id.nextInt(1000000));
        }while(UniqueAccount_Id(TempAccountId,Accounts));
        return TempAccountId;
    }

    public boolean LoggIn(String Username, String Password) {
        if(this.Username.equals(Username) && this.Password.equals(Password)){
            System.out.println("Logged In Successfully");
            IsLoggedIn=true;
            return true;
        }
        else{
            System.out.println("Incorrect Username or Password");
            return false;
        }
    }

    public void LogOut(){
        IsLoggedIn=false;
        System.out.println("Logged Out Successfully");
    }

    public void setPassword(String password) {
        if(UniquePassword(password)) {
            Password = password;
        }
    }
    public void setName(String name) {
        Name = name;
    }
    public void setLoggedIn(boolean loggedIn) {
        IsLoggedIn = loggedIn;
    }
    public void setAdmin(boolean admin) {
        Admin = admin;
    }
    public static void setNomOfUsers(int nomOfUsers) {
        NomOfUsers = nomOfUsers;
    }
    public void setUsername (String username){
            Username = username;
    }
        public void setE_mail (String e_mail){
            E_mail = e_mail;
    }
        public void setPhone_Number (String phone_Number){
                Phone_Number = phone_Number;
    }
        public void setAddress (String address){
                Address = address;
    }
    public String getUsername () {
        return Username;
    }
    public String getPassword () {
        return Password;
    }
    public String getName () {
        return Name;
    }
        public String getE_mail () {
          return E_mail;
    }
        public String getPhone_Number () {
          return Phone_Number;
    }
        public String getAddress () {
         return Address;
    }
    public String getAccount_Id () {
        return Account_Id;
    }
    public static int getNomOfUsers() {
        return NomOfUsers;
    }
    public void Change_Password(String Current_Password, String Changed_Password) {
       Scanner Input = new Scanner(System.in);
       int Try_Counter = 1;
       if (IsLoggedIn) {
       while (Try_Counter <= 4) {
               if (this.Password.equals(Current_Password)) {
                   if(UniquePassword(Changed_Password)) {
                       this.Password = Changed_Password;
                       System.out.println("Password Changed Successfully");
                       break;
                   }
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
   public void Display_Details(){
        if(IsLoggedIn){
            System.out.println("Your Username: "+Username);
            System.out.println("Your Name: "+Name);
            System.out.println("Your E_mail: "+E_mail);
            System.out.println("Your Phone_Number: "+Phone_Number);
            System.out.println("Your Address: "+Address);
            System.out.println("----------------------------------");
        }
        else{
            System.out.println("You Need To Log In First");
        }
   }
   public void Change_Username( String NewUsername,ArrayList<Account>Accounts){
        if(!Check_Username_Exists(NewUsername,Accounts)){
            setUsername(NewUsername);
            System.out.println("Username Changed Successfully");
        }
   }
   public static boolean Check_Username_Exists(String NewUsername,ArrayList<Account> Accounts){
        boolean Exists=false;
       for (Account account : Accounts) {
           if (NewUsername.equals(account.getUsername())) {
               Exists = true;
               System.out.println("Username Already Exists");
               break;
           }
       }
        return Exists;
   }
   public boolean UniquePassword(String Password)throws PasswordException{
        if(Password.length()>=8 && Password.matches(".*[!@#$%&*].*") && Password.matches(".*[a-z].*") && Password.matches(".*[A-Z].*")){
            return true;
        }
        else{
            throw new PasswordException();
        }
   }
   public boolean UniqueAccount_Id(String TempAccountId,ArrayList<Customer> Accounts){

        for(Customer account:Accounts){
            if(account.getAccount_Id().equals(TempAccountId)){
                return true;
            }
        }
        return false;
   }
   public void DeleteAccount(ArrayList<Account> Accounts,String Password) {
       if (IsLoggedIn) {
           if (Password.equals(this.Password)) {
               Accounts.remove(this);
               System.out.println("Account Deleted Successfully");
           }
       }
   }
}


