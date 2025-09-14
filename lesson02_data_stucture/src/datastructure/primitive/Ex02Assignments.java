package datastructure.primitive;


public class Ex02Assignments {
	// format code: ctrl shift f
	// xoa nhanh 1~n dong: ctrl d
	
	public static void main(String[] args) {
		
		int n1 = 11;
		int n2 = 22;
		int n3 = 33;
		int n4;
		
		float f1 = 88.22f;
		float f2 = 44.66f;
		
		// assignments
		
		// gán biến/giá trị cho biến cùng KDL
		n4 = 55;  // gán giá trị 55 cho n4
		int n5 = n2; // gán giá trị biến n2 cho biến n5
		n3 = n1; 
		
		System.out.println("max int:" + Integer.MAX_VALUE);
		System.out.println(""
				+ "n4:" + n4 + "\nn5:" + n5
				+ "\nn3:" + n3);
		
		// gán biến/giá trị cho biến khác KDL
		
		int b1 = 33;  // 4 byte
		long b2 = 578427365l;   // 8 byte
		long b3 = 7555333224l;
		
		
		// giá trị lưu trữ cho phép của b2 lớn hơn b1, nếu b2 mang giá trị lớn hơn KDL của b1 ko thể
		// không được phép gán biến có kiểu dữ liệu lớn hơn cho kiểu dữ liệu nhỏ hơn, ngược lại thì ok
		
		b2 = b1;
		System.out.println("b2:"+b2);
		System.out.println("b1:"+b1);
		
		f1 = n2; //ok
		f1 = b3;  // float van chua duoc gia tri cua long
		
		System.out.println("max float:" + Float.MAX_VALUE);
		System.out.println("max long:" + Long.MAX_VALUE);
		System.out.println("deviation: "+ (Float.MAX_VALUE - Long.MAX_VALUE));
		
		System.out.println("f1 --> "+ f1);
	
	}

}
