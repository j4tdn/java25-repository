package bean;

public class CustomText {
	
	// Trong 1 class nếu thuộc tính khai báo là final thì tất cả các hàm khởi tạo phải gán giá trị
	// mạc định cho thuộc tính final đó
	
	// bắc buộc phải có khi khởi tạo đối tượng
	
	private final String text;  // reflection
	// private String reversedText;
	
//	public CustomText() {
//		this.text = "A";
//	}
	
	public CustomText(String text) {
		this.text = text;
	}
	
	// getter - hỗ trợ sử dụng giá trị của thuộc tính
	public String getText() {
		return text;
	}
	
	@Override
	public String toString() {
		return "CustomText["+ this.text + "]";
	}

}