package view;

public class Ex04Operator {
	public static void main(String[] args) {
		int x = 5;
		int y = 2; 
		int z = 4;
		
		x = x + 1;
		z = z - y;
		x++; // x = x + 1
		++x; // x = x +1
		
		boolean isValid = (x >= z);
		
		System.out.printf(""
				+ "x: %s\n"
				+ "y: %s\n"
				+ "z: %s\n"
				+ "isValid: %s\n", x, y, z, isValid);
		
		System.out.println("\n");
		
		// Toan tu ++ -- co the dat o 2 vi tri prefix, suffix
		// prefix(tien to): ++ -- vao bien roi su dung gia  tri moi cho bieu thuc
		// suffix(hau to): su dung gia tri hienj tai cua bien cho bieu thuc roi moi ++ --
		
		int w1 = y++ - z++;
		int w2 = ++y + x++;
		
		System.out.printf(""
				+ "x: %s\n"
				+ "y: %s\n"
				+ "z: %s\n"
				+ "isValid: %s\n", x, y++, --z, isValid);
		
		x = 5; // 7
		y = 2; // 25
		z = 3; // 5
		y += x++ + z++ + ++z + ++x - y-- + z; //25
		
		System.out.printf(""
				+ "x: %s\n"
				+ "y: %s\n"
				+ "z: %s\n"
				, x, y, z);
		
		x -= y++ + --y + (z +=2) + x--; // 7 - (25 + 25 + 7 + 7)
		System.out.printf(""
				+ "x: %s\n"
				+ "y: %s\n"
				+ "z: %s\n"
				, x, y, z);
	}
}
