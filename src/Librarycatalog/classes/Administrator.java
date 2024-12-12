package Librarycatalog.classes;
import com.sun.jdi.IntegerValue;

import java.io.Serializable;
import java.util.ArrayList;

public class Administrator extends Account implements Serializable {
   public Administrator(String Username,String Password,String Name,String E_mail, String Phone_Number, String Address,ArrayList<Customer>Users){
       super( Username, Password, Name, E_mail, Phone_Number, Address,Users);
       Admin=true;
    }
    public Account Add_User(String Username,String Password,String Name,String E_mail, String Phone_Number, String Address,ArrayList<Customer> Users){
       return new Administrator(Username,Password,Name,E_mail, Phone_Number, Address,Users);
    }
    public enum Update_User_Option{
       Username,Name,E_mail,Phone_Number,Address
    }
    public void Update_User(String Username,ArrayList<Account> Users,String Update,Update_User_Option Choice){
       boolean Exists=false;
       for(Account user:Users){
           if( user.getUsername().equals(Username)){
               Exists=true;
               switch(Choice){
                   case Username:user.setUsername(Update);
                   break;
                   case Name:user.setName(Update);
                   break;
                   case E_mail:user.setE_mail(Update);
                   break;
                   case Phone_Number:user.setPhone_Number(Update);
                   break;
                   case Address:user.setAddress(Update);
                   break;
               }
           }
       }
       if(!Exists){
           System.out.println("User Not Found");
       }
    }
    public void Remove_User(String Username,ArrayList<Account> Users){
       boolean Exists=false;
       for(Account user:Users){
           if(user.getUsername().equals(Username)){
               Exists=true;
               Users.remove(user);
               System.out.println("User Removed Successfully");
               break;
           }
       }
       if(!Exists){
           System.out.println("User Not Found");
       }
    }
    public Book Add_Book( String title, String author, int publicationYear, boolean isAvailable, double price,String Category,int Stock){
       return new Book( title, author, publicationYear, isAvailable,  price, Category,Stock);
    }
    public enum Update_Book_Option{
       BookId,BookTitle,BookAuthor,PublicationYear,KindOfBook,Availability,Price
    }
    public void Update_Book(String bookId,ArrayList<Book> Books,String Update,Update_Book_Option Choice){
        boolean Exists=false;
        for(Book book:Books){
            if( book.getBookId().equals(bookId)){
                Exists=true;
                switch(Choice){
                    case BookTitle:book.setTitle(Update);
                        break;
                    case BookAuthor:book.setAuthor(Update);
                        break;
                    case PublicationYear:book.setPublicationYear(Integer.parseInt(Update));
                        break;
                    case KindOfBook:book.setCategory(Update);
                        break;
                    case Availability:book.setAvailable(Boolean.parseBoolean(Update));
                        break;
                    case Price:book.setPrice(Float.parseFloat(Update));
                    break;
                }
            }
        }
        if(!Exists){
            System.out.println("Book Not Found");
        }
    }
    public void Remove_Book(String BookId,ArrayList<Book> Books){
        boolean Exists=false;
        for(Book book:Books){
            if(book.getBookId().equals(BookId)){
                Exists=true;
                Books.remove(book);
                System.out.println("Book Removed Successfully");
            }
        }
        if(!Exists){
            System.out.println("Book Not Found");
        }
    }
    public void Display_InventoryStatus(ArrayList<Book> Books){
       int Available_Books=0;
       int UnAvailable_Books=0;
       StringBuilder AvailableBooks=new StringBuilder();
        StringBuilder UnAvailableBooks=new StringBuilder();
        for(Book book:Books){
            if(book.isAvailable()){
                Available_Books++;
                AvailableBooks.append(book.getTitle()).append('\n');
            }
            else{
                UnAvailable_Books++;
                UnAvailableBooks.append(book.getTitle()).append('\n');
            }
        }
        System.out.println("Number Of Available Books: "+ Available_Books);
        System.out.println("Number Of UnAvailable Books: "+ UnAvailable_Books);
        if(Available_Books>0){
            System.out.println("Available Books: ");
            System.out.println(AvailableBooks.toString());
        }
        else{
            System.out.println("No Available Books");
        }
        if(UnAvailable_Books>0){
            System.out.println("UnAvailable Books: ");
            System.out.println(UnAvailableBooks.toString());
        }
        else{
            System.out.println("No UnAvailable Books");
        }

    }
}
