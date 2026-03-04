package view;

public class Ex04StringOperations {
	
	public static void main(String[] args) {
		String s = "  Today, we     are studing     String library in Java   ";
		
		// 1. Kiểm tra chuỗi s1 có phải là chuỗi bắt đầu || kết thúc trong chuỗi s không.
		System.out.println("1. Kiểm tra chuỗi bắt đầu, kết thúc: " + s.endsWith("Java"));
		
		// 2. Thay thế chuỗi s1 bằng chuỗi s2 trong  chuỗi s
		s = s.replace("String", "DateTime");
		System.out.println("2. Thay thế chuỗi: " + s);
		
		// 3. Loại bỏ các khoảng trắng thừa của chuỗi s3
		s = s.strip().replaceAll("\\s+", " ");
		System.out.println("3. Loại bỏ khoảng trắng thừa: |" + s + "|");
		
		// 4. Tạo chuỗi con của chuỗi s bắt đầu từ vị trí số 2
		System.out.println("4. Tạo chuỗi con: " + s.substring(2));
		
		// 5. Xác định chuỗi s2 có tồn tại trong chuỗi s1 hay không
		System.out.println("5. Xác định tồn tại: " + s.contains("is"));
		
		System.out.println("\n========================================\n");
		
		String s1 = "hello"; // heap -> constant pool
		String s2 = new String("hello").intern(); // -> heap -> constant pool
		
		System.out.println("s1 --> " + System.identityHashCode(s1));
		System.out.println("s2 --> " + System.identityHashCode(s2));
	}
	
}