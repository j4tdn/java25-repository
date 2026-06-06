package utils;

public class LogUtils {
	
	private LogUtils() {
	}
	
	public static void log(String message, Object ...arguments) {
		System.out.printf(message + "\n", arguments);
	}
	
}
