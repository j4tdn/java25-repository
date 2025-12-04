package exception;

public class InvalidAgeException extends RuntimeException{

	private static final long serialVersionUID = -8639637553249410321L;
	
	public InvalidAgeException() {
		super("Age is invalid");
	}
	
	public InvalidAgeException(String message) {
		super(message);
	}
}
