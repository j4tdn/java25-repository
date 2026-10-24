package java25.com.utils;

import java.time.LocalDate;
import java.util.Objects;

public class SqlUtils {
    private SqlUtils() {

    }

    public static java.sql.Date toDate(LocalDate source) {
        Objects.requireNonNull(source, "source(date) should not be null !");
        return java.sql.Date.valueOf(source);
    }

    public static void close(AutoCloseable ...closeables) {
        for(AutoCloseable closeable : closeables) {
            if(closeable != null) {
                try {
                    closeable.close();
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
