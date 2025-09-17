package demomain;

public class Ex02TestKeyWords {
	public static void main(String[] args) {
		Ex01TestMainMethod.sum();
//		Ex01TestMainMethod.sub();
		
		// Để gọi 1 hàm non-static, thì từ class phải tạo ra 1 đối tượng
		Ex01TestMainMethod o1 = new Ex01TestMainMethod();
		o1.mul();
		// Hoặc như này cũng được
		new Ex01TestMainMethod().mul();
		
		
	}
}
