package connection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbConfigProvider {
	
	private DbConfigProvider() {
	}
	
	public static Properties getProps() {
		Properties props = new Properties();
		InputStream inputStream = ClassLoader.getSystemResourceAsStream("db-config.properties");
		try {
			props.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
}
