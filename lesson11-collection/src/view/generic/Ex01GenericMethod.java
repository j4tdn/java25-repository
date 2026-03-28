package view.generic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import functional.Condition;

public class Ex01GenericMethod {

	public static void main(String[] args) {
		
		Integer[] ints = {1, 2, 3, 4, 5};
		Double[] dobs = {1d, 2d, 3d, 4d, 5d};
		String[] strs = {"a", "b", "c", "d", "e"};
		
		print("1. ints", ints);
		print("2. dobs", dobs);
		print("3. strs", strs);
		
		System.out.println("======= Su dung Generic Method =======\n");
		
		generate("1. ints", ints);
		generate("2. dobs", dobs);
		//generate("3. strs", strs);
		
		//------------------------------------------
		
		List<Integer> intList = List.of(1, 2, 3, 4, 5);
		List<Double> dobList = List.of(1d, 2d, 3d, 4d, 5d);
		List<String> strList = List.of("a", "b", "c", "d", "e");
		List<Object> objList = List.of("a", "b", 1, "c", 40d, LocalDate.now());
		
		printList("1. intList", intList);
		printList("2. dobList", dobList);
		printList("3. strList", strList);
		printList("4. objList", objList);
		
		System.out.println("=== Test Filter ===");
		
		printList("1. intList(filtered)", filter(intList, intE -> intE > 2));
		printList("2. strList(filtered)", filter(strList, strE -> strE.compareTo("c") > 0));
	}
	
	private static <E> List<E> filter(List<E> es, Condition<E> conition){
		List<E> rs = new ArrayList<>();
		for(E e: es) {
			if(conition.test(e)) {
				rs.add(e);
			}
		}
		return rs;
	}
	
	private static <T> void printList(String prefix, List<T> es) {
		System.out.println(prefix + " ---> {");
		for(Object e: es) {
			System.out.println("- " + e);
		}
		System.out.println("}\n");
	}
	
	// Cach 2: Su ung generic type la tham so cho method --> generic method
	private static <E extends Number> void generate(String prefix, E[] es) {
		System.out.println(prefix + " ---> {");
		for(E e: es) {
			System.out.println("- " + e);
		}
		System.out.println("}\n");
	}
	
	// Cach 1: Van dung kien thuc ke thua va da hinh tronng doi tuong
	private static void print(String prefix, Object[] es) {
		System.out.println(prefix + " ---> {");
		for(Object e: es) {
			System.out.println("- " + e);
		}
		System.out.println("}\n");
	}
	
	private static void print(Integer[] es) {
		for(Integer e: es) {
			System.out.println("- " + e);
		}
	}
	
	private static void print(Double[] es) {
		for(Double e: es) {
			System.out.println("- " + e);
		}
	}
	
	private static void print(String[] es) {
		for(String e: es) {
			System.out.println("- " + e);
		}
	}
}
