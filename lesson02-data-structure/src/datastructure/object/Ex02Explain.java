package datastructure.object;

public class Ex02Explain {
	public static void main(String[] args) {
		/*
		 * Khi khai báo biến KDL đối tượng có sẵn như là Integer, Double, String,...
		 * Có 2 cách
		 * - Dùng toán tử new khởi tạo đối tương
		 * - Gán giá trị trực tiếp cho biến (Java sẽ xử lý viêc tạo đối tượng lưu vào)
		 * 
		 * Giống nhau
		 - KDL đối tượng, lưu trữ ở vùng nhớ HEAP
		 - KDL String, biến value là private final --> giá trị của ô nhớ tại HEAP sẽ là hằng số(ko thay đổi)
		 
		 * Khác nhau 
		 - Dùng toán tử new khởi tạo đối tương
		   + Lưu trữ tại 1 ô nhớ bình thường tại vùng nhớ HEAP
		   + Khi khởi tại new, luôn tạo ô nhớ mới tại HEAP
		 * 
		 - Gán giá trị trực tiếp cho biến
		   + Lưu trữ tại HEAP - CONSTANT POOL ( vùng lưu trữ các ô nhớ có giá trị không trùng nhau)
		   + Khi khởi tạo giá trị --> kiểm tra xem giá trị mới đó đã xuất hiện trong constant pool chưa
		     Nếu giá trị đó đã chứa trong 1 ô nhớ ở CONSTANT POOL--> ko khởi tạo ô nhớ mới, dùng ô nhớ cũ gán giá trị qua
		     Nếu chưa tồn tại, tạo ô nhớ mới, và gán địa chỉ cho biến 
		 */
	
		// dùng toán tử new khởi tạo đối tượng
		String o1 = new String("today");
		String o2 = new String("today is a new day");
		String o3 = new String("today");
		System.out.printf("o1 [value=%s] [hash=%s\n", o1, System.identityHashCode(o1));
		System.out.printf("o2 [value=%s] [hash=%s\n", o2, System.identityHashCode(o2));
		System.out.printf("o3 [value=%s] [hash=%s\n", o3, System.identityHashCode(o3));
		
		// Gán giá trị trực tiếp cho biến
		String s1 = "homnay";
		String s2 = "ngaymai";
		String s3 = "homnay";
		String s4 = "homnay";
		System.out.printf("s1 [value=%s] [hash=%s\n", s1, System.identityHashCode(s1));
		System.out.printf("s2 [value=%s] [hash=%s\n", s2, System.identityHashCode(s2));
		System.out.printf("s3 [value=%s] [hash=%s\n", s3, System.identityHashCode(s3));
		System.out.printf("s4 [value=%s] [hash=%s\n", s4, System.identityHashCode(s3));
		
		//Cập nhật s3
		s3 = "ngaykia";
	}

}
