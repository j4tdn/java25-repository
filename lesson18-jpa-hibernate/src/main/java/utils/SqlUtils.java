package utils;

import java.time.LocalDate;
import java.util.Objects;

public class SqlUtils {

	private SqlUtils() {
	}
	
	public static java.sql.Date toDate(LocalDate source) {
		Objects.requireNonNull(source, "source(date) should not be null !");
		return java.sql.Date.valueOf(source);
	}

	public static void close(AutoCloseable... closeables) {
		try {
			for (AutoCloseable closeable : closeables) {
				if (closeable != null) {
					closeable.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
