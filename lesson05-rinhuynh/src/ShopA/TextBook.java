package ShopA;

public class TextBook extends Book {
	private Status status;

	public TextBook(String code, double price, String publisher, Status status) {
		super(code, price, publisher);
		this.status = status;
	}
	
	@Override
	public double getPrice() {
		if((status == status.OLD)) {
			return getPrice() * 0.7;
		}
		return getPrice();
		
	}

	@Override
	public String toString() {
		return "TextBook [status=" + status + ", getPrice()=" + getPrice() + "]";
	}
	

}
