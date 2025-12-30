package view;

public class Ex04StringOperation {
	public static void main(String[] args) {
		String s= "   Today, we Studing String labrary in java               ";
		// 1. Kiểm tra chuỗi s có phải là chuỗi bắt đầu || kết thúc trong chuỗi s không.
		System.out.println("1.ktra chuỗi bắt đầu, kết thúc: " + s.endsWith(s));
		
		// 2. Thay thế chuỗi s1 bằng chuỗi sẽ trong chuỗi s
		s = s.replace("String", "DateTime");
		System.out.println("2. Thay thế chuỗi: " + s);
		
		// 3. Loại bỏ các khoảng trắng thừa của chuỗi s
		s = s.strip();
		System.out.println("3. Loại bỏ khoảng trắng thừa: |" + s + "|");
				
		// 4. Tạo chuỗi con của chuỗi s bắt đầu từ vị trí số 2
		System.out.println("4. Tạo chuỗi con: " + s.substring(2));
		
		// 5. Xác định chuỗi sẽ có tồn tại trong chuỗi s hay không
		System.out.println("5. Xác định tồn tại: " + s.contains("is"));
	}
}
