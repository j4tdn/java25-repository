package view;

public class Ex04Operator {
	public static void main(String[] args) {
		
		int x = 5;
		int y = 2;
		int z = 4;
		
		x = x + 1;
		z = z - y;
		x ++;
		++ x;
		
		
		boolean isValid = (x >= z);
		
		System.out.println(isValid);
		
		System.out.println("\n");
		
		// toán tử ++ -- có thể đặt ở 2 vị trí prefix, suffix
		// prefix(tiền tố): ++ -- vào biến rồi sử dụng giá trị mới cho biểu thức
		// suffix(hậu tố): sử dụng giá trị hiện tại của biến cho biểu thức xong rồi mới ++ --
		int w1 = y++ - z++;
		int w2 = ++y + x++;
		
		System.out.println(w1);
		System.out.println(w2);
		
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
