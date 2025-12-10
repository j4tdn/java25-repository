package view;

public class Ex04Operator {
	public static void main(String[] args) {
		int x = 5;
		int y = 2;
		int z = 4;
		
		x = x + 1;
		z = z - y;
		x++;
		++x;
		
		boolean isValid = (x >= z);
		
		System.out.printf(
				"x: %s\n"
				+ "y: %s\n"
				+ "z: %s\n"
				+ "isValid: %s\n", x, y, z, isValid
		);
		
		
//		System.out.println("\n");
//		
//		int w1 = y++ - z--;
//		int w2 = ++y + x++;
//		
//		System.out.printf(
//				"w1: %s\n"
//				+ "w2: %s\n", w1, w2
//				);
//	
		x = 5;
		y = 2;
		z = 3;
		
		
		y += x++ + z++ + ++z + ++x - y-- + z;
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		
		
		x -= y++ + --y + (z+=2) + x--;
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
	}
	
	

}
