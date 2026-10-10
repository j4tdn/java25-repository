package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java25_shopping",
                    "root",
                    "Huyphamcs@05"
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}