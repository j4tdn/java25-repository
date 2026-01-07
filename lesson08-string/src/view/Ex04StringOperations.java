package view;

public class Ex04StringOperations {
	public static void main(String[] args) {
		String s = "Today, we are studing String library in Java";
		
		// 1. Kiem tra chuoi s1 co phai la chuoi bat dau || ket thuc trong chuoi s khong.
		System.out.println("1. Kiem tra chuoi bat dau, ket thuc: " + s.endsWith("Java"));
		
		// 2. Thay the chuoi s1 bang chuoi S2 trong chuoi S
		s = s.replace("String", "DateTime");
		System.out.println("2. Thay the chuoi: " + s);
		
		// 3. loai bo cac khoang trang thua cua chuoi s3
		s = s.strip().replaceAll("\\s+", " ");
		System.out.println("3. Loai bo khoang trang thua: |" + s + "|");
		
		// 4. Tao chuoi con chua chuoi s bat dau tu vi tri so 2
		System.out.println("4. Tao chuoi con: " + s.substring(2));
		
		// 5. xac ding chuoi s2 co ton tai trong chuoi s1 hay khong
		System.out.println("5. xac dinh ton tai: " +s.contains("is"));
	}

}
