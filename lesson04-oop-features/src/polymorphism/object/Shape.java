package polymorphism.object;

public class Shape {

	// Hàm trong KDL cha --> chưa biết phần thực thi cụ thể
	// Yêu cầu các KDL con khi thừa kế 
	void calcS() {
		// dummy text
		// unknow formula for calculating area
		System.out.println("Shape#calS unknow");
	}
	
	void setColor() {
		System.out.println("Shape#Color unknow");
	}
}
