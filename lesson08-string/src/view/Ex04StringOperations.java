package view;

public class Ex04StringOperations {

	public static void main(String[] args) {
		
		String s = " Today, we are studying String libary in JAVA ";
		// 1. Kiểm tra chuỗi s1 có phải là chuỗi bắt đầu || kết thúc trong chuỗi s không.
		System.out.println("1. Kiếm tra chuỗi bắt đầu --> " + s.endsWith("JAVA"));
		// 2. Thay thế chuỗi s1 bằng chuỗi s2 trong chuỗi s
		s = s.replace("String", "Datetime");
		System.out.println("2. Thay thế chuỗi --> " + s);
		// 3. Loại bỏ các khoảng trắng thừa của chuỗi s3
		s = s.strip();
		System.out.println("3. Loại bỏ các khoảng trắng thừa --> " + s);
		// 4. Tạo chuỗi con của chuỗi s bắt đầu từ vị trí số 2
		System.out.println("Chuỗi con của chuỗi s bắt đầu từ vị trí số 2 --> " + s.substring(2));
		// 5. Xác định chuỗi sẽ có tồn tại trong chuỗi s1 hay không
		
	}
	
}
