package view.list;

import java.util.ArrayList;
import java.util.List;

public class Ex05ArrayListPrinciple {
	
	/**
	 - class ArrayList sử dụng cấu trúc dữ liệu nào ?
	   --> mảng 1 chiều
	   --> tại sao khi dùng mảng cơ bản mà phải tạo ra ArrayList
	       ^ hỗ trợ rất nhiều methods
	       ^ hỗ trợ dynamic size
	       ^ enhance hiệu suất của các method khi so sánh với array nếu tự thực thi
	   
	 - cơ chế hoạt động khi thêm sửa xóa phần tử trong ArrayList
	 
	 - new ArrayList<>()
	   --> khởi tạo thuộc tính elementData = {}
	   --> size = 0
	   
	 - #add(e)
	   --> trong lần đầu tiên thêm mới phần tử vào ArrayList
	   --> khởi tạo mảng elementData mặc định có length = 10
	   --> gán giá trị e vào elementData[0]   
	   
	   --> cứ mỗi lần add vào
	       --> nếu size = elementData.length
	              grow elementData
	              --> tạo mảng mới copy elementData
	              --> kích thức lớn hơn current length * 1.5
	       --> đưa phần tử vào elementData 
	       --> size tăng lên
	       
	  - size số phần tử thật sự đang chứa trong elementData, luôn <= length
	    --> ArrayList thao tác với size
	   
	  - length: độ dài của mảng elementData
	  - capacity: sức chứa của mảng elementData bên trong ArrayList = length     
	 
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
	    
	    private void add(E e, Object[] elementData, int s) {
	        if (s == elementData.length)
	            elementData = grow();
	            // elementData =  {"A", "B", "C", "D", "E", "F", "G", "H", "I", "K", 
	             * null, null, null, null, null}
	        elementData[s] = e;
	        // elementData = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "K", "L", 
	         * null, null, null, null}
	        size = s + 1; // size = 11
	    }
	    
	    private Object[] grow() {
	        return grow(size + 1);
	    }
	    
	    private Object[] grow(int minCapacity) {
	        int oldCapacity = elementData.length;
	        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
	            int newCapacity = ArraysSupport.newLength(oldCapacity,
	                    minCapacity - oldCapacity,  minimum growth
	                    oldCapacity >> 1            preferred growth);
	            return elementData = Arrays.copyOf(elementData, newCapacity);
	        } else {
	            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
	        }
	    }
	 	
	 }
	  
	 */
	
	public static void main(String[] args) {
		
		// Array			: get/set
		// ArrayList[Array] : get/set/remove/add
		
		List<String> elements = new ArrayList<>();
		
		elements.add("A");
		elements.add("B");
		elements.add("C");
		elements.add("D");
		elements.add("E");
		elements.add("F");
		elements.add("G");
		elements.add("H");
		elements.add("I");
		elements.add("K");
		
		elements.add("L");
		
		System.out.println("size: " + elements.size());
		
	}
	
}