package dao;

// Internal DAO row; never print or return the stored password hash to the View.
public record CustomerCredentialRow(long id, String email, String passwordHash) {
}
