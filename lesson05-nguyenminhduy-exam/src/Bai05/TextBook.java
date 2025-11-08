package Bai05;

public class TextBook extends Book {
	
	private boolean isNew;
	
	public TextBook() {
	}

	public TextBook(String id, String publisher, double price, boolean isNew) {
		super(id, publisher, price);
		this.isNew = isNew;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	
	@Override
	public double Total() {
		if(isNew) {
			return price;
		}else {
			return price * 0.7;
		}
	}

	@Override
	public String toString() {
		return "TextBook [isNew=" + isNew + ", id=" + id + ", publisher=" + publisher + ", price=" + price
				+ ", isNew()=" + isNew() + "]";
	}

	
	
	
	
	

}
