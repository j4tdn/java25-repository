package encapsulation.inside;
import static encapsulation.inside.InTest01.*;
public class InTest02 {
	public static void main(String[] args) {
		
		InTest01.a2 = 2;
		InTest01.a3 = 3;
		InTest01.a4 = 4;
		
		InTest01.method02();
		InTest01.method03();
		InTest01.method04();
	}
}
