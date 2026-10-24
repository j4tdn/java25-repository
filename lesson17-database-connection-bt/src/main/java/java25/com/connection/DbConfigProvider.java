package java25.com.connection;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class DbConfigProvider {
    private DbConfigProvider() { }

    public static Properties getProps() {
        Properties props = new Properties();
        try (InputStream input = DbConfigProvider.class.getResourceAsStream("/db-config.properties")) {
            if (input == null) throw new IllegalStateException("Khong tim thay db-config.properties");
            props.load(input);
            return props;
        } catch (IOException e) {
            throw new IllegalStateException("Khong doc duoc cau hinh database", e);
        }
    }
}
