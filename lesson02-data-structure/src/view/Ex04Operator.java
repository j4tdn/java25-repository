package view;

public class Ex04Operator {

	public static void main(String[] args) {
		int x = 5;
		int y = 2;
		int z = 4;

		x = x + 1;
		z = z - y;
		x++;

		boolean isValid = (x >= z);

		System.out.println(x);
	}

}
