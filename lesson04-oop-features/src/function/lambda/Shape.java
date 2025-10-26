package function.lambda;
@FunctionalInterface
public interface Shape {
	//Interface cos duy nhaats 1 hamf truwuf tuownjg --> Functional Interface(@FI)
	//Để khởi tạo 1 đối tượng từ @FI
	//= Tạo implementation class, trolng imple class override lại hàm trừuu tượng --> interface new sub class
	//- New trực tiếp interface tạivị trí khai báo --> anonymous class 
	//- Sử dụng anonymous function -->lambada expression (@fi)
	// Cónnotatiolion @Function alInterface: Bắt lỗi tại comle nếu interfafce có  nhiều hơn 1 hàm trừu tườ 
	
	void calcS();
	default void clear() {
		System.out.println("Shape --> clear ...");
	};
	
	private void setStyle() {
		System.out.println("Shape --> setStyle ...");
	};
	

}
