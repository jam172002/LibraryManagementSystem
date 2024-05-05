package LibraryManagement.models;

public class Admin {
    private String firstName;
    private String lastName;
    private String adminId;
    private String emailId;

    public Admin(String firstName, String lastName, String adminId, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adminId = adminId;
        this.emailId = emailId;
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

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        String adminString = String.format(
                "Admin: first name = %s, last name = %s, admin id = %s, email id = %s", firstName, lastName, adminId,
                emailId);

        return adminString;
    }
}
