package exception;

public class EmailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6154748026204663400L;
	
	public EmailException() {
		this("Email không hợp lệ");
	}
	
	public EmailException(String message) {
		super(message);
	}

}
