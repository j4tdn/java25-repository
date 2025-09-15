package controlling;

import java.util.Random;

public class Ex02TernaryOperator {
	public static void main(String[] args) {
		Random rd = new Random();
		int val = rd.nextInt();
		System.out.println("So random: "+val);
		if(val % 2 == 0) {
			System.out.println("So chan");
		}
		else {
			System.out.println("So le");
		}
		System.out.println("[Toan tu ba ngoi] Gia tri random so: "+ ((val%2==0)?"chan":"le"));
		
	}
}
