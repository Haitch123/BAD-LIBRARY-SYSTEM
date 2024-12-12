package Librarycatalog.classes;
import Librarycatalog.classes.Account;
import java.util.List;
import java.util.ArrayList;

public  class Customer extends Account {
    private static int totalCustomerCount = 0;
    private Cart cart;
    private List<Order> orderHistory;
    private Borrower borrower_info;

    public Customer(String accountUsername, String accountPassword, String name, String email, String phone, String address, ArrayList<Customer> Customers) {
        super(accountUsername, accountPassword, name, email, phone, address,Customers);
        this.cart = new Cart();
        borrower_info = new Borrower(name,getAccount_Id ());
        totalCustomerCount++;
    }

    public void viewAvailableBooks(List<Book> books) {
        System.out.println("Available books:");
        for (Book book : books) {
            if (book.getStock() > 0) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + " (Stock: " + book.getStock() + ")");
            }
        }
    }

    public void viewUnavailableBooks(List<Book> books) {
        System.out.println("Unavailable books:");
        for (Book book : books) {
            if (book.getStock() == 0) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + " (Out of stock)");
            }
        }
    }
    public void searchBooksByAuthor(List<Book> books, String author) {
        System.out.println("Searching for books by author: '" + author + "'");
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                System.out.println("- " + book.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by author: '" + author + "'");
        }
    }

    public void searchBooksByTitle(List<Book> books, String title) {
        System.out.println("Searching for books with title: '" + title + "'");
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("- " + book.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with title: '" + title + "'");
        }
    }

    public void placeOrder() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty. Add books to the cart before placing an order.");
            return;
        }

        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cart.getItems()) {
            OrderItem orderItem = new OrderItem(cartItem.getBook(), cartItem.getQuantity());
            orderItems.add(orderItem);
        }

        Order order = new Order(orderItems, this.getAccount_Id ());
        System.out.println("Order placed successfully.");
        orderHistory.add(order);
        cart.clearCart();
    }

    public void addToCart(Book book) {
        cart.addToCart(book);
    }

    public void removeFromCart(Book book) {
        cart.removeFromCart(book);
    }

    public void viewCart() {
        cart.displayCart();
    }

    public Borrower getBorrower_info(){
        return borrower_info;
    }

    public static int getCustomerCount() {
        return totalCustomerCount;
    }


}
