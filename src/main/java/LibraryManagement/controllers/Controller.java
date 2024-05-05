package LibraryManagement.controllers;
import LibraryManagement.models.Book;
import LibraryManagement.models.Library;
import LibraryManagement.models.LibraryItem;
import LibraryManagement.utils.SerializationUtil;
import LibraryManagement.views.View;


import LibraryManagement.models.Member;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    ArrayList<LibraryItem> libraryItems;
    Library library;

    private int currentIndex;

    public Controller() {

        library = new Library("ABC Library");

        currentIndex = -1;

        libraryItems = new ArrayList<>();
        libraryItems.add(new Book("The Lost Hero", "Rick Riordan", "Fantasy", 2024));
        libraryItems.add(new Book("The Hunger Games", "Suzanne Collins", "Science fiction", 2008));
        libraryItems.add(new Book("The Da Vinci Code", "Dan Brown", "Mystery", 2003));
        libraryItems.add(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", 1997));
        libraryItems.add(new Book("Twilight", "Stephenie Meyer", "Young adult", 2005));

        View view = new View(this);
        view.displayItem(getNextItem());
        view.setVisible(true);

    }

    public LibraryItem getNextItem() {
        if (currentIndex < libraryItems.size() - 1) {
            currentIndex++;
            return libraryItems.get(currentIndex);
        }
        return null;
    }

    public LibraryItem getPreviousItem() {
        if (currentIndex > 0) {
            currentIndex--;
            return libraryItems.get(currentIndex);
        }
        return null;
    }

    public boolean addBook(String title, String author, String genre, int publicationYear) {

        Book newBook = new Book(title, author, genre, publicationYear);
        libraryItems.add(newBook);
        currentIndex = libraryItems.size() - 1;

        return true;
    }

    public boolean updateBook(String title, String author, String genre, int publicationYear) {
        try {
            LibraryItem currentItem = libraryItems.get(currentIndex);
            if (currentItem instanceof Book) {
                Book currentBook = (Book) currentItem;
                currentBook.setTitle(title);
                currentBook.setAuthor(author);
                currentBook.setGenre(genre);
                currentBook.setPublicationYear(publicationYear);

                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }


    public boolean deleteBook(String title, String author, String genre, int publicationYear) {

        try {

            for (LibraryItem item : libraryItems) {

                if (item instanceof Book && ((Book) item).getTitle().equals(title)
                        && ((Book) item).getAuthor().equals(author)
                        && ((Book) item).getGenre().equals(genre)
                        && ((Book) item).getPublicationYear() == publicationYear) {

                    boolean removed = libraryItems.remove(item);

                    if (removed) {

                        if (hasNextListItem()) {
                            currentIndex--;
                        } else if (currentIndex > 0) {

                            currentIndex -= 2;
                        }


                    }
                    return removed;
                }
            }

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isBookListEmpty() {
        return libraryItems.isEmpty();

    }

    public boolean hasNextListItem() {
        return currentIndex < libraryItems.size();

    }
     public void saveBookData(Book book) {
        try {
            SerializationUtil.serialize(book, "book.ser");
            //SerializationUtil.serialize(member, "member.ser");
            // Optionally, update your application state or UI to indicate success
        } catch (IOException e) {
            e.printStackTrace();
            // Handle error (e.g., show error message)
        }
    }

    // Example method to load a Book from storage
    public Book loadBookData() {
        try {
            return (Book) SerializationUtil.deserialize("book.ser");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle error (e.g., show error message)
            return null;
        }
    }

    // Example method to load a Member from storage
    public Member loadMemberData() {
        try {
            return (Member) SerializationUtil.deserialize("member.ser");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle error (e.g., show error message)
            return null;
        }
    }
}
