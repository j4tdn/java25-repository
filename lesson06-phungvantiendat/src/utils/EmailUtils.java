package utils;

public class EmailUtils {
	private static final String EMAIL_PREFIX_REGEX =
	        "^[A-Za-z0-9]+(?:[._-][A-Za-z0-9]+)*$";

	private static boolean isValidEmailPrefixRegex(String prefix) {
	    return prefix.matches(EMAIL_PREFIX_REGEX);
	}
	
	public static boolean isValidEmailPrefix(String prefix) {
	    if (prefix == null || prefix.isEmpty()) {
	    	throw new RuntimeException(  "Tiền tố email không hợp lệ. Chỉ được dùng chữ cái (a-z), chữ số (0-9), dấu gạch dưới (_), dấu chấm (.) và dấu gạch ngang (-). " +
	    		    "Các ký tự _, . hoặc - phải đứng trước ít nhất một chữ cái hoặc chữ số và không được nằm ở cuối.");
	    }
	    
	    if(!isValidEmailPrefixRegex(prefix)) {
	    	throw new RuntimeException("Tiền tố email không hợp lệ. Chỉ được dùng chữ cái (a-z), chữ số (0-9), dấu gạch dưới (_), dấu chấm (.) và dấu gạch ngang (-). " +
	    		    "Các ký tự _, . hoặc - phải đứng trước ít nhất một chữ cái hoặc chữ số và không được nằm ở cuối.");
	    }
	    return true;
	}
	
	public static String getPrefixEmail(String email) {
		return email.split("\\@")[0];
	}
}
