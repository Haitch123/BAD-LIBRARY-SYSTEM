package Librarycatalog.classes;
import java.util.ArrayList;

public class Administrator extends Account{
   public Administrator(String Username,String Password,String Name,String E_mail, String Phone_Number, String Address,ArrayList<Account>Accounts,ArrayList<Administrator>AdminAccounts){
       super( Username, Password, Name, E_mail,  Phone_Number,  Address,Accounts);
       Account_Type="Admin";



    }
}
