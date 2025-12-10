package function.lambda;

@FunctionalInterface
public interface Shape {
	
	// interface có duy nhất 1 hàm trừu tượng --> Functional Interface(@FI)
	// để khởi tạo 1 đối tượng từ @FI
	// - tạo implementation class, trong impl class override lại hàm trừu tượng --> interface new sub class
	// - new trực tiếp interface tại vị trí khai báo --> anonymous class
	// - sử dụng anonymous function --> lambda expression
	
	
	// có annotation @FunctionalInterdace: bắt lỗi tại compile nếu interface có nhiều hơn 1 hàm trừu tượng
	
	void calcS();
	
	default void clear() {
		System.out.println("Shape --> clear...");
		setStyle();
	}
	
	private void setStyle() {
		System.out.println("Shape --> setStyle ...");
	}

}
