package view.generic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Predicate;

import bean.Item;
import functional.Condition;

public class Ex05VarKeyword {
	
	/**
	 * var: xuất hiện từ JDK 10
	 * - thay vì khai báo loại KDL của biến phía bên trái
	 * - thay thế bằng từ khóa var
	 * - dựa vào giá trị của vế phải để xác định KDL của biến tại compile, runtime
	 *   -- ko dùng tính chất cha new con ...
	 * 
	 * JavaScript: var(function scope), loosely-dynamic type
	 * Java      : var(block scope), static type
	 * 
	 * function method() {
	 *    var a = 5;
	 *    
	 *    while(true) {
	 *       var b = 5;
	 *       console.log('welcome ' + b);
	 *       b++;
	 *       
	 *       if (b==10) {
	 *          break;
	 *       }
	 *    }
	 *    
	 *    console.log(a);
	 *    console.log(b); // worked
	 * }
	 * 
	 * điều kiện
	 * - phần giá trị bên phải phải 'rõ ràng'
	 * 
	 * không thể sử dụng var trong các trường hợp
	 * - khai báo biến KDL cho lambda
	 * - biến của hàm
	 * 
	 * mục đích
	 * - giúp code ngắn gọn hơn trong 1 vài trường hợp
	 * - giúp code dễ đọc hơn 
	 */
	
	public static void main(String[] args) {
		// Cách 1: khai báo thông thường
		char a1 = '#';
		String b1 = "welcome";
		Item c1 = new Item();
		List<Item> d1 = new ArrayList<>();
		List<Entry<Integer, String>> e1 = new ArrayList<>();
		List<Entry<Integer, String>> f1 = callList();
		Condition<String> g1 = (String s) -> {
			return s.compareTo("a") > 0;
		};
		Predicate<String> h1 = (String s) -> {
			return s.compareTo("a") > 0;
		};
		
		// Cách 2: KHai báo sử dụng từ khóa var
		var a2 = '#'; // char
		var b2 = "welcome"; // b2 = new Date();
		var c2 = new Item();
		var d2 = new ArrayList<>(); // ArrayList<Object>
		var d3 = new ArrayList<Item>(); // ArrayList<Item>
		var e2 = new ArrayList<Entry<Integer, String>>();
		var f2 = callList();
		// var g2 = (String s) -> {
		//	return s.compareTo("a") > 0;
		// };
		
		
		
	}
	
	// private void testing(var x) {}
	
	private static List<Entry<Integer, String>> callList() {
		return List.of();
	}
	
}