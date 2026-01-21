package view;

public class Ex04StringOperation {
	public static void main(String[] args) {
		String s = "   today, we are studing String library in java    ";
		/*
		 * • Kiểm tra chuỗi s1 có phải là chuỗi bắt đầu || kết thúc trong chuỗi s không.
           • Thay thế chuỗi s1 bằng chuỗi s2 trong chuỗi s
           • Loại bỏ các khoảng trắng thừa của chuỗi s3
           • Tạo chuỗi con của chuỗi s bắt đầu từ vị trí số 2
           • Xác định chuỗi s2 có tồn tại trong chuỗi s1 hay không
		 */
		
		System.out.println("1. Kiểm tra chuỗi s1 có phải là chuỗi bắt đầu || kết thúc trong chuỗi s không: \n" + s.endsWith("java"));
		System.out.println("\n=======================\n");
		
		s = s.replace("String", "Datetime");
		System.out.println("Thay thế chuỗi s1 bằng chuỗi s2 trong chuỗi s: \n" + s );
		System.out.println("\n=======================\n");

		System.out.println("3. Loại bỏ các khoảng trắng thừa của chuỗi s3:\n |" + s.strip().replaceAll("\\s+", " ") + "|" );
		
		System.out.println("\n=======================\n");

		System.out.println("4. Tạo chuỗi con của chuỗi s bắt đầu từ vị trí số 2: \n" + s.substring(0));
		
		System.out.println("\n=======================\n");
		
		System.out.println("5. Xác định chuỗi s2 có tồn tại trong chuỗi s1 hay không: \n"  + s.contains("is"));
		
		System.out.println("\n======================\n");
		
		String s1 = "hello";
		String s2 = new String("hello").intern();
		
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));

		
		

	}

}
