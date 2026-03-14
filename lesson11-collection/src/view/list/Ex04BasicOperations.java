package view.list;

import java.util.ArrayList;
import java.util.List;
import static utils.PrintUtils.*;

public class Ex04BasicOperations {

	public static void main(String[] args) {
		List<String> list1 = mockList();
		List<String> list2 = mockList2();
		
		// Hợp 2 danh sách
		List<String> union = new ArrayList<>(list1);
		union.addAll(list2);
		
		generateString("1. Kết quả sau khi hợp 2 danh sách", union);
		
		// Giao 2 danh sách
		List<String> intersect = new ArrayList<>(list1);
		intersect.retainAll(list2);
		generateString("2. Kết quả sau khi giao 2 danh sách", intersect);
		
		// Hiệu 2 danh sách
		List<String> diff = new ArrayList<>(list1);
		intersect.removeAll(list2);
		generateString("2. Kết quả sau khi hiệu 2 danh sách", diff);
		
	}
	
	private static List<String> mockList() {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		return list;
	}
	
	
	private static List<String> mockList2() {
		List<String> list = new ArrayList<String>();
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		return list;
	}
}
