package function.lamda;

@FunctionalInterface
public interface Shape {
	
	//Interface có duy nhất 1 hàm trừu tượng --> Functional Interface
	
	// Để khởi tạo 1 đối tượng từ @FI
	// - Tạo implementation class, trong impl class override lại hàm trừu tượng --> interface new sub class
	// - New trực tiếp interface tại ví trí khai báo --> anonymous class
	// - Sử dụng anonymous function --> lamda expression (@FI)
	
	// Có annotation @FunctionalInterface: bắt lỗi tại compile nếu interface có nhiều hơn 1 hàm trừu tượng
	
	void calcS();
	
	default void clear() {
		System.out.println("Shape --> clear ...");
		setStyle();
	}
	
	private void setStyle() {
		System.out.println("Shape --> setstyle ...");
	}
	
	

}
