package view.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import bean.Item;

public class Ex05VarKeyword {
	
	/**
	 * var: xuất hiện từ JDK 10
	 * - dựa vào giá trị của vế bên phải để xác định KDL của biến tại compile, runtime
	 * 
	 * primary goal
	 * - reduce boilerplate code in some of cases
	 * - improve readability
	 * @param args
	 */
	public static void main(String[] args) {
		
		var a2 = '#';
		var b2 = "welcome";
		var c2 = new Item();
		var d2 = new ArrayList<Item>();
		var e2 = new ArrayList<Entry<Integer, String>>();
		var f2 = callList();
		
	}
	
	private static List<Entry<Integer, String>> callList() {
		return List.of();
	}

}
