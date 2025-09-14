package view;

public class Ex04Operator {

	public static void main(String[] args) {
		
		int x =5;
		int y =2;
		int z =4;
		
		x= x+1;
		z= z-y;
		x++;
		++x;
		
		boolean isValid = (x>=z); //true
		System.out.printf("x: %s\n"
				+ "y: %s\n"
				+ "z: %s\n"
				+ "isValid: %s\n", x,y,z,isValid);
		
	System.out.println("\n");
	
	// Toán tử ++ -- có thể đặt ở 2 vị trí prefix, suffix
	// prefix(tiền tố): ++ -- vào biến rồi sử dụng giá trị mới cho biểu thức
	// suffix(hậu tố): sử dụng giá trị hiện tại của biến cho biểu thức xong rồi mới ++ --
	int w1 =y++ - z++; //2-2=0
	int w2 =++y + x++; // 4+8=12
	System.out.printf(
			"w1: %s\n"
			+ "w2: %s\n",w1,w2);
	
	
	
	
	
	}
	
	

}
