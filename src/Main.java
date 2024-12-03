import Librarycatalog.classes.Account;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String name="Ahmed";
        String user="Haitch";
        String pass="1";
        String email="@";
        String phone="111";
        String address="5-street";
        Account user1;
        String name2="Hesham";
        String user2="Zaki";
        String pass2="5";
        String email2="7000";
        String phone2="222";
        String address2="100-street";
        Account user22;
        BufferedWriter Writer=new BufferedWriter(new FileWriter("User Details.txt",true));
        try {
            BufferedReader Reader2=new BufferedReader(new FileReader("User Details.txt"));
            user22 = new Account(name2,user2,pass2,email2,phone2,address2,Writer,Reader2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally{
            Writer.close();
        }
        BufferedReader Reader=new BufferedReader(new FileReader("User Details.txt"));
        user22.LoggIn(user2,pass2,Reader);
        Reader.close();




    }
}