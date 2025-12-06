package exception;

public class PasswordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8194779832109312113L;
	
	public PasswordException() {
		this("Mật khẩu không hợp lệ");
	}
	
	public PasswordException(String message) {
		super(message);
	}

}
