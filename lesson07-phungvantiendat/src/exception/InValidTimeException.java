package exception;

public class InValidTimeException extends RuntimeException{
	
	public InValidTimeException() {
		super("Ngày bắt đầu hẹn hò phải <= ngày kết thúc.");
	}
	
	public InValidTimeException(String message) {
		super(message);
	}
}
