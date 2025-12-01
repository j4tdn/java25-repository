package polymorphism.object;

public class Shape {
	
	// Hàm trong KDL cha --> chưa biết phần thực thi cụ thể(body rỗng)
	// Yêu cầu các KDL con khi thừa kế từ KDL cha thì bắt buộc phải override lại
	
	void calcS() {}
	
	private void setColor() {
		System.out.println("Shape#setColor unknown");
	}
}
