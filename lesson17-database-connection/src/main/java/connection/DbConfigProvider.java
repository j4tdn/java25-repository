package connection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbConfigProvider {

    private DbConfigProvider() {
    }

    public static Properties getProps() {
        Properties props = new Properties();

        try (InputStream inputStream =
                     ClassLoader.getSystemResourceAsStream("db-config.properties")) {

            if (inputStream == null) {
                throw new IllegalStateException(
                        "Khong tim thay file db-config.properties trong src/main/resources");
            }

            props.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return props;
    }
}
