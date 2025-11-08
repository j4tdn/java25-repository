package bean;

public class TextBook extends Book {
	// tình trạng: status
	private int status;

	
	public TextBook() {
		
	}

	public TextBook(int id, double price, String publisher) {
		super(id, price, publisher);
		// TODO Auto-generated constructor stub
	}

	public TextBook(int status) {
		super();
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TextBook [status=" + status + ", getStatus()=" + getStatus() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
