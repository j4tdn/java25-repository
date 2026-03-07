package sorting.quick;

import bean.Item;
import model.DataModel;

import static utils.PrintUtils.*;

import java.util.Arrays;

public class Ex02SortItem {
	
	public static void main(String[] args) {
		
		Item[] items = DataModel.mockItems();
		
		generate("1. Dữ liệu ban đầu", items);
		
		/*
		 Cách 1: Arrays.sort(Object[] objects)
		 - objects có thể nhận bất kỳ KDL mảng đối tượng nào
		 - yêu cầu KDL của đối tượng truyền vào
		   + phải là Comparable hoặc implements Comparable interface
		   + để override lại hàm e1.compareTo(e2) để biết được cách thức sort như thế nào
		   + tăng/giảm dần theo thuộc tính gì đó
		   + với e1,e2 lần lượt là phần tử trước, sau trong mảng objects
		   
		 Muốn dùng Arrays.sort(Object[] objects) thì
		 - KDL của class cho mảng phải implement Comparable<T>
		 - override lại compareTo(T o) [strategy] để xác định cách thức sort
		 
		 Hạn chế
		 - chỉ có 1 chỗ là T#compareTo để xác định cách thức sort nên nếu bài toán
		 cần nhiều cách sort khác nhau thì không xử lý được
		 
		 Cách 2: Arrays.sort(T[] elements, Comparator<? super T> comparator)
		 - elements: mảng với từng phần từ là T
		 - comparator: strategy với int compare(T o1, T o2) để xác định cách thức sort
		 
		 Comparable<T> ==> int compareTo(T o)
		 
		 Comparator<T> ==> int compare(T o1, T o2) 
		 
		 */
		System.out.println("---------------- comparable ------------------");
		
		Arrays.sort(items); // line 28
		generate("1. Sắp xếp tăng dần theo giá bán", items);
		
		Arrays.sort(items); // line 31
		generate("2. Sắp xếp giảm dần theo tên mặt hàng", items);
		
		System.out.println("\n---------------- comparator ------------------\n");
		
		Arrays.sort(items, (item1, item2) -> item1.getSalesPrice().compareTo(item2.getSalesPrice()));
		generate("1. Sắp xếp tăng dần theo giá bán", items);
		
		Arrays.sort(items, (item1, item2) -> {
			return item2.getName().compareTo(item1.getName());
		});
		generate("2. Sắp xếp giảm dần theo tên mặt hàng", items);
		
		Arrays.sort(items, (item1, item2) -> {
			return item1.getExpiredDate().compareTo(item2.getExpiredDate());
		});
		generate("3. Sắp xếp ngày hết hạn tăng dần", items);
		
		Arrays.sort(items, (item1, item2) -> {
			int storeIdInt = item2.getStoreId().compareTo(item1.getStoreId());
			if (storeIdInt != 0) {
				return storeIdInt;
			}
			return item1.getSalesPrice().compareTo(item2.getSalesPrice());
		});
		generate("4. Sắp xếp mã cửa hàng giảm dần, giá bán tăng dần", items);
	}
	
}