package view;

import bean.CustomText;
import bean.Item;

public class Ex02FinalKeyword {
	public static void main(String[] args) {
		/* toán tử bằng luôn hoạt động ở stack
		 * 
		 * Biến KDL nguyên thủy
		 *  - biến ở stack
		 *  - giá trị ở stack
		 *  - để cập nhạt giá trị của biến đối tượng
		 *    --> dùng toán tử bằng
		 *  
		 * Biến KDL đối tượng
		 * - biến: stack lưu trữ địa chỉ của ô nhớ tại heap mà biến đang trỏ đến
		 * - giá trị: heap
		 * - để cập nhạt giá trị của biến đối tượng
		 *   --> dùng toán tử bằng để cập nhạt giá trị, đại chỉ tại heap
		 *   --> gọi đến các thuộc tính ở heap và cập nhật
		 *   
		 *   từ khóa final:
		 *    - khi thêm từ khóa final vào cho biến, biến đó trở thành hằng số(stack) nghĩa là
		 *    ko thể cập nhật giá trị của ô nhớ  đó tại satck
		 *    - hằng số ở stack
		 *    
		 *  khái niếm mutable, immutable(áp dụng cho KDL đối tượng)
		 *   -   mutabale: 1 class được gọi là mutable nếu: khi khởi tạo đối tượng từ class - giá trị của các thuộc tính 
		 *   tại vung nhớ heap có thể thay đổi được --> mutable class
		 *   VD: Item, Store
		 *   
		 *   - immutable: 1 class được gọi là immutable nếu: khi khởi tạo đối tượng từ class - giá trị của các thuộc tính 
		 *   tại vung nhớ heap ko thể thay đổi được --> immutable class
		 *   
		 *   Làm sao để 1 class để trở thành immutable(làm sao để thuộc tính của class ko thể thay đổi sau khi tạo ra đối tượng)
		 *    # access modifier: private
		 *    # thêm từ khóa final các thuộc tính
		 *    
		 *    VD: tất cả các KDL đối tượng có sẵn của java như integer, double, string...
		 *        tự tạo ra immutable class
		 */
		
		int a = 5;
		int b = 10;
		a = 8; 
		b = a + 20;
		final int c = 20;
		
		// c = b;
		System.out.println("a:" + a);
		System.out.println("b:" + b);
		System.out.println("c:" + c);
		
		final Item item1 = new Item(1,'A', 22d);
		Item item2 = new Item(2,'B', 33d);
		// cap nhat tai stack
	    // item1 = item2;
		item2 = new Item(2,'Z',66);
		
		// cap nhat tai heap
		// có thẻ cập nhật giá trị của biến final nếu là KDL đối tượng 
		item1.id = 11;
		System.out.println("item1:" + item1);
		System.out.println("item2:" + item2);
		
		
		
		// immutable
		String s1 = "wellcome";
		Double d2 = 22.2d;
		
		CustomText ct1 = new CustomText(s1);
		CustomText ct2 = new CustomText("ZYZ");
		
		System.out.println("ct1 text:" + ct1.getText());
		System.out.println("ct2:" + ct2);
		
		
		
	}

}
