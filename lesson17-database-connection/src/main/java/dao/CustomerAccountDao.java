package dao;

import java.sql.SQLException;

public interface CustomerAccountDao {
    long create(String email, String passwordHash) throws SQLException;

    CustomerCredentialRow findByEmail(String email) throws SQLException;
}
