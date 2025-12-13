package exception;

import java.util.List;

public class InValidInputException extends RuntimeException{
	private List<String> messages;
	
	public InValidInputException(List<String> messages) {
		this.messages = messages;
	}

	public List<String> getMessages() {
		return messages;
	}

	
}
