package LibraryManagement.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Library {
    private String libraryName;
    private final List<Book> books;
    private final List<Member> members;
    private final List<Admin> admins;
    private final List<Loan> loans;

    private LinkedList<LibraryItem> libraryItemsList;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.admins = new ArrayList<>();
        this.loans = new ArrayList<>();
        libraryItemsList = new LinkedList<>();
        buildTestData();
        printLibraryItems();
    }

    public String getLibraryName() {
        return this.libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public void removeAdmin(Admin admin) {
        admins.remove(admin);
    }

    public void issueLoan(Loan loan) {
        loans.add(loan);
    }

    public void returnLoan(Loan loan) {
        loans.remove(loan);
    }

    @Override
    public String toString() {
        String libraryString = String.format("Library\nbooks = %s\nmembers=%s\nadmin=%s\nloans=%s\n", books, members,
                admins, loans);
        return libraryString;
    }

    public void addItem(LibraryItem newItem) {
        libraryItemsList.add(newItem);
        libraryItemsList.sort((item1, item2) -> item1.getDisplayName().compareToIgnoreCase(item2.getDisplayName()));
    }

    public void removeItem(LibraryItem itemToRemove) {
        libraryItemsList.remove(itemToRemove);
    }

    public LibraryItem getItem(String searchTerm) {
        for (LibraryItem item : libraryItemsList) {
            if (item.getDisplayName().equalsIgnoreCase(searchTerm)) {
                return item;
            }
        }
        return null;
    }

    public void printLibraryItems() {
        System.out.println("\nItems in the libraryItemsList linked list");
        for (LibraryItem item : libraryItemsList) {
            System.out.println(item);
        }
    }

    private void buildTestData() {

        libraryItemsList.add(new Book("Book 3", "Author 3", "Genre 3", 2020));
        libraryItemsList.add(new EducationalKit("Kit 4", "Description 4", "Category 4"));
        libraryItemsList.add(new Book("Book 2", "Author 2", "Genre 2", 2021));
        libraryItemsList.add(new EducationalKit("Kit 2", "Description 2", "Category 2"));

        // Ensure the list is sorted
        libraryItemsList.sort((item1, item2) -> item1.getDisplayName().compareToIgnoreCase(item2.getDisplayName()));
    }
}
