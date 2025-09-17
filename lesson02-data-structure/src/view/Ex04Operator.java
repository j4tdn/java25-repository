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
		
		System.out.printf("x: %s\n " 
		+ "y: %s\n " + "z: %s\n " 
				+ "isva: %s\n", x, y, z, isValid);
		
		System.out.println("\n");
		
		//Toán tử ++ -- có thể đặt 
		
		int w1 = y++ - z++; // 2 -2 =0;
		
		int w2 = ++y + x++; // 4 + 8 = 12;
		
		
		System.out.printf("w1: %s\n " +  "w2: %s\n", w1, w2);
		
		
		x = 5;
		y =2;
		z= 3;
		
		y += x++ + z++ + ++z + ++x - y-- + z;
		
		System.out.printf("x: %s\n " 
				+ "y: %s\n " + "z: %s\n " , x, y, z);
		
		x -= y++ + --y + (z+=2) + x--;
		System.out.printf("x: %s\n " 
				+ "y: %s\n " + "z: %s\n " , x, y, z);
		
		
	}
	
}
