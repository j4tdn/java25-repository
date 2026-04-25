package view.generate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import functional.Condition;

public class Ex01GennericMethod {
	
	public static void main(String[] args) {
		Integer[] ints = {1,2,3,4,5};
		Double[] dobs = {1d,2d,3d,4d,5d};
		String[] strs = {"a", "b", "c", "d", "e"};
		
		print("1. ints", ints);
		print("2. dobs", dobs);
		print("3. strs", strs);
		
		System.out.println("====== sử dụng gểnic method=====");
		generate("1. ints", ints);
		generate("2. dobs", dobs);
//		generate("3. strs", strs);
		
		//-------------------------------------
		List<Integer>  intsList = List.of(1,2,3,4,5);
		List<Double>  dobsList = List.of(1d,2d,3d,4d,5d);
		List<String>  strsList = List.of("a", "b", "c", "d", "e");
		List<Object>  objList = List.of("a", 1, "c", 40d, "e", LocalDate.now());
		
		printList("1. intsList", intsList);
		printList("2. dobsList", dobsList);
		printList("3. strsList", strsList);
		printList("4. objList", objList);
	
		
		System.out.println("===== Test Filter =====");
		printList("1. intsList(filter) ",filter(intsList, intE -> intE > 2));
		printList("3. strList(filter) ",filter(strsList, intE -> intE.compareTo("c") > 0));
	}
	
	private static <E> List<E> filter(List<E> elements, Condition<E> condition){
		List<E> result = new ArrayList<>();
		for(E element: elements) {
			if(condition.test(element)) {
				result.add(element);
			}
		}
		return result;
	}
	
	//Tham số là
	// List<Object> bắt buộc bên ngoài truyền vào phải là List<Object>
	// List<T> bên ngoài truyền vào là list<KDL Đối tượng cho T>
	private static <T> void printList(String prefix, List<T> elements) {
		System.out.println(prefix + " ---> { ");
		for(Object element: elements) {
			System.out.println("- " + element);
		}
		System.out.println("}\n");
	}
	
	//C2: Sửu dụng generic type là tham số cho metghod --> genneric method
	// <Element>: khai báo genneric type tên là element cho hàm print
	//           phạm vi sử dụng trong hamf print
	//           nhận vào 1 KDL đối tượng(ko giớ hạn thì = object
	//Dùng từ khóa extends, super để giới hạn, mở rộng KDl cho Element
	//			: T extends X --> t có thể nhạn vào KDL x hoặc con của nó
	//              super     --> 							   cha(Chỉ dùng cho wildcard)	
	
	private static <Element extends Number > void generate(String prefix, Object[] elements) {
		System.out.println(prefix + " ---> { ");
		for(Object element: elements) {
			System.out.println("- " + element);
		}
		System.out.println("}\n");
	}
	
	//C1: Vận dụng tính chất kế thừa và đa hình trong đối tượng
	private static void print(String prefix, Object[] elements) {
		System.out.println(prefix + " ---> { ");
		for(Object element: elements) {
			System.out.println("- " + element);
		}
		System.out.println("}\n");
	}
	private static void print(Double[] elements) {
		for(Double element: elements) {
			System.out.println("- " + element);
		}
	}
	private static void print(String[] elements) {
		for(String element: elements) {
			System.out.println("- " + element);
		}
	}

}
