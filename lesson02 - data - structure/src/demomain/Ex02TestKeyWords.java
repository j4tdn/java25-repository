package demomain;

public class Ex02TestKeyWords {
	public static void main(String[] args) {
		Ex01TestMainMethod.sum();
		// Để gọi 1 hàm non-static, thì từ class phải tạo ra 1 đối tượng
		// Từ "đối tượng" đó gọi hàm
		// VD o1
		Ex01TestMainMethod o1 = new Ex01TestMainMethod();
		o1.mul();
	}
}
