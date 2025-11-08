package lesson05.exam.bean;

public class TextBook extends Book{
	private Status status;
	
	

	public TextBook(long bookId, int price, String publish, Status status) {
		super(bookId, price, publish);
		this.status = status;
	}
	
	
	public boolean isPriceOfBookFrom100To200() {
		return price >= 100 && price <= 200;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	@Override
	public double getTotalPrice() {
		if(status == status.OLD) {
			return price - 0.3 * price;
		}
		return price;
	}


	@Override
	public String toString() {
		return "TextBook [status=" + status + ", bookId=" + bookId + ", price=" + price + ", publish=" + publish + "]";
	}
	
	
	
}
