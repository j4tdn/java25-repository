package lesson3.assignments;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Locale;

public class InputUtils {
	public static String normalize(String s) {
		String lower = s.toLowerCase(Locale.ROOT);
		
		String normalizedString = Normalizer.normalize(lower, Form.NFD);
		
		normalizedString = normalizedString.replaceAll("\\p{M}", "");
		
		return normalizedString.trim();
	}
}
