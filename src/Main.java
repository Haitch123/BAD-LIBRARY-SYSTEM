import Librarycatalog.classes.Account;

public class Main {
    public static void main(String[] args) {
        String name="Ahmed";
        String user="Haitch";
        String pass="1";
        String email="@";
        String phone="111";
        String address="5-street";
        Account user1=new Account(name,user,pass,email,phone,address);
        user1.LoggIn(user,pass);

        user1.Change_Password(user,"2","6");





    }
}