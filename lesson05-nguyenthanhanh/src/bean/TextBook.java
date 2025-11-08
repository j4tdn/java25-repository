package bean;

public class TextBook extends Book {

	private Boolean isNew;

	public TextBook(String bookId, Double priceOfUnit, String publisher, Boolean isNew) {
		super(bookId, priceOfUnit, publisher);
		this.isNew = isNew;
	}

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	@Override
	public String toString() {
		return "TextBook [isNew=" + isNew + ", getBookId()=" + getBookId() + ", getPriceOfUnit()=" + getPriceOfUnit()
				+ ", getPublisher()=" + getPublisher() + "]";
	}
	
}
