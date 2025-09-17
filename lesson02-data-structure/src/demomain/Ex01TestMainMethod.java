package demomain;

public class Ex01TestMainMethod {
	
	
	public static void main(String[] args) {
		System.out.println("Main: Test the real one");
		System.out.println("-----");
		main();
		System.out.println("-----");
		sum();
		System.out.println("-----");
		sub();
		
		//nếu gọi hàm static, gọi chính bên trong class chứa nó
		//--> không cần phải lấy tên class gọi nó, gọi trực tiếp
		
	}
	public static void main() {
		System.out.println("Main: Test the fake one");
	}
	public static void sum() {
		System.out.println("Test sum method");
	}
	private static void sub() {
		System.out.println("Test sub method");
	}
	public void mul() {
		System.out.println("Test mul method");
	}
}

