package LibraryManagement.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Member implements Serializable {
    protected String firstName;
    protected String lastName;
    protected String memberId;
    protected String emailId;
    protected List<Book> borrowedBooks;

    public Member(String firstName, String lastName, String memberId, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberId = memberId;
        this.emailId = emailId;
        this.borrowedBooks = new ArrayList<>();
    }

    public int maxBooksCanLoan() {
        return 0;
    }

    // Maximum number of days a member can borrow a book.
    public int getMaxLoanNumDays() {
        return 0;
    }

    // Member type
    public String memberType() {
        return "MEMBER";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBooks(Book book) {
        this.borrowedBooks.add(book);
    }

    @Override
    public String toString() {
        String memberString = String.format(
                "Member: first name = %s, last name = %s, member id = %s, email id = %s\nborrowed books = %s",
                firstName, lastName, memberId, emailId, borrowedBooks);

        return memberString;
    }
}

