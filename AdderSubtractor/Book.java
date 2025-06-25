
import java.util.ArrayList;
import java.util.HashMap;



public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return isBorrowed; }
    public void setBorrowed(boolean borrowed) { isBorrowed = borrowed; }

    @Override
    public String toString() {
        return id + ": " + title + " by " + author + (isBorrowed ? " [Borrowed]" : " [Available]");
    }
}




public class User {
    private int id;
    private String name;
    private ArrayList<Book> borrowedBooks;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) { borrowedBooks.add(book); }
    public void returnBook(Book book) { borrowedBooks.remove(book); }
}



//////////////////////////////////////////////////////////////////////////////////////

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private HashMap<Integer, User> users = new HashMap<>();
    private int maxBooksPerUser = 3;

    public void addBook(Book book) { books.add(book); }

    public void removeBook(int bookId) throws Exception {
        Book book = findBook(bookId);
        books.remove(book);
    }

    public void viewBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void registerUser(User user) { users.put(user.getId(), user); }

    public void borrowBook(int userId, int bookId) throws Exception {
        User user = users.get(userId);
        if (user == null) throw new Exception("User not found!");
        if (user.getBorrowedBooks().size() >= maxBooksPerUser)
            throw new Exception("Max limit reached!");

        Book book = findBook(bookId);
        if (book.isBorrowed()) throw new Exception("Book already borrowed!");

        book.setBorrowed(true);
        user.borrowBook(book);
    }

    public void returnBook(int userId, int bookId) throws Exception {
        User user = users.get(userId);
        if (user == null) throw new Exception("User not found!");

        Book book = findBook(bookId);
        if (!user.getBorrowedBooks().contains(book))
            throw new Exception("This book is not borrowed by user!");

        book.setBorrowed(false);
        user.returnBook(book);
    }

    private Book findBook(int bookId) throws Exception {
        for (Book b : books) {
            if (b.getId() == bookId) return b;
        }
        throw new Exception("Book not found!");
    }
}



/////////////////////////////////////////////////////////////////////////////////////////////

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book\n2. Remove Book\n3. View Books\n4. Register User\n5. Borrow Book\n6. Return Book\n7. Exit");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID, Title, Author: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        String title = sc.nextLine();
                        String author = sc.nextLine();
                        library.addBook(new Book(id, title, author));
                        break;
                    case 2:
                        System.out.print("Enter Book ID to remove: ");
                        library.removeBook(sc.nextInt());
                        break;
                    case 3:
                        library.viewBooks();
                        break;
                    case 4:
                        System.out.print("Enter User ID and Name: ");
                        int userId = sc.nextInt();
                        sc.nextLine();
                        String name = sc.nextLine();
                        library.registerUser(new User(userId, name));
                        break;
                    case 5:
                        System.out.print("Enter User ID and Book ID to borrow: ");
                        library.borrowBook(sc.nextInt(), sc.nextInt());
                        break;
                    case 6:
                        System.out.print("Enter User ID and Book ID to return: ");
                        library.returnBook(sc.nextInt(), sc.nextInt());
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}