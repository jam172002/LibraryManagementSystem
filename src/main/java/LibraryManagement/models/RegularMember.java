package LibraryManagement.models;

public class RegularMember extends Member {

    public RegularMember(String firstName, String lastName, String memberId, String emailId) {
        super(firstName, lastName, memberId, emailId);
    }

    @Override
    public String toString() {
        String memberString = String.format(
                "REGULAR Member: first name = %s, last name = %s, member id = %s, email id = %s\nborrowed books = %s",
                firstName, lastName, memberId, emailId, borrowedBooks);

        return memberString;
    }

    @Override
    public int maxBooksCanLoan() {
        return 5;
    }

    // Maximum number of days a member can borrow a book.
    @Override
    public int getMaxLoanNumDays() {
        return 14;
    }

    @Override
    // Member type
    public String memberType() {
        return "REGULAR";
    }

}

