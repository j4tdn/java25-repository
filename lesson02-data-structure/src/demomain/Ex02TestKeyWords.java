package demomain;

public class Ex02TestKeyWords {
	public static int mul(int a, int b) {
		return a * b;

	}

	public static void main(String[] args) {
		// Đối với một hàm không sử dụng static thì phải new ra một đối tượng tên là obj
		// để dùng nó.
		Ex01TestMainMethod obj = new Ex01TestMainMethod();
		obj.mul();
		// Đối với hàm sử dụng static thì gọi tên class nó và chấm tên hàm
		// VD: class.method();
		Ex01TestMainMethod.sum();
	}
}
