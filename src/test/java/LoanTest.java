import LibraryManagement.models.Admin;
import LibraryManagement.models.Book;
import LibraryManagement.models.Loan;
import LibraryManagement.models.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanTest {

    private Loan loan;
    private Book book;
    private Member member;
    private Admin admin;

    @BeforeEach
    void setUp() throws Exception {
        book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925);
        member = new Member("Test", "User", "1234", "test@gmail.com");
        admin = new Admin("admin", "1", "1234", "admin@example.com");
        loan = new Loan(book, member, admin, LocalDate.of(2024, 1, 15), LocalDate.of(2024, 1, 20));
    }

    @AfterEach
    void tearDown() throws Exception {
        book = null;
        member = null;
        admin = null;
        loan = null;
    }

    @Test
    void testGetBook() {
        assertEquals(book, loan.getBook());
    }

    @Test
    void testSetBook() {
        Book tmp = new Book("Random", "sdfs", "sfsf", 2000);
        loan.setBook(tmp);
        assertEquals(tmp, loan.getBook());
    }

    @Test
    void testGetMember() {
        assertEquals(member, loan.getMember());
    }

    @Test
    void testSetMember() {
        Member tmp = new Member("dasd", "dsad", "asdda", "asdasd@gmail.com");
        loan.setMember(tmp);
        assertEquals(tmp, loan.getMember());
    }

    @Test
    void testGetAdmin() {
        assertEquals(admin, loan.getAdmin());
    }

    @Test
    void testSetAdmin() {
        Admin tmp = new Admin("saddada", "sdasd", "sdfsf", "sfdsfs");
        loan.setAdmin(tmp);
        assertEquals(tmp, loan.getAdmin());
    }

    @Test
    void testGetLoanDate() {
        assertEquals(LocalDate.of(2024, 1, 15), loan.getLoanDate());
    }

    @Test
    void testSetLoanDate() {
        LocalDate tmp = LocalDate.of(2023, 1, 20);
        loan.setLoanDate(tmp);
        assertEquals(tmp, loan.getLoanDate());
    }

    @Test
    void testGetDueDate() {
        LocalDate tmp = LocalDate.of(2024, 1, 20);
        assertEquals(tmp, loan.getDueDate());
    }

    @Test
    void testSetDueDate() {
        LocalDate tmp = LocalDate.of(2023, 5, 25);
        loan.setDueDate(tmp);
        assertEquals(tmp, loan.getDueDate());
    }
}
