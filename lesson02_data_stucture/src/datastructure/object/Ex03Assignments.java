package datastructure.object;

import bean.Item;

public class Ex03Assignments {
	public static void main(String[] args) {
		/*
		 *  để cập nhạt giá trị cho biết là
		 *  
		 *  - KDL nguyên thủy
		   --> thông qua toán tử gán =
		   
		    - KDL dối tượng
		      TT giá trị thật sự của đối tượng lưu ở HEAP
		      TT giá trị của biến ở vùng STACK là địa chỉ của ô nhớ HEAP mà nó đang trỏ đến
		        +cap nhat gia gtri trong stack dung toan tu =, toan tu bang hoat dong o vung stack
		        +cap nhat gtri vung nho heap
		      
		    
		     
		 */
		 
		
		// KDL nguyen thuy
		int a1 = 10;
		int a2 = 20;
		int a3 = 30;
		
		a2 = a1;
		a3 = a2;
		a1 = 60;
		a3 = a1;
		
		System.out.println("a1:" + a1);
		System.out.println("a2:" + a2);
		System.out.println("a3:" + a3);
		
		System.out.println("\n");
		
		
		Item i1 = new Item(1, 'A', 11d);
		Item i2 = new Item(2, 'B', 11d);
		Item i3 = new Item(3, 'C', 11d);
		
     	System.out.println("i1: "+ i1);
		System.out.println("i2: "+ i2);
		System.out.println("i3: "+ i3);
		
		System.out.println("\n\n");
		
		// cập nhật salesPrice của i2 thành 44
		i2.salesPrice = 44;  // cập nhật giá trị tại vùng nhớ HEAP
		System.out.println("i2 -->" + i2);
		
		i1 = i3; // cập nhật giá trị, địa chỉ tại vùng nhớ STACK
		System.out.println("i1 -->" + i1);
		System.out.println("i2 -->" + i2);
		System.out.println("i3 -->" + i3);
	}	
}
		
