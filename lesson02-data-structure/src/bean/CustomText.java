package bean;

public class CustomText {
	
	// Trong class, neu thuoc tinh khai bao la final thi tat ca cac ham khoi tao
	// phai gan gia tri cho thuoc tinh final do
	
	// bat buoc phai co khi khoi tao doi tuong
	
	private final String text; // reflection
	//private String reversesText;
	
//	public CustomText() {
//		this.text = null;
//	}
//	
	public CustomText(String text) {
		this.text = text;
	}
	
	// getter - Ho tro su dung gia tri cua thuoc tinh
	public String getText() {
		return text;
	}
	
	@Override
	public String toString() {
		return "CustomText[" + this.text + "]";
	}
}
