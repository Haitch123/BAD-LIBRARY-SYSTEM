package Librarycatalog.classes;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Transaction {
    int transactionID;
    private ArrayList<Book> BookList;
    private Borrower borrower;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private String TransactionStatus ;
    private double fine = 0; // Late return fees
    private double finePerDay = 10; // Late fee per day By default it's 10

    public Transaction(){

    }

    public Transaction(Borrower borrower, LocalDate borrowDate, LocalDate returnDate, int transactionID){
        //this.book = book;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.transactionID = transactionID;
    }

    public double remainingDays(LocalDate currentDate){ // to check how many remaining days until return date
        return ChronoUnit.DAYS.between(returnDate, currentDate);
    }
    public double calculateFine(){ // finePerDay can be determined by admin
        LocalDate currentDate = LocalDate.now();
        if(currentDate.isAfter(this.returnDate)){
            double days = remainingDays(currentDate);
            fine = finePerDay * days;
        }
        else
            fine = 0;
        return fine;
    }

    public double getFine() {
        calculateFine();
        return fine;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public ArrayList<Book> getBookList() {
        return BookList;
    }

    public String GetTransactionStatus() {
        return TransactionStatus;
    }


//    public void setBook(Book book) {
//        this.BookList = book;
//    }

    public Borrower getBorrower() {
        return borrower;
    }
    public void SetTransactionStatus (String TransactionStatus){
        this.TransactionStatus = TransactionStatus ;
        //Still Valid
        // Overdue
        // Returned
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double getFinePerDay() {
        return finePerDay;
    }

    public void setFinePerDay(double finePerDay) { //
        this.finePerDay = finePerDay;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionID /*+ " Book: " + book.getBookId()*/ + " Borrower: " + borrower.GetBorrowerName() + " Borrow date: " +
                borrowDate + " Return Date: " + returnDate + " Fine: " + fine;
    }

}
