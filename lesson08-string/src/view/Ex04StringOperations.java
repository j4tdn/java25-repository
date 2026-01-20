package view;

public class Ex04StringOperations {

	public static void main(String[] args) {
		
		String s = "   Today, we   are studing  String   library in Java   ";
		
		System.out.println("1. Kiem tra chuoi bat dau, ket thuc: " + s.endsWith("Java"));
		
		s = s.replace("String", "DateTime");
		System.out.println("2. Thay the chuoi: " + s);
		
		s = s.strip().replaceAll("\\s+", " ");
		System.out.println("3. Loai bo cac khoang trang thua trong chuoi: |" + s + "|");
		
		String s1 = s.substring(2);
		System.out.println("4. Tao chuoi con tu vi tri 2: " + s1);
		
		System.out.println("5. Xac dinh ton tai: " + s.contains("are"));
	}
	
}
