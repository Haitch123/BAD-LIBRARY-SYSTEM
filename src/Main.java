import Librarycatalog.classes.Account;

import java.io.*;
import java.util.ArrayList;


public class Main {






    public static void main(String[] args) throws IOException {
        String username="Haitch";
        String pass="1";
        String name="Ahmed";
        String email="@";
        String phone="111";
        String address="5-street";
        Account user1=new Account(username,pass,name,email,phone,address);

        ArrayList<Account> Users = new ArrayList<>();
        BufferedReader Reader=new BufferedReader(new FileReader("User Details.txt"));
        int i=0;
        String line;
        while((line=Reader.readLine())!=null){
            String[] Parts=line.split(",");
           Account user=new Account(Parts[0].trim(),Parts[1].trim(),Parts[2].trim(),Parts[3].trim(),Parts[4].trim(),Parts[5].trim());
           Users.add(user);
            i++;
        }
        Users.get(1).LoggIn("Hesham","5");
        System.out.println(Users.get(1).getUsername());
        Reader.close();
        BufferedWriter Writer=new BufferedWriter(new FileWriter("User Details.txt"));
        Writer.write( user1.getUsername() +","+
                user1.getPassword() +","+
                user1.getName() +","+
                user1.getE_mail() +","+
                user1.getPhone_Number() +","+
                user1.getAddress() +"," );

        Writer.close();

















    }
}
        /*String username="Haitch";
        String pass="1";
        String name="Ahmed";
        String email="@";
        String phone="111";
        String address="5-street";
        Account user1=new Account(username,pass,name,email,phone,address);

        String username2="Zaki";
        String pass2="5";
        String name2="Hesham";
        String email2="7000";
        String phone2="222";
        String address2="100-street";
        Account user2=new Account(username2,pass2,name2,email2,phone2,address2);
        user1.LoggIn(username,pass);


        user1.Change_Password("1","2");
        BufferedWriter Writer=new BufferedWriter(new FileWriter("User Details.txt"));
        Writer.write("Username: " + user1.getUsername() +","+
                "Password: " + user1.getPassword() +","+
                "Name: " + user1.getName() +","+
                "E-mail: " + user1.getE_mail() +","+
                "Phone Number: " + user1.getPhone_Number() +","+
                "Address: " + user1.getAddress() +"," );

        Writer.close();





    }

         */

/*String username="Haitch";
String pass="1";
String name="Ahmed";
String email="@";
String phone="111";
String address="5-street";
Account user1=new Account(username,pass,name,email,phone,address);

String username2="Zaki";
String pass2="5";
String name2="Hesham";
String email2="7000";
String phone2="222";
String address2="100-street";
Account user2=new Account(username2,pass2,name2,email2,phone2,address2);
        user1.LoggIn(username,pass);


        user1.Change_Password("1","2");
BufferedWriter Writer=new BufferedWriter(new FileWriter("User Details.txt"));
        Writer.write( user1.getUsername() +","+
        user1.getPassword() +","+
        user1.getName() +","+
        user1.getE_mail() +","+
        user1.getPhone_Number() +","+
        user1.getAddress() +"," );

        Writer.close();*/