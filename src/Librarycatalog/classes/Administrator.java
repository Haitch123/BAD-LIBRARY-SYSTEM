package Librarycatalog.classes;
import Librarycatalog.classes.Book;
import java.util.ArrayList;

public class Administrator extends Account2{
   public Administrator(String Username,String Password,String Name,String E_mail, String Phone_Number, String Address){
       super( Username, Password, Name, E_mail,  Phone_Number,  Address);
       this.Account_Type="Admin";

    }
    public void Add_Book(ArrayList<Book>Books,Book NewBook){
       Books.add(NewBook);
    }
    public void Remove_Book(ArrayList<Book>Books,Book RemovedBook){
        Books.remove(RemovedBook);
    }
    public Administrator Add_User(String Username,String Password,String Name,String E_mail, String Phone_Number, String Address){
       Administrator NewUser=new Administrator( Username, Password, Name, E_mail,  Phone_Number,  Address);
       return NewUser;
    }
    public boolean Remove_User(String Username,Administrator User){
       if(Username.equals(User.getUsername())){
           return true;
       }
       else{
           return false;
       }
    }
}
