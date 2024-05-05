package LibraryManagement.models;

public class PremiumMember extends Member {

    public PremiumMember(String firstName, String lastName, String memberId, String emailId) {
        super(firstName, lastName, memberId, emailId);
    }

    @Override
    public String toString() {
        String memberString = String.format(
                "PREMIUM Member: first name = %s, last name = %s, member id = %s, email id = %s\nborrowed books = %s",
                firstName, lastName, memberId, emailId, borrowedBooks);

        return memberString;
    }


    @Override
    public int maxBooksCanLoan() {
        return 15;
    }

    // Maximum number of days a member can borrow a book.
    @Override
    public int getMaxLoanNumDays() {
        return 30;
    }

    @Override
    // Member type
    public String memberType() {
        return "PREMIUM";
    }
}

