package assigment;

public class EmailUtils {
	public static boolean isValidEmail(String email) {
		if (!email.contains("@"))
			return false;

		String[] parts = email.split("@");
		if (parts.length != 2)
			return false;

		String prefix = parts[0];
		String domain = parts[1];

		String prefixRegex = "^[A-Za-z0-9]+([._-]?[A-Za-z0-9]+)*$";

		boolean validDomain = domain.matches("^[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

		return prefix.matches(prefixRegex) && validDomain;
	}
}
