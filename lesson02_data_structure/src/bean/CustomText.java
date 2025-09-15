package bean;

public class CustomText {
	// Trong class, nếu thuôc tính khai báo là final thì tất cả các hàm khởi tao phải gán giá tri 
	// mặc định cho thuộc tính final đó
	// bắt buộc phải có khi khởi tạo đối tượng
	private final String text;
	// reflection
	private String reversedText;
	// public CustomText() { 
	///this.text = null;
	// }I
	public CustomText(String text) {
		this.text = text;
	}
	// CustomText ct1 = new CustomText();
	// ct1.text = "x";
	// CustomText ct2 = new CustomText("hello") ;
	public String getText() {
		return text;
	}
	@Override
	public String toString() {
		return "CustomText [text=" + text + ", reversedText=" + reversedText + "]";
	}
	
	}
