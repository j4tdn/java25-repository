package bean;

public class CustomText {

	// Trong class, nếu thuộc tính là final thì tất cả các hàm khởi tạo phải gán giá trị
	//	mặc định cho thuộc tính đó
	
	// bắt buộc phải có khi khởi tạo đối tượng
	
	private final String text;
	private String reversedText;
	
//	public CustomText() {
//		
//	}
	
	public CustomText(String text) {
		this.text = text;
	}
	
	// getter - hỗ trợ sử dụng giá trị của thuộc tính
	public String getText() {
		return this.text;
	}
	
	@Override
	public String toString() {
		return "CustomText[" + this.text + "]";
	}
	
}
