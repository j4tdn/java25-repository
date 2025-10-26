package inheritance.cclass;

import java.math.BigDecimal;

// super: đại diện cho đối tượng cha, chỉ có thể gọi các hàm, tt cho phép từ cha
// 		: gọi đến 

public class TextBook extends Book {
		
	private Status status;
	private BigDecimal discountInPercent;
	public TextBook() {
		
	}
	public TextBook(String id, String name, BigDecimal salesPrice, Status status, BigDecimal discountInpercent) {
		super(id,name,salesPrice);
		this.status = status;
		
		this.discountInPercent = discountInpercent;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public BigDecimal getDiscountInPercent() {
		return discountInPercent;
	}
	public void setDiscountInpercent(BigDecimal discountInpercent) {
		this.discountInPercent = discountInpercent;
	}
	
	
	@Override
	public boolean isMatchedForsales() {
		return getStatus() == Status.OLD  && getDiscountInPercent().doubleValue() >2d; 
	}
	@Override
	public String toString() {
		return "TextBook [id()= "  + getId() + ", getName()=" + getName() + ", salesPrice()= "+ getSalesPrice()+
				"status="+status+",discountInPercent="+discountInPercent+ "]";
	}
	
	
	
	
	
}
