package exception;

public class InvalidAgeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8639637553249410321L;
	
	public InvalidAgeException() {
		this("Invalid age");
	}
	
	public InvalidAgeException(String message) {
		super(message);
	}

}
