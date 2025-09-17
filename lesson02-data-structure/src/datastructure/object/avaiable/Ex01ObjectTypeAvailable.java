package datastructure.object.avaiable;

import bean.Item;

public class Ex01ObjectTypeAvailable {
	/*
	 * Ton tai cac KDL doi tuong co san nhu: Integer, 
	 * 
	 * 
	 * 
	 * */
	
	public static void main(String[] args) {
		//KDL nguyen thuy
		int a1 = 5;
		char a2 = 'A';
		System.out.printf("a1(%/s) a2(%/s)", a1, a2);
		
		System.out.println("\n");
		
		//KDL doi tuong
		
		//Khai bao thong qua toan tu sau
		Integer b1 = new Integer(7);
		String b2 = new String("Xchao");
		System.out.printf("b1(%/s) b2(%/s)", b1, b2);
		
		System.out.println("\n");
		
		
		// Khai báo thông qua gắn trực tiếp giá trị vào HOẠT ĐỘNG VỚI KDL ĐỐI TƯỢNG CÓ SẴN CỦA JAVA] 
		// Vì tất cả các KDL đối tượng có sẵn của Java: chỉ có duy nhất một thuộc tính
		// Khi khai báo, chỉ cần ghi giá trị của thuộc tính đô JAVA sẽ tự tạo đối tương và truyên vào cho
		Integer c1 = 22;
		String c2 = "Tbiet";
		System.out.printf("c1(%/s) c2(%/s)", c1, c2);
		
		// Vì sao ko hoạt động với KOL tự tạo ra, có thể 1 hoặc N thuộc tính ko thể gán tưve tiếp duoc 
		// mà phải truyên qua hàn khởi tạo để gân chính xác cho thuộc tính
		Item item1 = new Item(1, 'A', 11);
		
		
		
	}
}
