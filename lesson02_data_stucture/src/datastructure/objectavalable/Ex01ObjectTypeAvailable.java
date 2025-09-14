package datastructure.objectavalable;

import bean.Store;

public class Ex01ObjectTypeAvailable {
	/*
	 * Tồn tại các KDL đối tượng có sẵn như Interger, Double, Float, BigDecimal - String, Character - Boolean
	 * - là 1 class có sẵn, chỉ có duy nhất một thuộc tính, hằng số
	 *                    , ngoài việc lưu trữ, hỗ trợ các hàm để xử lý
	 * - hỗ trợ giá trị null để lưu trữ các biến, dữ liệu mà ko bắc buộc
	 * 
	 * public class Integer {
	 *     private final int value;
	 *     
	 *     public Integer(int value) {
	 *          this.value = value;     
	 *  }   
	 * }
	 */
	
	
	public static void main(String[] args) {
		// KDL nguyên thủy
		int a1 = 5;
		char a2 = 'A';
		System.out.printf("a1(%s) a2(%s)", a1, a2);
		
		System.out.println("\n\n");
		
		// khai bao thong qua toan tu new
		Integer b1 = new Integer(7);
		String b2 = new String("xchao");
		
		System.out.printf("b1(%s) b2(%s)", b1, b2);
		
		System.out.println("\n\n");
		
		//  khai báo thông qua gán trực tiếp giá trị vào[HOẠT ĐỘNG VỚI KDL ĐỐI TƯỢNG CÓ SẴN CỦA JAVA]
		// vi tất cả các KDL đối tượng có sẵn của java: chỉ có duy nhất một thuộc tính
		// khi khai báo, chỉ cần ghi giá trị của thuộc tính đó --> java sẽ tự tạo đối tượng và truyền vào cho
		Integer c1 = 22;
		String c2 = "TBiet";
		System.out.printf("c1(%s) c2(%s)\n", c1, c2);
		
		
		

		// vì sao ko hoạt đông với KDL tự tạo ra, có thể có 1 hoặc N thuộc tính ko thể gán trực tiếp dc
		// mà phải truyền qua hàm khởi tạo để gán chính xác cho thuộc tính
		// Item item1 = new Item(1, 'A', 11);
		// Item item2 = 2 'B' 22;
	}

}
