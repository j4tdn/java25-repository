package encapsulation.inside;

import java.lang.reflect.Method;
import static encapsulation.inside.InTest01.*;

public class InTest02 {
	public static void main(String[] args) {
		InTest01.a2 = 3;
		InTest01.a3 = 4;
		InTest01.a4 = 5;
		
		InTest01.method02();
		InTest01.method03();
		InTest01.method04();
		
		
		}
}
