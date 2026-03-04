package sorting.quick;

import bean.Item;
import model.DataModel;

import static utils.PrintUtils.*;

import java.util.Arrays;

import javax.annotation.processing.Generated;

public class Ex02SortItem {

	
		public static void main(String[] args) {
			Item[] items = DataModel.mockItems();
			generate("1. Dữ liệu ban đầu",items);
			
			/*
			 Arrays.sort(Object[] object
			 -Object có thể nhận bât kì KDL mảng đối tượng nào 
			 -Yêu cầu KDL của đối tượng truyền vào
			 	+Phải là comparable hoặc implements Comparable interface
			 	+Để override lại hàm e1.CompareTo(e2) để biết được ách thức
			 	+Tăng /giảm dần theo thuộc tính gì đó
			 	+ Với e1,e2 lần lượt là phần tử trước sau trong mảng object
			 
			 */
			
			//Arrays.sort(items);
			
			//generate("2. Sắp xếp giảm dần theo tên mặt hàng",items);
		}
	
}
