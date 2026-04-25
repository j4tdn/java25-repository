package view.list;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Ex01RawType {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//KHai báo cấu trúc dữ liệu trong collection
		
		//Từ jdk 1.0 đến 1.4
		//Khi 1 type cần tham số hóa cho Genneric Type, nếu mình không truyền KDL cho Genneric Type --> Hiện warning là raw type
		//Mặc định là object --> nhận bất kỳ kdl nào;
		
		//Raw type
		// Lợi ích: thêm phần tử với giá trị bất kỳ KDL nào
		// Hạnn chế: thiếu sự ràng buộc phạm vị cuẩ dữ liệu --> dễ bị lỗi ép kiểu tại runtime
		
		// Generic type
		// lợi ích: ràng buộc KDl rõ ràng, hỗ trợ bắt lỗi tại compile nếu truyền dữ liệu không đúng
		
		// lưu danh sach cá số nguyên
		// lưu danh sách các ký tự
		
		// 1.4 List list = new ArayList();
		// 1.5 List<T> list = new ArayList<T>();
		// 1.7 List<T> list = new ArayList<>();

		@SuppressWarnings("rawtypes")
		List<Integer> listA = new ArrayList();
		
		@SuppressWarnings("rawtypes")
		List listB = new LinkedList();
		
		listA.add(1);
		listA.add(2);
		listA.add(3);
		listA.add(4);
//		listA.add(new Date());
//		listA.add("Five");
		
		listB.add('A');
		listB.add('B');
		listB.add('C');
		listB.add('D');
		listB.add('E');
		
		System.out.println("ListA size: " + listA.size());
		System.out.println("ListB size: " + listB.size());
		
		System.out.println("--- ListA elements ---");
		for(Object number: listA) {
			int invalue = Integer.parseInt(String.valueOf(number));
			System.out.println(invalue * 2);
		}
		
		
	}
	
}
