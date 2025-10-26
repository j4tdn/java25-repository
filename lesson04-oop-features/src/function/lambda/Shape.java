package function.lambda;

@FunctionalInterface

public interface Shape {
	
	// interface có duy nhất 1 hàm trừu tượng --> functional interface
	
	// Để khởi tạo 1 đối tượng từ @FunctionalInterface
	// - TẠO một implementation class, trong imple class override lại hàm trừu tượng --> interface new sub class
	// - new trực tiếp interface tại vị trí khai báo --> anonymous class
	// - Sử dụng anonymous function --> lambda expression (@FunctionalInterface)
	
	// có annotation @FunctionalInterface: bắt lỗi tại compile nếu interface có nhiều hơn 1 hàm trừu tượng
	
	void calcS();
	
	default void clear() {
		System.out.println("Shape --> clear ...");
	}

}
