package view;

public class Ex07OperatorDemo {
	public static void main(String[] args) {
		test01();
		test02();
		
	}
	
	private static void test02() {
		int x = 0;
		int y = 0;
		for(int z = 0; z < 5; z++) {
			if((++x > 2) && (++y > 2)) {
				x++;
			}
		}
		System.out.println(x + " " + y);
	}
	
	private static void test01() {
		int i = 2;
		if(++i > 2 & i++ > 2) { // 3 4
			i++; // 5
		}
		if(i++ > 4 && ++i > 5) { //6 7
			System.out.println(i); // 7
		}
		if(i++ < 4 | ++i > 5) { // 8 9
			System.out.println(i); //9
		}
	}
}
