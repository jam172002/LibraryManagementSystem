package LibraryManagement.models;

import java.time.LocalDate;

public class Loan {
    private Book book;
    private Member member;
    private Admin admin;
    private LocalDate loanDate;
    private LocalDate dueDate;

    public Loan(Book book, Member member, Admin admin, LocalDate loanDate, LocalDate dueDate) {
        this.book = book;
        this.member = member;
        this.admin = admin;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        String loanString = String.format(
                "Loan Details:\nBook: %s\nMember: %s\nAdmin: %s\nLoan Date: %s\nDue Date: %s",
                book, member, admin, loanDate, dueDate);

        return loanString;
    }
}