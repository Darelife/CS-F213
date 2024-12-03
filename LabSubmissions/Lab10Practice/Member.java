import java.util.*;

public class Member {
    private String ID;
    private String name;
    private LinkedList<Book> borrowingHistory = new LinkedList<>();

    public Member(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    // public boolean addBorrowedBook(Book book) {
    // if (book.isAvailable()) {
    // book.setAvailable(false);
    // borrowingHistory.addLast(book);
    // return true;
    // } else {
    // return false;
    // }
    // }
    public boolean addBorrowedBook(Book book) {
        // Simply add the book to history - availability is managed by Library class
        borrowingHistory.addLast(book);
        return true;
    }

    public LinkedList<Book> displayBorrowingHistory() {
        return borrowingHistory;
    }

    public String getId() {
        return ID;
    }

    public String getName() {
        return name;
    }

}