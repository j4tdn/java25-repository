import java.util.Scanner;

public class Bai2 {
	
	public static boolean isValidPassword(String pw) throws Exception {
		if(pw.length() < 8) {
			throw new  Exception("Mật khẩu phải có ít nhất 8 ký tư");
		}
		if(pw.length() > 256) {
			throw new Exception("Mật khẩu phải ngắn hơn 256 ký tự");
		}
		if(!pw.matches(".*[a-z].*")) {
			throw new Exception("Mật khẩu phải có ít nhất 1 chữ thường");
		}
		if(!pw.matches(".*[A-Z].*")) {
			throw new Exception("Mật khẩu phải có ít nhất 1 chữ Hoa");
		}
		if(!pw.matches(".*[0-9].*")) {
			throw new Exception("Mật khẩu phải có ít nhất 1 chữ số");
		}
		if(!pw.matches(".*.*[!@#$%^&*()\\\\-_=+{}\\\\[\\\\]:;\\\"'<>,.?/].*")) {
			throw new Exception("Mật khẩu phải có ít nhất 1 ký tự đặc biệt");
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while(n<5) {
			try {
				System.out.println("Nhập mật khẩu: ");
				String pw = sc.nextLine();
				
				if(isValidPassword(pw)) {
					System.out.println("Đăng ký thành công");
					return;
				}
			}catch (Exception e) {
				n++;
				System.out.println("Lỗi: " + e.getMessage());
				System.out.println("\ncòn " + (5-n) +" lần thử lại.");
			}
		}
		
		System.out.println("Bạn đã nhập sai 5 lần, hủy đăng ký");
		sc.close();
	}
	
}

