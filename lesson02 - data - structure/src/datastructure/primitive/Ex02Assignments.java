package datastructure.primitive;

public class Ex02Assignments {
	
	// format code: ctrl + shift + f
	// xóa nhanh 1/N dòng: ctrl d
	
	public static void main(String[] args) {
		int n1= 11;
		int n2= 22;
		int n3= 33;
		int n4; 
		
		float f1= 88.22f;
		float f2= 44.66f;
		// assignment
		n4 = 55;
		int n5 = n2; // gán giá trị n2 cho n5
		n3 =n1;
		System.out.println("Max int: "+ Integer.MAX_VALUE);
		System.out.println(
				 "n4: " + n4 
				+ "\nn5: " + n5
				+ "\nn3: " + n3
				);
		int b1= 33;
		long b2= 752324324324l;
		long b3= 493249032094l;
		//b1 = (int) b2;
		//System.out.println("b1 --> " + b1);
		// giá trị lưu trữ cho phép của b2 lớn hơn b1, nếu b2 mang giá trị lớn hơn thì KDL của b1 ko thể lưu trữ 
		// ==> k được phép gán biến có KDL lớn hơn cho KDL nhỏ hơn
		// ==> ngược lại: ok
		
		b2=b1;
		System.out.println("b2: "+ b2);
		System.out.println("b1: "+ b1);
		
		f1= n2;//ok
		f1 = b3;
		System.out.println("Max float: "+ Float.MAX_VALUE);
		System.out.println("Max long: "+ Long.MAX_VALUE);
		System.out.println("Max float + Max long: "+ Float.MAX_VALUE + Long.MAX_VALUE);
		System.out.println("f1: "+ f1);
		// ít byte hơn chưa chắc đã k chứa được giá trị (Float: 4bytes, Long: 8bytes)
	}
}

