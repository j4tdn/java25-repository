package view.list;

import java.util.ArrayList;
import java.util.List;

public class Ex05ArrayListPrinciple {
	/** 
	 - class ArrayList sử dụng cấu trúc dữ liệu nào? 
	 	--> mảng 1 chiều
	 	--> tại sao khi dùng mảng cơ bản mà phải tạo ra ArrayList
	 		^ hỗ trợ dynamic method
	 		^ hỗ trợ dynamic size
	 		^ enhance performance của các method khi so sánh với array nếu tự thực thi
	 	
	 - cơ chế hoạt động khi thêm sửa xóa phần tử trong ArrayList
	 
	 - new ArrayList<>()
	 	--> khởi tạo thuộc tính elementData = {}
	 	--> size = 0
	 	--> khi mình biết chắc chắn cái số lượng phần tử tối đa cần lưu trong ArrayList
	 		--> truyền initial Capacity bằng số lượng phần tử đó 
	 		--> khởi tạo elementData 1 lần duy nhất
	 		--> hạn chế 'grow'
	 
	 - new ArrayList<>(initialCapacity)
	   --> khởi tạo thuộc tính elementData = new Object[initialCapacity]
	   --> size = 0
	 	
	 
	 - #add(e)
	   --> trong lần đầu tiên thêm mới phần tử vào ArrayList
	   --> khởi tạo mảng elementData mặc định có length = 10
	   --> gán giá trị e vào elementData
	   --> cứ mỗi lần add vào 
	   	   --> size tăng lên

	 - size số phần tử thật sự đang chứa trong elementData, luôn <= length
	 	--> ArrayList thao tác với size
	 	
	 class ArrayList<E> {
	 	int size;
	 	
	 	int DEFAULT_CAPACITY = 10;

	 	Object[] elementData;
	 	
	 	Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
	 	
	 	public ArrayList() {
        	this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    	}
    	
    	 public boolean add(E e) {
        	modCount++;
        	add(e, elementData, size);
        	return true;
    	}
	 	
	 	
	 }
	 	
	 * */

	public static void main(String[] args) {
		List<String> elements = new ArrayList<>();
		
		elements.add("a");
		
		System.out.println("size: " + elements.size());
	}
}
