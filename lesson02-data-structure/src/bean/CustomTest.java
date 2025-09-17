package bean;

public class CustomTest {
	//Trong class, nêú thuộc tính khai báo là final thì tất cả các hàm khởi tạo phải gán gtri 
	//mặc định cho thuộc tính final đó
	
	//bắt buộc phải có khi khởi tạo đối tượng
	
	private final String text;
	//private final String reversedtext;
	
	
//	public CustomTest() {
//		this.text = null;
//		
//	}
	
	public CustomTest(String text) {
		this.text = text;
	}
	
//	CustomTest ct1 = new CustomTest();
//	ct1.text = "x";
//		
//	CustomTest ct2 = new CustomTest("hello");
	
	public String getText() {
		return text;
		
	}
	
	@Override
	public String toString() {
		return "Customtext [ " + this.text + "]";
	}
	
		
		

}
