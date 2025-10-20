package encapsulation.outside;

import static encapsulation.inside.InTest01.*;

import encapsulation.inside.InTest01;

public class OutTest01 extends InTest01 {
	public static void main(String[] args) {
		a2 = 2;
		
		InTest01.a3 = 3;
//		InTest01.a4 = 4;
		
		InTest01.method02();
		InTest01.method03();
//		InTest01.method04();
	}
}
