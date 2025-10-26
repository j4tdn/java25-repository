package polymorphism.object;

public class Shape {
	/*
	 * Hàm trong KDL cha --> chưa biết phần thực thi cụ thể(body rỗng)
	 * Yêu cầu các KDL con khi thừa kế từ KDL cha thì bắt buộc phải Override lại 
	 */
	void calcS() {
		
	}
	private void setcolor() {
		System.out.println("Shape#setColor unknow");
	}
}
