package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

    private static Connection connection;

    private DbConnection() {
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Properties props = DbConfigProvider.getProps();

                connection = DriverManager.getConnection(
                        props.getProperty("url"),
                        props.getProperty("user"),
                        props.getProperty("pass")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
