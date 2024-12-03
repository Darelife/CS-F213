import java.util.*;

public class Library {
    Map<String, Book> bookCatalog = new HashMap<>();
    Map<String, Member> members = new HashMap<>();
    Map<String, Queue<String>> reservationQueues = new HashMap<>();

    public boolean addBook(String ISBN, String title, String author) {
        Book book = new Book(ISBN, title, author);
        if (bookCatalog.get(ISBN) == null) {
            bookCatalog.put(ISBN, book);
            System.out.println(blueString("Book added: " + title + " by " + author));
            return true;
        } else {
            System.out.println(blueString("Book already exists"));
            return false;
        }
    }

    public boolean registerMember(String ID, String name) {
        Member member = new Member(ID, name);
        if (members.get(ID) == null) {
            members.put(ID, member);
            System.out.println(blueString("Member registered: " + name + " with ID: " + ID));
            return true;
        } else
            return false;
    }

    public boolean borrowBook(String ISBN, String ID) {
        if (bookCatalog.get(ISBN) == null) {
            System.out.println(blueString("The Book does not exist"));
            return false;
        } else if (members.get(ID) == null) {
            System.out.println(blueString("The member does not exist"));
            return false;
        }
        Book book = bookCatalog.get(ISBN);
        Member member = members.get(ID);
        // if (!bookCatalog.get(ISBN).isAvailable()) {
        // Queue<Integer> q = new Queue<>();
        // if (reservationQueues.get(ISBN) == null)
        // reservationQueues.put(ISBN, q);
        // else
        // q = reservationQueues.get(ISBN);
        // }
        if (!book.isAvailable()) {
            if (reservationQueues.get(ISBN) == null) {
                reservationQueues.put(ISBN, new LinkedList<>());
            }
            Queue<String> q = reservationQueues.get(ISBN);
            q.add(ID);
            reservationQueues.put(ISBN, q);
            System.out.println(blueString("Book not available. Added to reservation queue."));
            return false;
        } else {
            book.setAvailable(false);
            member.addBorrowedBook(book);
            members.put(ID, member);
            bookCatalog.put(ISBN, book);
            System.out.println(blueString(member.getName() + " has borrowed: " + book.getTitle()));
            return true;
        }
    }

    public void returnBook(String ISBN, String ID) {
        if (bookCatalog.get(ISBN) == null) {
            System.out.println(blueString("The Book does not exist"));
            return;
        } else if (members.get(ID) == null) {
            System.out.println(blueString("The member does not exist"));
            return;
        }
        Book book = bookCatalog.get(ISBN);
        Member member = members.get(ID);
        System.out.println(blueString(book.getTitle() + " has been returned by " + member.getName()));
        // check the reservation queue
        Queue<String> q = reservationQueues.get(ISBN);
        if (q == null || q.isEmpty()) {
            book.setAvailable(true);
            bookCatalog.put(ISBN, book);
        } else {
            String nextID = q.poll();
            Member member2 = members.get(nextID);
            member2.addBorrowedBook(book);
            members.put(nextID, member2);
            reservationQueues.put(ISBN, q);
        }
    }

    public void displayBookCatalog() {
        System.out.println(blueString("Library Catalog:"));
        for (Map.Entry<String, Book> entry : bookCatalog.entrySet()) {
            System.out.println(blueString(entry.getKey() + ": " + entry.getValue() + " - "
                    + (entry.getValue().isAvailable() ? "available" : "borrowed")));
        }
    }

    public void displayMemberHistory(String ID) {
        Member member = members.get(ID);
        System.out.println(blueString("Borrowing history for " + member.getName() + ":"));
        LinkedList<Book> borrowingHistory = member.displayBorrowingHistory();
        for (Book book : borrowingHistory) {
            System.out.println(blueString("- " + book));
        }
        if (borrowingHistory.isEmpty()) {
            System.out.println(blueString("No books borrowed yet."));
        }
    }

    public String blueString(String str) {
        return "\033[34m" + str + "\033[0m";
    }
}