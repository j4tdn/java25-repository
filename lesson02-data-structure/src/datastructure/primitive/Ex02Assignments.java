package datastructure.primitive;

public class Ex02Assignments {

	public static void main(String[] args) {
		// Format code: Ctrl shift f
		// Xoa nhanh 1 dong: Ctrl d
 		int n1 =11;
 		int n2 =22;
 		int n3 =33;
 		int n4;
 		
 		float f1 = 88.22f;
 		float f2 = 44.66f;
 		
 		//assignments
 		
 		// Gan bien/gia tri cho bien cung KDL
 		n4 = 55; //gan gia tri 55 cho bien n4
 		int n5 = n2; //gan (copy) gia tri bien n2 cho n5
 		n3 = n1; // gan gia tri bien n1 cho n3
 		
 		System.out.println("max int: "+ Integer.MAX_VALUE);
 		System.out.println(
 				"n4: " + n4
 				+ "\nn5: " + n5
 				+ "\nn3: " + n3
 				);
 		
 		//gan bien/gia tri cho bien khac KDL
 		
 		int b1 = 33; // 4 bytes
 		long b2 = 123456789; // 8 bytes
 		long b3 = 7_234_456_123l;
 		
 		// gia tri luu tru cho phep cua b2 lon hon b1, neu b2 mang gia tri lon hon thi KDL cua b1 k the luu tru
 		//==> k dc phep gan bien co KDL lon hon cho KDL nho hon
 		//==> nguoc lai ok
 		
 		b2 = b1;
 		System.out.println("b2: " + b2);
 		System.out.println("b1: " + b1);
 		
 		// f1 = n2 // ok
 		f1 = b3; // float van chua dc gia tri cua long
 		
 		System.out.println("max float: " + Float.MAX_VALUE);
 		System.out.println("max long: " + Long.MAX_VALUE);
 		System.out.println("deviation: " + (Float.MAX_VALUE - Long.MAX_VALUE));
 		
 		System.out.println("f1 --> " + f1);
	}

}
