package LibraryManagement.models;
import java.io.Serializable;
public class Book implements LibraryItem,Serializable {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;

    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    // Accessors functions


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    // Mutators functions
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        String bookString = String.format("Book: title = %s, author = %s, genre = %s, year = %d", title, author, genre,
                publicationYear);
        return bookString;
    }

    @Override
    public String getDisplayName() {
        return title + " by " + author;
    }

    @Override
    public String getType() {
        return "Book";
    }


}
