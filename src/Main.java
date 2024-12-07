import Librarycatalog.classes.Account;
import Librarycatalog.classes.Administrator;
import Librarycatalog.classes.PasswordException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static  void ReadingData(ArrayList<Account> Accounts){
        File file=new File("Details.ser");
        System.out.println(file.getAbsolutePath());
        try{
            ObjectInputStream obj=new ObjectInputStream(new FileInputStream(file));
            while(true){
                Object object=obj.readObject();
                if(object instanceof Account){
                    Accounts.add((Account)object);
                }
            }
        }  catch (EOFException eof) {
            System.out.println("End of file reached.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
    public static void WritingData(ArrayList<Account> Accounts){
        File file=new File("Details.ser");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Account user : Accounts) {
                outputStream.writeObject(user);
            }
            System.out.println("Accounts saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error during writing: " + e.getMessage());
        }
    }
    public static void main(String[] args) throws IOException {
        ArrayList<Account> Accounts=new ArrayList<>();
        //ReadingData(Accounts);
        Account User1=new Account("ahmed1","Hesh5100001!","@","111","1","1",Accounts);
        Account User2=new Account("ahmed2","Hesh5188881@","@","111","1","1",Accounts);
        Account User3=new Account("ahmed3","Hesh5154441@","@","111","1","1",Accounts);
        Account User4=new Account("ahmed4","Hesh516712@","@","111","1","1",Accounts);
        Accounts.add(User1);
        Accounts.add(User2);
        Accounts.add(User3);
        Accounts.add(User4);
        Accounts.get(0).LoggIn("ahmed1","Hesh5100001!");
        Accounts.get(0).Display_Details();

        Accounts.get(0).Display_Details();


        /*for(Account account:Accounts) {
            System.out.println(account.getAccount_Id());
        }
        //Accounts.get(0).Change_Username("ahmed4",Accounts);

        /*for (Account account : Accounts) {
            try {
                account.UniquePassword(account.getPassword());
                System.out.println(account.getUsername());
            }
            catch(PasswordException e){
                System.out.println(e.getMessage());
            }
        }*/
        WritingData(Accounts);


    }
}














        /*String username="Haitch";
        String pass="1";
        String name="Ahmed";
        String email="@";
        String phone="111";
        String address="5-street";
        Account user1=new Account(username,pass,name,email,phone,address);

        ArrayList<Account> Users = new ArrayList<>();
        BufferedReader Reader=new BufferedReader(new FileReader("User Details.txt"));
        String line;
        while((line=Reader.readLine())!=null){
            String[] Parts=line.split(";");
            if(Parts.length==6) {
                System.out.println("Yes");
                Parts[0] = line.substring("User Number 1:".length()).trim();
                Account user = new Account(Parts[0].trim(), Parts[1].trim(), Parts[2].trim(), Parts[3].trim(), Parts[4].trim(), Parts[5].trim());
                System.out.println(Parts[0] + "\n" + Parts[1] + "\n" + Parts[2] + "\n" + Parts[3]);
                Users.add(user);
            }
        }
        Users.get(0).LoggIn("Haitch","1");
        System.out.println(Users.get(0).getUsername());
        Users.add(new Account("Haitch2","2","Hesham","@111","222","10-street"));
        Users.getLast().LoggIn("Haitch2","2");
        Reader.close();
        user1.LoggIn(username,pass);
        BufferedWriter Writer=new BufferedWriter(new FileWriter("User Details.txt"));
        for(int j=0;j<Users.size();j++) {
            Users.get(j).IsLoggedIn=true;
            Writer.write("User Number " +  String.valueOf(j+1) + ": " + Users.get(j).getUsername() + ";" +
                    Users.get(j).getPassword() + ";" +
                    Users.get(j).getName() + ";" +
                    Users.get(j).getE_mail() + ";" +
                    Users.get(j).getPhone_Number() + ";" +
                    Users.get(j).getAddress() +"\n");
        }
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