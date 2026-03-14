package view.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex01RawTypes {

	public static void main(String[] args) {
		// khai báo cấu trúc dữ liệu trong Collection(s)
		
		// Từ JDK 1.0 đến 1.4
		// Khi 1 cái type mà cần tham số hóa cho Generic Type, nếu mình không truyền KDL đối tượng cho Generic Type --> hiện warning là raw types
		// Mặc định sẽ là Object --> nhận bất kỳ KDL nào vào
		
		// Raw Type
		// Lợi ích: thêm phần tử với giá trị bất kỳ KDL nào
		// Hạn chế: thiếu sự ràng buộc phạm vi của dữ liệu --> dễ bị lỗi ép kiểu tại runtime
		
		// Generic Type
		// Lợi ích: ràng buộc KDL rõ ràng, hỗ trợ bắt lỗi tại Compile nếu truyền dữ liệu không đúng
		
		// Lưu danh sách các số nguyên
		// Lưu danh sách các kí tự
		
		// Version 1.6 bắt buộc phải khai báo ArrayList<Integer>()
		List<Integer> listA = new ArrayList<>();
		List listB = new LinkedList<>();

		listA.add(1);
		listA.add(2);
		listA.add(3);
		listA.add(4);
		
		listB.add('A');
		listB.add('B');
		listB.add('C');
		listB.add('D');
		
		System.out.println("listA size: " + listA.size());
		System.out.println("listB size: " + listB.size());
		
		System.out.println("------ listA Element x double --------");
		for(Object number : listA) {
			System.out.println(number);
		}
	}

}
