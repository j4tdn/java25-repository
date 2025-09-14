package datastructure.objectavalable;

public class Ex02Explain {
	public static void main(String[] args) {
		/*
		 * khi khai báo biến KDL đối tượng có sẵn như là Integer, double
		 * có 2 cách
		 *  - dùng toán tử new khởi tạo đối tượng
		 *  - gán giá trị trực tiếp cho biến, java sẽ xử lý việc tạo đối tượng luw vào
		 *  
		 *  giống nhau
		 *  - KDL dối tượng, lưu trữ tại vung nhớ heap
		 *  - KDL String, biến value là private final --> giá trị của ô nhớ tại HEAP là hằng số, ko thay đỏi
		 *  
		 *  
		 *  khác nhau
		 *  dùng toán tử new khởi tạo đối tượng
		 *  - lưu trữ tại 1 ô nhớ bình thường tại vùng nhớ HEAP
		 *  - khi khởi tạo với new thì luôn tạo ô nhớ mới tại HEAP
		 *  
		 *  gán giá trị trực tiếp cho biến
		 *  - lưu trữ tại HEAP - CÓNTANT POOL: vùng lưu trữ các ô nhớ có giá trị ko trùng nhau
		 *  - khi khởi tạo giá trị thì nó sẽ kiểm tra giá trị mới đó đã xuất hiện trong CÓNTANT POOL chưa
		 *    . nếu giá trị đó đã chứa trog một ô nho ở CÓNTANT POOL thì ko khởi tạo ô nhớ mới, dùng ô nhớ cũ gán địa qua
		 *    . nếu chưa tồn tại thì tạo ô nhớ mới và gán địa chỉ cho biến
		 *    
		 * -- khi sử dụng KDL có sẵn của java --> 100% khi gán dùng cách gán trực tiếp
		 * -- tiết kiệm vùng nhớ
		 */
		// dùng toán tử new khởi tạo đối tượng * ko nen dung
		String o1 = new String("today");
		String o2 = new String("today is a new day");
		String o3 = new String("today");
		System.out.printf("01 [value=%s] [hash=%s]\n", o1, System.identityHashCode(01));
		System.out.printf("02 [value=%s] [hash=%s]\n", o2, System.identityHashCode(02));
		System.out.printf("03 [value=%s] [hash=%s]\n", o3, System.identityHashCode(03));
		
		System.out.println("\n\n");
		
		
		
		// gán giá trị trực tiếp cho biến
		String s1 = "homnay";
		String s2 = "ngaymai";
		String s3 = "homnay";
		String s4 = "homnay";
		System.out.printf("s1 [value=%s] [hash=%s]\n", s1, System.identityHashCode(01));
		System.out.printf("s2 [value=%s] [hash=%s]\n", s2, System.identityHashCode(02));
		System.out.printf("s3 [value=%s] [hash=%s]\n", s3, System.identityHashCode(03));
		System.out.printf("s4 [value=%s] [hash=%s]\n", s4, System.identityHashCode(04));
		
		System.out.println("\n\n");
		s3 = "ngaykia";
		System.out.printf("s1 [value=%s] [hash=%s]\n", s1, System.identityHashCode(01));
		System.out.printf("s2 [value=%s] [hash=%s]\n", s2, System.identityHashCode(02));
		System.out.printf("s3 [value=%s] [hash=%s]\n", s3, System.identityHashCode(03));
		System.out.printf("s4 [value=%s] [hash=%s]\n", s4, System.identityHashCode(04));
		
	}

}
