
import LibraryManagement.models.Admin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdminTest {

    private Admin admin;


    @BeforeEach
    void setUp() throws Exception {
        admin = new Admin("admin", "1", "1234", "admin@example.com");
    }

    @AfterEach
    void tearDown() throws Exception {
        admin = null;
    }

    @Test
    void testGetFirstName() {
        assertEquals("admin", admin.getFirstName());
    }

    @Test
    void testSetFirstName() {
        admin.setFirstName("john");
        assertEquals("john", admin.getFirstName());
    }

    @Test
    void testGetLastName() {
        assertEquals("1", admin.getLastName());
    }

    @Test
    void testSetLastName() {
        admin.setLastName("doe");
        assertEquals("doe", admin.getLastName());
    }

    @Test
    void testGetAdminId() {
        assertEquals("1234", admin.getAdminId());
    }

    @Test
    void testSetAdminId() {
        admin.setAdminId("4321");
        assertEquals("4321", admin.getAdminId());
    }

    @Test
    void testGetEmailId() {
        assertEquals("admin@example.com", admin.getEmailId());
    }

    @Test
    void testSetEmailId() {
        admin.setEmailId("admin12@gmail.com");
        assertEquals("admin12@gmail.com", admin.getEmailId());
    }

}
