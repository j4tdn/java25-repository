package datastructure.object.available;

public class Ex02Explain {
	public static void main(String[] args) {
		/*
		 * Khác nhau - Dùng toán tử new khởi tạo đối tượng Luôn tạo tại 1 ô nhớ bình
		 * thường tại vùng nhớ HEAP Nếu đã tồn tại giá trị đó --> vẫn tạo ô nhớ mới tại
		 * HEAP
		 * 
		 * - Gán giá trị trực tiếp cho biến Lưu trữ tại HEAP - CONSTANT POOL (vùng lưu
		 * trữ các ô nhớ có giá trị ko trùng nhau) Khi khởi tạo giá trị --> kiểm tra xem
		 * giá trị mới đó đã xuất hiện trong constant pool chưa + Nếu giá trị đó đã chứa
		 * trong 1 ô nhớ ở CONSTANT POOL -> ko khởi tạo ô nhớ mới, dùng ô nhớ cũ gán +
		 * Nếu chưa tồn tại --> tạo ô nhớ mới và gán địa chỉ cho biến
		 * 
		 * - Khi sử dụng KDL có sẵn của Java --> 100% khi gán dùng cách gán trực tiếp
		 * --> Tiết kiệm vùng nhớ
		 */

		// Dùng toán tử new khởi tạo đối tượng
		String o1 = new String("today");
		String o2 = new String("today is a new day");
		String o3 = new String("today");

		System.out.printf("o1 [value=%s] [hash=%s]\n", o1, System.identityHashCode(o1));
		System.out.printf("o2 [value=%s] [hash=%s]\n", o2, System.identityHashCode(o2));
		System.out.printf("o3 [value=%s] [hash=%s]\n", o3, System.identityHashCode(o3));

		System.out.println("\n");

		// Gán giá trị trực tiếp cho biến
		String s1 = "homnay";
		String s2 = "ngaymai";
		String s3 = "homnay";
		String s4 = "homnay";

		System.out.printf("s1 [value=%s] [hash=%s]\n", s1, System.identityHashCode(s1));
		System.out.printf("s2 [value=%s] [hash=%s]\n", s2, System.identityHashCode(s2));
		System.out.printf("s3 [value=%s] [hash=%s]\n", s3, System.identityHashCode(s3));
		System.out.printf("s4 [value=%s] [hash=%s]\n", s4, System.identityHashCode(s4));

		System.out.println("\n");

		// Cập nhật s3
		s3 = "ngaykia";
		System.out.printf("s1 [value=%s] [hash=%s]\n", s1, System.identityHashCode(s1));
		System.out.printf("s2 [value=%s] [hash=%s]\n", s2, System.identityHashCode(s2));
		System.out.printf("s3 [value=%s] [hash=%s]\n", s3, System.identityHashCode(s3));
		System.out.printf("s4 [value=%s] [hash=%s]\n", s4, System.identityHashCode(s4));

	}
}
