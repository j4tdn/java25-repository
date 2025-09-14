package demomain;

public class Ex02TestKeywords {
	public static void main(String[] args) {
		Ex01TestMainMethod.sum();
//		Ex01TestMainMethod.sub();
		Ex01TestMainMethod o1 = new Ex01TestMainMethod();
		o1.mul();
		new Ex01TestMainMethod().mul();
	}
}
