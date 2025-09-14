package datastructure.object.available;

public class Ex01ObjectTypeAvailable {

	
	/*
	 * Tồn tại các KDL đối tượng có sẵn như: Integer, Double, BigDecimal - String, Character - Boolean....
	 * - Là 1 class có sẵn: Chỉ có duy nhất 1 thuộc tính (hằng số)
	 * 					  : ngoài việc lưu trữ, hỗ trợ các hàm để xử lý
	 * - Hỗ trợ giá trị NULL lưu trữ các dữ liệu k bắt buộc
	 * 
	 * public class Integer{
	private final int value;
	
	public Integer(int value) {
		this.value =value;
		}
	}
	 * 
	 */
	
	
	
	public static void main(String[] args) {
		// KDL nguyên thủy
		int a1 =5;
		char a2= 'A';
		System.out.printf("a1(%s) a2(%s) \n" ,a1,a2);
		// Khai báo
		Integer b1 = new Integer(7);
		String b2 = new String("Xchao");
		
		System.out.printf("b1(%s) b2(%s) \n" ,b1,b2);
	
		// Khai báo thông qua gán trực tiếp value vào [HOẠT ĐỘNG VỚI KDL ĐỐI TƯỢNG CÓ SẴN CỦA JAVA]
		// Vì tất cả các KDL đối tượng có sẵn của Java: chỉ có duy nhất 1 thuộc tính
		// Khi khai báo, chỉ cần ghi value của thuộc tính đó --> JAVA sẽ tự tạo đối tượng và truyền vào cho 
		Integer c1 =22;
		String c2= "TBiet";
		System.out.printf("c1(%s) c2(%s) \n" ,c1,c2);
		
		// Vì sao ko hoạt động với KDL tự tạo ra -> Vì có thể có 1 or N thuộc tính ko thể gán trực tiếp đc
		// mà phải truyền qua hàm khởi tạo để gán chính xác cho thuộc tính
		
		
		
	}

}
