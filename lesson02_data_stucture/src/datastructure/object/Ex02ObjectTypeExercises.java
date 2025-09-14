package datastructure.object;

import bean.Store;

public class Ex02ObjectTypeExercises {
	public static void main(String[] args) {
		/*
		 *  khởi tạo dữ liệu cho cửa hàng gồm
		 *   - tên cửa hàng là 1 kí tự
		 *   - giờ mở cửa
		 *   - giờ đóng cửa
		 *   
		 *  tạo ra 3 đối tượng để lưu trữ
		 *  - A 7 20
		 *  - B 6 23
		 *  - C 8 14 
		 */
		Store s1 = new Store('A', 7, 20);
		Store s2 = new Store('B', 6, 23);
		Store s3 = new Store('C', 8, 14);
		
		System.out.println("s1: "+ s1);
		System.out.println("s2: "+ s2);
		System.out.println("s3: "+ s3);
	}

}
