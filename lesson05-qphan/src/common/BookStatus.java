package common;

public enum BookStatus {
	
	// BookStatus NEW = new BookStatus("mới");
	// BookStatus OLD = new BookStatus("cũ");
	
	NEW("mới"), OLD("cũ");
	
	private String message;
	
	private BookStatus(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
