package view.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex01RawTypes {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// Từ JDK 1.0 đến 1.4
		// Khi 1 Type cần tham số hóa cho Generic Type, nếu mình không truyền 
		// 		KDL đối tượng cho Generic Type --> hiện warning là raw types
		// Mặc định sẽ là Object --> nhận bất kỳ KDL nào vào
		
		// Raw Type
		// Lợi ích: thêm phần tử với giá trị ở bất kỳ KDL nào
		// Hạn chế: thiếu sự ràng buộc phạm vi của dữ liệu --> dễ bị lỗi ép kiểu tại runtime
		
		// Generic Type
		// Lợi ích: ràng buộc KDL rõ ràng, hỗ trợ bắt lỗi tại compile nếu truyền dữ liệu ko đúng
		
		List<Integer> listA = new ArrayList<Integer>();
		
		List listB = new LinkedList();
		
		listA.add(1);
		listA.add(2);
		listA.add(3);
		listA.add(4);
		
		listB.add('A');
		listB.add('B');
		listB.add('C');
		listB.add('D');
		listB.add('E');
		
		System.out.println("listA size: " + listA.size());
		System.out.println("listB size: " + listB.size());
		
		System.out.println("---- ListA elements x double ----");
		for (Object number: listA) {
			int validNumber = Integer.parseInt(String.valueOf(number)); // casting Object -> int
			System.out.println(validNumber * 2);
		}
		
	}
	
}
