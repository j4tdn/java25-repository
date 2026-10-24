package java25.com.persistence;

public class CustomerAccount {
    private final long id;
    private final String fullName;
    private final String email;

    public CustomerAccount(long id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }
    public long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "CustomerAccount{id=" + id + ", fullName='" + fullName + "', email='" + email + "'}";
    }
}
