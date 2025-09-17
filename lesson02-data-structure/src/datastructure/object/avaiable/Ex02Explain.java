package datastructure.object.avaiable;

public class Ex02Explain {
	public static void main(String[] args) {
		/*
		 * Khi khai báo biển KDL đối tượng có sẵn như là Integer, Double, String

			Có 2 cách			
				-Dùng toản từ new khởi tạo đối tượng			
				-Gán giá trị trực tiếp cho biến (Java sẽ xử lý việc tạo đối tượng lưu vào)
			
			Giống nhau			
				KDL đối tượng, lưu trữ ở vùng nhớ HEAP			
				KDL String, biến value là private final --> giá trị của ô nhớ tại HEAP là hàng số (ko thay đổi)
			
			Khác nhau			
				Dùng toán từ new khởi tạo đối tượng		
					Lưu trữ tại 1 ô nhớ bình thường tại vùng nhớ HEAP			
					Khi khởi tạo với new -> luôn tạo ô nhớ mới tại HEAP			
				Gán giá trị trực tiếp cho biến *			
					Lưu trữ tại HEAP CONSTANT POOL (vùng lưu trữ các ô nhớ có giá trị ko trùng nhau)			
					Khi khởi tại giá trị --> kiểm tra xem giá trị mới đó đã xuất hiện trong constant pool chưa 
						Nếu giá trị đó đã chứa trong 1 ô nhớ ở CONSTANT POOL -> ko khởi tạo ô nhớ mới, dùng ô nhớ cũ gán
		
		 * */
		
		
		
		
		//dung toan tu new khoi tao doi tuong
		String o1 = new String("Today");
		String o2 = new String("Today is a new day");
		String o3 = new String("Today");
		System.out.printf("o1 [Value = %s] [hash = %s] \n ", o1, System.identityHashCode(o1));
		System.out.printf("o2 [Value = %s] [hash = %s] \n ", o2, System.identityHashCode(o2));
		System.out.printf("o3 [Value = %s] [hash = %s] \n ", o3, System.identityHashCode(o3));
		
		System.out.println("\n");
		//gan gtri truc tiep cho bien
		String s1 = "homnay";
		String s2 = "ngaymai";
		String s3 = "homnay";
		System.out.printf("s1 [Value = %s] [hash = %s] \n ", s1, System.identityHashCode(s1));
		System.out.printf("s2 [Value = %s] [hash = %s] \n ", s2, System.identityHashCode(s2));
		System.out.printf("s3 [Value = %s] [hash = %s] \n ", s3, System.identityHashCode(s3));
	}
}
