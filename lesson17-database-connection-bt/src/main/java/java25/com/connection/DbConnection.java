package java25.com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
    private static Connection connection;

    // Ket noi rieng cho moi thao tac moi; dong bang try-with-resources.
    public static Connection openConnection() throws SQLException {
        Properties props = DbConfigProvider.getProps();
        return DriverManager.getConnection(props.getProperty("url"),
                props.getProperty("user"), props.getProperty("pass"));
    }

    // Giu tuong thich voi cac bai cu. Khong tra ve null khi ket noi that bai.
    public static synchronized Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) connection = openConnection();
            return connection;
        } catch (SQLException e) {
            throw new IllegalStateException("Khong ket noi duoc MySQL. Kiem tra db-config.properties.", e);
        }
    }
}
