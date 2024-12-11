package Librarycatalog.classes;
import java.util.ArrayList;
public class Book {
    private String bookId;
    private String title;
    private String author;
    private int publicationYear;
    private String kindOfBook;
    private boolean isAvailable;
    private double price;

    public Book(String bookId, String title, String author, int publicationYear, String kindOfBook, boolean isAvailable, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.kindOfBook = kindOfBook;
        this.isAvailable = isAvailable;
        this.price = price;
    }
    public String getBookId() {
        return bookId;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getKindOfBook() {
        return kindOfBook;
    }

    public void setKindOfBook(String kindOfBook) {
        this.kindOfBook = kindOfBook;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Method to display book details
    public void displayBookInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Kind of Book: " + kindOfBook);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("Price: $" + price);
        System.out.println("-----------------------------");
    }
}