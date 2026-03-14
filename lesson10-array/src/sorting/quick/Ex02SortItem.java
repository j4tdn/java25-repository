package sorting.quick;

import bean.Item;
import model.DataModel;
import static utils.PrintUtils.*;

import java.util.Arrays;

public class Ex02SortItem {

	public static void main(String[] args) {
		Item[] items = DataModel.mockItem();
		
		generate("1. Dữ liệu ban đầu", items);
		
		/* 
		  Arrays.sort(Object[] objects)
		 	- objects co the nhan bat ky KDL mang doi tuong nao
		 	- yeu cau KDL cua doi tuong truyen vao 
		 	  _ phai la Comparable hoac implements Comparable interface
		 	  _ de override lai ham compareTo
		 	  _ tang/giam dan theo thuoc tinh cua doi tuong 
		 	  _ voi e1, e2 lan luot la phan tu truoc sau trong mang object
		  
		  Muốn dùng Arrays.sort(Object[] objects) thì
		  	- KDL của class cho mảng phải implement Comparable<T>
		  	- override lại compareTo(T o) [strategy] để xác định cách thức sort
		  	
		  Hạn chế
		    - chỉ có 1 chỗ là T#compareTo để xác định cách thức sort nên nếu bài toán
		    cần nhiều cách sort khác nhau thì không xử lý được
		    
		  Cách 2: Arrays.sort(T[] elements, Comparator<? super T> comparator)
		  	- elements: mảng với từng phần tử là T
		  	- comparator: strategy với int compare(T o1, T o2) để xác định cách thức sort
		  	
		  Comparable<T> ==> int compareTo(T o)
		  
		  Comparator<T> ==> int compare(T o1, T o2)
		  
		  Priority Comparator > Comparable
		  */
		
		Arrays.sort(items);
		
		generate("2. Sắp xếp tăng dần theo giá bán", items);
		
		System.out.println("\n------------ comparator ----------------\n");
		Arrays.sort(items, (item1, item2) -> item1.getSalesPrice().compareTo(item2.getSalesPrice()));
		
		generate("1. Sắp xếp tăng dần theo giá bán", items);
		
		
		Arrays.sort(items, (item1, item2) -> item2.getName().compareTo(item1.getName()));
		generate("2. Sắp xếp giảm dần theo tên mặt hàng", items);
		
		Arrays.sort(items, (item1, item2) -> item1.getExpiredDate().compareTo(item2.getExpiredDate()));
		generate("3. Sắp xếp tăng dần theo ngày hết hạn", items);
	}

}
