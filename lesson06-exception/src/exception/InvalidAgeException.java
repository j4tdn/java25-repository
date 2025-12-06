package exception;

public class InvalidAgeException extends RuntimeException{
	private static final long serialVersionUID = -9216689430917781803L;

	public InvalidAgeException() {
		super("Tuổi không hợp lệ");
	}
	
	
	public InvalidAgeException(String message) {
		super(message);
	}
}
