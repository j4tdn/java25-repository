package datastructure.object;
import bean.Store;
public class Ex02ObjectTypeExcercises {
	
	public static void main(String[] args) {
		
		/*
		 *  khởi tạo dữ liệu cho cái cửa hàng gồm:
		 *  - tên cửa hàng là 1 kí tự
		 *	- giờ mở cửa
		 * 	- giờ đóng cửa
		 * 	Tạo ra 3 đối tượng để lưu trữ
		 * - A 7 20
		 * - B 6 23
		 * - C 8 14
		 */
		Store p1= new Store('A',7,20);
		Store p2= new Store('B',6,23);
		Store p3= new Store('C',8,14);
		System.out.println("p1: "+p1);
		System.out.println("p2: "+p2);
		System.out.println("p3: "+p3);
	}
	
	
}
