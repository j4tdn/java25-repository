package connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static String url;
	private static String user;
	private static String pass;

	static {
		Properties p = new Properties();
		try (InputStream in = DBConnection.class.getClassLoader().getResourceAsStream("db-config.properties")) {
			if (in == null) {
				throw new RuntimeException("Khong tim thay db-config.properties");
			}
			p.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		url = p.getProperty("url");
		user = p.getProperty("user");
		pass = p.getProperty("pass");
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}
}