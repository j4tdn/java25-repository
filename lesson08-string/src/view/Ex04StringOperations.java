package view;

public class Ex04StringOperations {
	
	public static void main(String[] args) {
		String s = "Today, we are studying String libraries in Java   ";
		
		// 1. Kiem tra chuoi s1 co phai la chuoi bat dau || ket thuc trong chuoi s khong
		System.out.println(s.startsWith("To") +" " + s.endsWith("Java"));
		
		// 2. Thay the chuoi s1 bang chuoi s2 trong chuoi s
		s = s.replace("String", "DateTime");
		System.out.println(s);
		
		// 3. Loai bo khoang trang thua cua chuoi s3
		s = s.strip();
		System.out.println("|" + s +"|");
		
		// 4. Tao chuoi con cua chuoi s bat dau tu vi tri so 2
		System.out.println(s.substring(2));
		
		// 5. Xac dinh chuoi s2 co ton tai trong chuoi s1 hay khong
		System.out.println(s.contains("is"));
	}

}
