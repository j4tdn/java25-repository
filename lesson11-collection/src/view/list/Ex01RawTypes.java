package view.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex01RawTypes {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Khai báo cấu trúc dữ liệu trong Collection(s)

		// Từ JDK 1.0 đến 1.4
		// Khi 1 Type cần tham số hóa cho Generic Type, nếu mình không truyền KDL đối tượng cho Generic Type --> hiện warning là raw types
		// Mặc định sẽ là Object --> nhận bất kỳ KDL nào vào
		
		// Raw Type
		// Lợi ích: thêm phần tử với giá trị ở bất kỳ KDL nào
		// Hạn chế: thiếu sự ràng buộc phạm vi của dữ liệu --> dễ bị lỗi ép kiểu tại runtime
		
		// Generic Type
		// Lợi ích: ràng buộc KDL rõ ràng, hỗ trợ bắt lỗi tại compile nếu truyền dữ liệu ko đúng
		
		// Lưu danh sách các số nguyên
		// Lưu danh sách các kí tự
		
		// 1.4 List list = new ArrayList();
		// 1.5 List<T> list = new ArrayList<T>();
		// 1.7 List<T> list = new ArrayList<>();
		
		List<Integer> listA = new ArrayList<>();
		
		
		// @SuppressWarnings("rawtypes")
		List listB = new LinkedList();
		
		listA.add(1);
		listA.add(2);
		listA.add(3);
		listA.add(4);
		
		// compile error
		// listA.add(new Date());
		// listA.add("Five"); 
		
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
