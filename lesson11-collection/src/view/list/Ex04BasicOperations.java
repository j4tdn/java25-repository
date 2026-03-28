package view.list;

import java.util.ArrayList;
import java.util.List;

import static util.PrintUtils.*;

public class Ex04BasicOperations {

	public static void main(String[] args) {
		
		List<String> list1 = mockList1();
		List<String> list2 = mockList2();
		
		// Hop 2 danh sach
		List<String> union = new ArrayList<>(list1);
		union.addAll(list2);
		generateStrings("1. Ket qua sau khi hop 2 DS", union);
		
		// Giao 2 danh sach
		List<String> intersect = new ArrayList<>(list1);
		intersect.retainAll(list2);
		generateStrings("2. Ket qua sau khi giao 2 DS", intersect);
		
		// Hieu 2 danh sach
		List<String> diff = new ArrayList<>(list1);
		diff.removeAll(list2);
		generateStrings("3. Ket qua sau khi hieu 2 DS", diff);
	}
	
	private static List<String> mockList1(){
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		return list;
	}
	
	private static List<String> mockList2(){
		List<String> list = new ArrayList<>();
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("E");
		return list;
	}
	
}
