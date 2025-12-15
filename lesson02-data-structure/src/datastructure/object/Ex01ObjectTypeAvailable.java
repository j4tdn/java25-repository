package datastructure.object;

import bean.Item;

public class Ex01ObjectTypeAvailable {
	
	/*
	 
	 Tồn tại các KDL đối tượng có sẵn như: Integer, Double, Float, BigDecimal - String, Character - Boolean ...
	 - Là 1 class có sẵn: chỉ có duy nhất một thuộc tính(hằng số)
	                    : ngoài việc lưu trữ, hỗ trợ các hàm để xử lý
	 - Hỗ trợ giá trị NULL lưu trữ các dữ liệu không bắt buộc
	 
	 public class Integer {
	 	private final int value;
	 	
	 	public Integer(int value) {
	 		this.value = value;
	 	}
	 }
	 */
	
	public static void main(String[] args) {
		// KDL nguyên thủy
		int a1 = 5;
		char a2 = 'A';
		System.out.printf("a1(%s) a2(%s)", a1, a2);
		
		System.out.println("\n");
		
		// KDL đối tượng
		
		// Khai báo thông qua toán tử new
		Integer b1 = new Integer(7);
		String b2 = new String("Xchao");
		System.out.printf("b1(%s) b2(%s)", b1, b2);
		
		System.out.println("\n");
		
		// Khai báo thông qua gán trực tiếp giá trị vào[HOẠT ĐỘNG VỚI KDL ĐỐI TƯỢNG CÓ SẴN CỦA JAVA]
		// Vì tất cả các KDL đối tượng có sẵn của Java: chỉ có duy nhất một thuộc tính
		// Khi khai báo, chỉ cần ghi giá trị của thuộc tính đó --> JAVA sẽ tự tạo đối tượng và truyền vào cho mình
		Integer c1 = 22;
		String c2 = "TBiet";
		System.out.printf("c1(%s) c2(%s)", c1, c2);
		
		// Vì sao ko hoạt động với KDL tự tạo ra, có thể 1 hoặc N thuộc tính ko thể gán trực tiếp dc
		// mà phải truyền qua hàm khởi tạo để gán chính xác cho thuộc tính
		Item item1 = new Item(1, 'A', 11);
		// Item item2 = 2 'B' 22;
		
	}
	
}