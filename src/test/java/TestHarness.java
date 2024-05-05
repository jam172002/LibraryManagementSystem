import LibraryManagement.models.*;

import java.util.ArrayList;

public class TestHarness {
    public TestHarness() {

        Book myBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925);

        Member member = new Member("Test", "User", "1234", "test@gmail.com");
        member.addBorrowedBooks(myBook);

        // First let's test 'member' class
        System.out.println("Test Harness");
        System.out.println("Usage: Run with assertions enabled: java -ea TestHarness");

        System.out.println("\nTesting getter functions of Member model class");
        assert member.getFirstName().equals("Test");
        assert member.getLastName().equals("User");
        assert member.getMemberId().equals("1234");
        assert member.getEmailId().equals("test@gmail.com");
        assert member.getBorrowedBooks().size() == 1;
        assert member.getBorrowedBooks().get(0).equals(myBook);
        System.out.println("OK");
        System.out.println("\nTesting setter functions of Member model class");
        member.setFirstName("firstName");
        member.setLastName("lastName");
        member.setMemberId("4321");
        member.setEmailId("random@gmail.com");
        assert member.getFirstName().equals("firstName");
        assert member.getLastName().equals("lastName");
        assert member.getMemberId().equals("4321");
        assert member.getEmailId().equals("random@gmail.com");
        System.out.println("OK");

        // Now let's test Book model class
        System.out.println("\nTesting getter functions of Book model class");
        assert myBook.getTitle().equals("The Great Gatsby");
        assert myBook.getAuthor().equals("F. Scott Fitzgerald");
        assert myBook.getGenre().equals("Fiction");
        assert myBook.getPublicationYear() == 1925;
        System.out.println("OK");

        System.out.println("\nTesting setter functions of Book model class");
        myBook.setTitle("title");
        myBook.setAuthor("Author");
        myBook.setGenre("Genre");
        myBook.setPublicationYear(1234);
        assert myBook.getTitle().equals("title");
        assert myBook.getAuthor().equals("Author");
        assert myBook.getGenre().equals("Genre");
        assert myBook.getPublicationYear() == 1234;
        System.out.println("OK");


        testClassHierarchy();
        testInterface();
    }

    public void testClassHierarchy() {

        System.out.println("\nTesting Class Hierarchy");

        ArrayList<Member> members = new ArrayList<Member>();
        members.add(new RegularMember("Test Member", "1", "1", "test1@gmail.com"));
        members.add(new PremiumMember("Test Member", "2", "2", "test2@gmail.com"));

        for (int i = 0; i < members.size(); i++) {
            System.out.println("Member Type = " + members.get(i).memberType());
            System.out.println("Member Name = " + members.get(i).getFirstName() + " " + members.get(i).getLastName());
            System.out.println("Max number of book can loan = " + members.get(i).maxBooksCanLoan());
            System.out.println("Max number of days can loan = " + members.get(i).getMaxLoanNumDays());
            System.out.println("\n");
        }

    }

    public static void testInterface() {

        ArrayList<LibraryItem> libraryItems = new ArrayList<>();

        libraryItems.add(new Book("The Lost Hero", "Rick Riordan", "Fantasy", 2024));
        libraryItems.add(new EducationalKit("Robotics Starter Kit", "Get started in the world of robotics - perfect for beginners and enthusiasts alike", "STEM"));

        System.out.println("\nTesting Interface");
        for (LibraryItem item : libraryItems) {
            System.out.println("Type: " + item.getType());
            System.out.println("Display Name: " + item.getDisplayName());
            System.out.println();
        }
    }


}

