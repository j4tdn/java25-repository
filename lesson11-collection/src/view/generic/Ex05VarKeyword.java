package view.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import functional.Condition;

public class Ex05VarKeyword {
	/** 
	 * var: xuất hiện từ JDK 10
	 * - thay vì khai báo KDL của biến phía bên phải
	 * - thay thế bằng từ khóa var
	 * - dựa vào giá trị của vế bên phải để xác định KDL của biến tại compile, runtime
	 *   -- không sử dụng được tính chất đa hình trong đối tượng
	 * 
	 * Java      : var(block scope), static type
	 * 
	 * 
	 * điều kiện:
	 * - phần giá trị bên phải phải "rõ ràng"
	 * 
	 * không thể sử dụng var trong trường hợp
	 * - lambda
	 * - làm tham số truyền vào cho hàm
	 * 
	 * mục đích:
	 * - giúp code ngắn gọn hơn trong 1 vài trường hợp
	 * - giúp code dễ đọc hơn
	 * */
	
	
	public static void main(String[] args) {
		List<Entry<Integer, String>> e1 = new ArrayList<>();
		
		Condition<String> g1 = (String s) -> {
			return s.compareTo("a") > 0;
		};
		
		var a2 = '#';
		var b2 = "welcome";
		var d2 = new ArrayList<>(); // ArrayList của Object
		var e2 = new ArrayList<Entry<Integer,String>>();
		
//		var g2 = (String s) -> {
//			return s.compareTo("a") > 0;
//		};
	}
	
//	private void testing(var s) {
//		
//	}
}
