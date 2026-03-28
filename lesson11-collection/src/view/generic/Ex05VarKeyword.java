package view.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.locks.Condition;
import java.util.function.Predicate;

import bean.Item;

public class Ex05VarKeyword {

	/**
	 * var: xuat hien tu JDK 10
	 * - thay vi khai bao loai KDL cua bien phia ben trai
	 * - thay the bang tu khoa var
	 * - dua vao gia tri cua ve phai de xac inh KDL cua bien tai compile, runtime
	 * --> k dung dc tinh chat cha new con
	 * 
	 * 
	 * JavaScript: var(function scope), loosely-dynamic type
	 * Java		 : var(block scope), static type
	 * 
	 * function method(){
	 * 		var a = 5;
	 * 		while(true){
	 * 			var b = 5;
	 * 			console.log('welcome' + b);
	 * 			b++;
	 * 
	 * 			if(b = 10) break;
	 * 		}
	 * 
	 * 		console.log('a');
	 * 		console.log('b');
	 * }
	 * 
	 * dieu kien:
	 * - phan gia tri ben phai 'ro rang'
	 * 
	 * k the su dung var trong cac TH
	 * - khai bao bien KDL cho lamda
	 * 
	 * muc dich: 
	 * - giups code ngan gonj hon trong vai TH
	 * - giup code de doc hon
	 */
	
	public static void main(String[] args) {
		
		// Cach 1: Khai bao thong thuong
		char a1 = '#';
		String b1 = "Welcome";
		Item c1 = new Item();
		List<Item> d1 = new ArrayList<>();
		List<java.util.Map.Entry<Integer, String>> e1 = new ArrayList<>();
		List<java.util.Map.Entry<Integer, String>> f1 = callList();
		functional.Condition<String> g1 = (String s) -> {
			return s.compareTo("a") > 0;
		};
		Predicate<String> h1 = (String s) -> {
			return s.compareTo("a") > 0;
		};
		
		// Cach 2: Khai bao su dung tu khoa var
		var a2 = '#';
		var b2 = "Welcome";
		var c2 = new Item();
		var d2 = new ArrayList<>(); // ArrayList<Object>
		var d3 = new ArrayList<Item>(); // ArrayList<Item>
		var e2 = new ArrayList<Entry<Integer, String>>();
		var f2 = callList();
//		var g2 = (String s) -> {
//			return s.compareTo("a") > 0;
//		};
	}
	
	private static List<Entry<Integer, String>> callList(){
		return List.of();
	}
}
