package datastructure.primitive;

public class Ex02Assignments {
	
	public static void main(String[] args) {
		
		int n1 = 11;
		int n2 = 22;
		int n3 = 33;
		int n4;
		
		float f1 = 88.22f;
		float f2 = 44.66f;
		
		
		n4 = 55;
		int n5 = n2;
		n3 = n1;
		
		System.out.println(
				"n4: " + n4
				+ "\nn5: " + n5
				+ "\nn3: " + n3
				
		);
		
		int b1 = 33;
		long b2 = 584375943;
		long b3 = 754545354;
		
		b2 = b1;
		System.out.println("b2 " + b2);
		System.out.println("b1 " + b1);
		
		//f1 = n2;
		f1 = b3;
		f1 = b3; // float vẫn chứa được giá trị của long
		
		
		System.out.println("max float: " + Float.MAX_VALUE);
		System.out.println("max long: " + Float.MAX_VALUE);
		
		System.out.println("f1--> " + f1);
		
		
		
		
	}
	

}
