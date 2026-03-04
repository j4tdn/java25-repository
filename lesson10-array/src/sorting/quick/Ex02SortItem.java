package sorting.quick;

import bean.Item;
import model.DataModel;
import static utils.PrintUtils.*;

import java.util.Arrays;

public class Ex02SortItem {
	public static void main(String[] args) {
		Item[] items = DataModel.mockItems();
		generate("1. Dữ liệu ban đầu", items);
		
		Arrays.sort(items);
		generate("1. Sx tăng dần theo giá bán", items);
		
		/*
		 Arrays.sort(Object[] objects)
		 - objects có thể nhận bất kì KDL mảng đối tượng nào
		 - yêu cầu KDL của đối tượng truyền vào 
		  - phải là Comparable hoặc IMplements Comparable Interface 
		  - để overide lại hàm e1.compareTo(e2) để biết đc cách thức tăng/ giảm dần theo thuộc tính gì đó
		  - với e1, e2 lần lượt là phần tử trước, sau trong mảng.
		  
		 */
		
		Arrays.sort(items);
		generate("2. Sx giảm dần theo giá bán", items);
		 
	}
}
