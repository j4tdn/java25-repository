package function.lambda;

@FunctionalInterface
public interface Shape {
	
	//Interface có duy nhất 1 hàm trừu tượng --> Functiong Interface(@FI)
	
	//Để khởi tạo 1 đối tượng từ @FI
	// - Tạo implementation class, trong impl class override lại hàm trừu tượng  --> interface new sub class
	// - New trực tiếp interface tại vị trí khai báo --> anonymous class(I)
	// - Sử dụng anonymous function --> lambda expression (@FI)
	
	//Có annotation @FunctionalInterface: bắt lỗi tại compile néu interface có nhiều hơn 1 hàm trừu tương
	void calcS();
	default void clear() {
		System.out.println("Shape --> clear ...");
		setStyle();
	}
	private void setStyle() {
		System.out.println("Shape --> setStyle ...");
	}
}
