package view;

public class Ex04Operator {
	public static void main(String[] args) {
		int x = 5;
		int y = 2;
		int z = 4;
		x = x + 1;// x=6;y=2;z=2
		z = z - y;
		x++;
		++x;// x=8;y=2;z=2
		boolean isValid = (x >= z);
		System.out.printf("x: %s\n" + "y:%s\n" + "z:%s\n" + "%s\n", x, y, z, isValid);
		int w1 = x++ + ++x; // 8+ 10
		int w2 = --z + --y;// 1+1
		int w3 = ++y - ++x;// 2-11
		System.out.println(w1);// 18
		System.out.println(w2);// 2
		System.out.println(w3);// -9
	}
}
