package function.lambda;

@FunctionalInterface
public interface Shape {
	
	/* Interface có duy nhất 1 hàm trừu tượng --> Functional Interface(@FI)
	
	 Để khởi tạo 1 đối tượng cho @FI
	 - Tạo implementation class, trong iml class override lại hàm trừu tượng
	--> interface new sub class
	 - New trực tiếp interface tại vị trí khai báo --> anonymous class
	 - Sử dụng anonymous function --> lambda expression (@FI)
	 Có annotation @Functional Interface: bắt lỗi tại compile nếu interface có nhiều hơn 
	 1 hàm trừu tượng	
	*/ 
	
	void calcS();
	
	default void clear() {
		System.out.println("Shape --> clear ...");
	}
	private void setStyle() {
		System.out.println("Shape --> setStyle ...");
	}
		
}
