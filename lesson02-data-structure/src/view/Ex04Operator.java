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
			+ "isValid: %s\n",x,y,z,isValid
		);
		
		// Toán tử ++ -- có thể đặt ở 2 vị trí prefix, suffix
		// prefix(tiền tố): ++ -- vào biến rồi sử dụng giá trị mới cho biểu thức
		// suffix(tiền tố): sử dụng giá trị hiện tại rồi mới ++ --
		
		System.out.println("\n");
		
		int w1 = y++ - z++;
		int w2 = ++y + x++;
		
		
		
	}
	
}
