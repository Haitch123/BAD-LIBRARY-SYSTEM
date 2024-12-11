import Librarycatalog.classes.Account;
import Librarycatalog.classes.Administrator;
import Librarycatalog.classes.Book;
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
        ArrayList<Account>Users=new ArrayList<>();
        ArrayList<Administrator> Admins=new ArrayList<>();
        ArrayList<Book>Books=new ArrayList<>();
        Administrator Admin1=new Administrator("Haitch","7112005aA@","Ahmed","@","012","5_Street",Users);
        Admins.add(Admin1);
        Account User1=new Administrator("ahmed2","Hesh5188881@","Hesham","111","1","1",Users);
        Users.add(User1);
        Scanner Input=new Scanner(System.in);
        System.out.println("1-Log In"+'\t'+"2-Register");
        int Choice=Input.nextInt();
        Input.nextLine();
        if(Choice==1) {
            do {
                for (Administrator admin : Admins) {
                    System.out.println("Enter Username:");
                    String username = Input.nextLine();
                    System.out.println("Enter Password:");
                    String password = Input.nextLine();
                    if (!admin.LoggIn(username, password)) {
                        System.out.println("Try again?" + '\n' + "1-YES" + '\t' + "2-NO");
                        Choice = Input.nextInt();
                        Input.nextLine();
                    } else {
                        do {
                            System.out.println("Dashboard");
                        System.out.println("1-Add User" + '\t' + "2-Update User" + '\t' + "3-Remove User" + '\n'
                                + "4-Add Book" + '\t' + "5-Update Book" + '\t' + "6-Remove Book");
                        int Choice2 = Input.nextInt();
                        Input.nextLine();
                            switch (Choice2) {
                                case 1: {
                                    try {
                                        System.out.println("Enter User Details" + '\n' + "Username:");
                                        String NewUsername = Input.nextLine();
                                        System.out.println("Password:");
                                        String NewPassword = Input.nextLine();
                                        System.out.println("Name:");
                                        String NewName = Input.nextLine();
                                        System.out.println("E-mail:");
                                        String NewE_mail = Input.nextLine();
                                        System.out.println("Phone Number:");
                                        String NewPhoneNumber = Input.nextLine();
                                        System.out.println("Address:");
                                        String NewAddress = Input.nextLine();
                                        if (!Account.Check_Username_Exists(NewUsername, Users)) {
                                            Users.add(admin.Add_User(NewUsername, NewPassword, NewName, NewE_mail, NewPhoneNumber, NewAddress, Users));
                                            System.out.println("User Added Successfully");
                                        }
                                    } catch(PasswordException e){
                                        System.out.println(e.getMessage());
                                    }

                                        break;
                                }
                                case 2:{
                                    System.out.println("Enter Username OF User You Want TO Update Details" + '\n' + "Username:");
                                    String Username=Input.nextLine();
                                    System.out.println("What Do You Want To Update"+'\n'+"1-Username"+'\t'+"2-Name"+'\t'+"3-E-mail"+
                                            '\n'+"4-Phone Number"+'\t'+"5-Address");
                                    Choice=Input.nextInt();
                                    Input.nextLine();
                                    switch (Choice){
                                        case 1:{
                                            System.out.println("New Username: ");
                                            String NewUsername=Input.nextLine();
                                            admin.Update_User(Username,Users,NewUsername, Administrator.Update_User_Option.Username);
                                            break;
                                        }
                                    }
                                }
                                case 3:{
                                    System.out.println("Enter Username To Remove User: ");
                                    String Username=Input.nextLine();
                                    admin.Remove_User(Username,Users);
                                    break;
                                }
                                case 4:{
                                    System.out.println("Enter Book Details" + '\n' + "Book ID:");
                                    String NewBookId = Input.nextLine();
                                    System.out.println("Title:");
                                    String NewBookTitle = Input.nextLine();
                                    System.out.println("Author:");
                                    String NewBookAuthor = Input.nextLine();
                                    System.out.println("Publication Year:");
                                    String NewBookPublicationYear = Input.nextLine();
                                    System.out.println("Kind OF Book:");
                                    String NewBookKindOFBook = Input.nextLine();
                                    System.out.println("Available:");
                                    String NewBookAvailable = Input.nextLine();
                                    System.out.println("Price:");
                                    String NewBookPrice = Input.nextLine();
                                    Books.add(admin.Add_Book(NewBookId,NewBookTitle,NewBookAuthor,Integer.parseInt(NewBookPublicationYear),NewBookKindOFBook,Boolean.parseBoolean(NewBookAvailable),Float.parseFloat(NewBookPrice)));
                                    System.out.println("Book Added Successfully");

                                    break;
                                }
                                case 6:{
                                    System.out.println("Enter Book ID To Remove Book: ");
                                    String BookId=Input.nextLine();
                                    admin.Remove_Book(BookId,Books);
                                    break;
                                }
                            }
                            System.out.println("Another Operation:" + '\n' + "1-YES" + '\t' + "2-NO");
                            Choice = Input.nextInt();
                            Input.nextLine();
                        }while(Choice==1);
                    }
                }
            } while (Choice == 1);
        }






        /*ArrayList<Account> Accounts=new ArrayList<>();
        ArrayList<Book> Books=new ArrayList<>();
        //ReadingData(Accounts);
        Administrator User1=new Administrator("ahmed1","Hesh5100001!","Ahmed","111","1","1",Accounts);
        Administrator User2=new Administrator("ahmed2","Hesh5188881@","Hesham","111","1","1",Accounts);
        Administrator User3=new Administrator("ahmed3","Hesh5154441@","Mohamed","111","1","1",Accounts);
        Administrator User4=new Administrator("ahmed4","Hesh516712@","Zaki","111","1","1",Accounts);
        Accounts.add(User1);
        Accounts.add(User2);
        Accounts.add(User3);
        Accounts.add(User4);
        Accounts.get(0).LoggIn("ahmed1","Hesh5100001!");
        Accounts.get(0).Display_Details();
        System.out.println(Account.getNomOfUsers());
        try{
        Accounts.add(User1.Add_User("ahmed4","Hesh516712@","Zaki","111","1","1",Accounts));
        Accounts.get(4).LoggIn("ahmed4","Hesh516712@");
        Accounts.get(4).Display_Details();
        }catch (PasswordException e){
            System.out.println(e.getMessage());
        }
        try {
            User1.Update_User("ahmed4", Accounts, "HITCH", Administrator.Update_User_Option.Name);
            Accounts.get(4).Display_Details();
        }catch(PasswordException e){
            System.out.println(e.getMessage());
        }
        Books.add(User1.Add_Book("01","The Great Gatspy","Ahmed",2024,"Sci fi",true,24F));
        Books.add(User1.Add_Book("02","Fuck","Ahmed",2024,"Sci fi",false,24F));
        Books.get(0).displayBookInfo();
    User1.Update_Book("01",Books,"50", Administrator.Update_Book_Option.Price);
        Books.get(0).displayBookInfo();
        User1.Remove_User("ahm",Accounts);
        Accounts.get(4).Display_Details();


        User1.Display_InventoryStatus(Books);*/

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
        //WritingData(Accounts);


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