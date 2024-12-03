public class Book {
    private String ISBN;
    private String title;
    private String author;
    private boolean availabilityStatus;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.availabilityStatus = true;
    }

    public boolean isAvailable() {
        return availabilityStatus;
    }

    public void setAvailable(boolean val) {
        this.availabilityStatus = val;
    }

    public String toString() {
        return (title + " by " + author);
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }
}