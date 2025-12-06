package exception;

public class NumberValidException extends RuntimeException{

	public NumberValidException() {
		super("Vui lòng nhập số hợp lệ");
	}
	
	public NumberValidException(String message) {
		super(message);
	}
}
