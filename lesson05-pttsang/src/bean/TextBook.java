package bean;

public class TextBook extends Book {
	private String status;

	public TextBook() {

	}

	public TextBook(String idBook, Double price, String nxb, String status) {
		super(idBook, price, nxb);
		this.setStatus(status);

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
