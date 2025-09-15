package demomain;

public class Ex01TestMainMethod {
	// Nơi bắt đầu và kết thúc của một chương trình
	public static void main(String[] args) {
		System.out.println("Main: Test the real one");

		System.out.println("-----");

		System.out.println("Kết quả là: " + Ex02TestKeyWords.mul(5, 2));
		;// cái này dành cho những hàm có static từ class khác.
		sub();// Cái này dành cho những hàm có static trong class này, gọi trực tiếp.
	}

	// Khai báo ra một method hàm tên là main, trả về void và không có tham số
	/*
	 * Nếu gọi hàm static ở bên trong class chứa nó, thì không cần sử dụng tên class
	 * để lấy ra , mà ta có thể gọi trực tiếp hàm đó lun.
	 */
	public static void main() {
		System.out.println("Main: Test the fake one");
	}

	public static void sum() {
		System.out.println("Test sum");
	}

	private static void sub() {
		System.out.println("Test sub");
	}

	public void mul() {
		System.out.println("Test mul");
	}

}
