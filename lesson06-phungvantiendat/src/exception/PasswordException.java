package exception;

import java.util.List;

public class PasswordException extends RuntimeException{
	private List<String> messages;
	
	public PasswordException() {
		super("Mật khẩu phải chứa ít nhất 8 kí tự và không vượt quá 256 kí tự bao gồm ít nhất 1 kí tự thường, 1 kí tự in hoa, 1 kí tự số và 1 kí tự đặc biệt ((~!@#$%^&*()_-=+[]{};:,.<>/?)) ");
	}
	
	public PasswordException(String message) {
		super(message);
	}
	
	public PasswordException(List<String> messages) {
		super("Mật khẩu phải chứa ít nhất 8 kí tự và không vượt quá 256 kí tự bao gồm ít nhất 1 kí tự thường, 1 kí tự in hoa, 1 kí tự số và 1 kí tự đặc biệt ((~!@#$%^&*()_-=+[]{};:,.<>/?)) ");
		this.messages = messages;
	}
	
	public List<String> getMessages(){
		return messages;
	}
	
}
