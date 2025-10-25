package function.lambda;


@FunctionalInterface
public interface Shape {

	// Inter có duy nhất 1 hàm trừu tượng --> Functional Interface (@FI)
	
	// Để khởi tạo 1 đối tượng từ @FI
	//-Tạo 1 implementation class , trong impl class override lại hàm trừu tượng --> interface new sub class
	// -New trực tiếp interface tại vị trí khai báo --> anonymous class
	//- Sử dụng anonymoú function --> lambda expression (@FI)
	
	// Có annotation @FunctionalInterface : bắt lỗi tại compile nếu interface có nhiều hơn 1 trừu tượng
	
	void calcS();
	
	default void clear() {
		System.out.println("Shape --> Clear...");
		setStyle();
	}
	private void setStyle() {
		System.out.println("Shape --> setStyle ...");
	}
	
}
