import java.util.Scanner;

public class Bai3 {
	
	public static boolean isValidEmail(String email) {
		String text = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		
		return email.matches(text);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String email;
		
		while(true) {
			System.out.println("Nhập email: ");
			email = sc.nextLine();
			
			if(isValidEmail(email)) {
				System.out.println("Email: " + email + " hợp lệ" );
				break;
			}else {
				System.out.println("\nEmail Không hợp lệ mời nhập lại");
			}
		}
		sc.close();
	}

}
