package view;

public class S8 {
	
	// S8: Ý nghĩa của từ khóa static
	
	// 1. Static Attribute: một thuộc tính có giá trị dùng chung cho tất cả các đối tượng
	//                    : lưu trữ ở một ô nhớ độc lập
	
	// 2. Static Method: hàm nào ko phụ thuộc đối tượng đang gọi
	
	// 3. Static Class: Nested Class, tiện cho việc gọi nested class
	
	// 4. Static attribute/method sẽ được loading trước non-static
	
	public static void main(String[] args) {
		NestedS8 ns8 = new NestedS8();
		
		S8 s8 = new S8();
		NonS8 non8 = s8.new NonS8();
	}
	
	
	static class NestedS8 {
		int a;
		int b;
	}
	
	class NonS8 {
		
	}
	
}