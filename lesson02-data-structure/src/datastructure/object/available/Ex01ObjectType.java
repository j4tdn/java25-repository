package datastructure.object.available;

public class Ex01ObjectType {

	/*
	 * 
	 * Tồn tại các KDL object có sẵn như: Integer, Double, Float, BigDecimal ...
	 * 	Là 1 class có sẵn: Chỉ có duy nhất 1 thuộc tính(hằng số)
	 * 					 : ngoài việc lưu trữ, còn hỗ trợ method để xử lý
	 * 	Hỗ trợ giá trị NULL để lưu trữ các dữ liệu mà ko bắt buộc
	 * 	
	 * public class Integer {
	 * 	
	 * 	private final int value;
	 * 
	 * 	public Integer(int value) {
	 * 		this.value = value;
	 * 	}
	 * 
	 * }
	 * 
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
		String b2 = new String("XChao");	
		System.out.printf("b1(%s) b2(%s)", b1, b2);
		
		System.out.println("\n");
		
		// Khai báo thông qua gán trực tiếp giá trị vào 
		// 	[HOẠT ĐỘNG VỚI KDL OBJECT CÓ SẴN CỦA JAVA]
		// Vì tất cả các KDL OBJECT của JAVA: chỉ có 1 thuộc tính
		// Khi khai báo chỉ cần ghi giá trị --> JAVA sẽ tự động tạo OBJECT và truyền giá trị vào cho thuộc tính
		Integer c1 = 22;
		String c2 = "TBiet";
		System.out.printf("c1(%s) c2(%s)", c1, c2);
		
	}
	
}
