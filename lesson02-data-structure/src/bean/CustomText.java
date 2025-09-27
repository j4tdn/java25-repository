package bean;

public class CustomText {
	
	// Trong class, nếu thuộc tính khai báo là final thì tất cả các hàm khởi tạo phải gán giá trị
	// mặc định cho thuộc tính final đó
	
	// bắt buộc phải có khi khởi tạo đối tượng
	
	private final String text; // reflection ct1.text = "" sout(ct1.text)
	// private String reversedText;
	
//	public CustomText() {
//		this.text = null;
//	}
	
	public CustomText(String text) {
		this.text = text;
	}
	
	// CustomText ct1 = new CustomText();
	// ct1.text = "x";
	
	// CustomText ct2 = new CustomText("hello");
	
	// getter - hỗ trợ sử dụng giá trị của thuộc tính
	public String getText() {
		return text;
	}
	
	// ct1.toString() --> this là ct1
	// ct2.toString() --> this là ct2
	
	@Override
	public String toString() {
		return "CustomText[" + this.text + "]";
	}
	
	
	
}
