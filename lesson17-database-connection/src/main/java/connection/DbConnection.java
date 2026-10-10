package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	
	private static Connection connection;
	
	public static Connection getConnection() {
		if (connection == null) {
			Properties props = DbConfigProvider.getProps();
			try {
				connection = DriverManager.getConnection(
					props.getProperty("url"), 
					props.getProperty("user"), 
					props.getProperty("pass")
				);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
}