package view;

public class Ex07OperatorDemo {
	
	public static void main(String[] args) {
		
		// Toan tu logic && ||
		// Toan tu bit & |
		
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
		if(++i > 2 && i++ > 2) {
			i++;
		}
		
		if(i++ > 4 || ++i > 5) {
			System.out.println(i);
		}
		
		if(i++ < 4 || ++i > 5) {
			System.out.println(i);
		}
	}
}
	



