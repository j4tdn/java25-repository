package demomain;

public class Ex02TestKeyWord {
	
	public static void main(String[] args) {
		
		Ex01TestMainMethod.sum();
		//Ex01TestMainMethod.sub();
		
		// Để gọi 1 hàm non-static, thì từ class phải tạo ra một đối tượng
		// Từ đối tượng đó gọi hàm
		// VD o1
		
		new Ex01TestMainMethod().mul();
		
		//Ex01TestMainMethod o1 = new Ex01TestMainMethod();
		//o1.mul();
	}
}