package view.list;

import java.util.ArrayList;
import java.util.List;

public class Ex05ArrayListPrinciple {
	public static void main(String[] args) {
		
		/*
		 * -Class ArrayList sử dụng cấu trúc dữ liệu nào?
		 * 	--> mảng 1 chiều
		 * 	--> tại sao khi dùng mảng cơ bản mà phải tạo ra ArrayList
		 * 		+Hỗ trợ rất nhiều methods
		 * 		+Hỗ trợ dynamic size
		 * 		+Enhance hiệu suất của các methods khi so sánh với Array nếu tự 
		 * 
		 * -Cở chế hoạt động khi thêm sửa xóa ptu trong ArrayList
		 * 
		 * -New ArrayList()
		 * 
		 * 
		 */
		List<String> elements = new ArrayList<>();
		
		elements.add("A");
		
		System.out.println("size: " + elements.size());
	}
}
