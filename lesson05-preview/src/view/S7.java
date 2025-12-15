
package view;

public /*final*/ class S7 {
	
	// S7. Những vị trí có thể đặt từ khóa final

	// 1. Class --> Class có từ khóa final, ko cho phép class con thừa kế từ nó
	//    Usage: Ở những class KDL của Java như là Integer, Double, String ... mong muốn luôn sử dụng KDL của Java thay vì thừa kế rồi custom
	//         : Utility class
	
	// 2. Attribute/Variable
	//    Usage: final at stack, muốn biến nguyên thủy ko thể thay đổi được giá trị hoặc biến đối tượng
	//           ko thể cập nhật địa chỉ(tránh tạo ra các ô nhớ rác) thì cho final
	
	// 3. Method
	//    Usage: không cho phép override
	
	// ----------------------------------------------
	// Mặc định 1 thuộc tính trong interface là final
	
	public static void main(String[] args) {
		
	}
	
	protected /*final*/ void logging() {
		System.out.println("S7: logging ...");
	}
	
}
