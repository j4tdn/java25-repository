import java.util.Scanner;

public class Bai1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a , b;
		 while(true) {
			 try {
				 System.out.println("Nhập a: ");
				 a = Double.parseDouble(sc.nextLine());
				 
				 System.out.println("Nhập b: ");
				 b = Double.parseDouble(sc.nextLine());
				 
			 if(a == 0) {
				 throw new ArithmeticException("Lỗi a nhập vào không được bằng 0, nhập lại.");
			 }
			 
			 break;
			 }catch(NumberFormatException e) {
				 System.out.println("Phải nhập số không được nhập chữ");
			 }catch(ArithmeticException e) {
				 System.out.println(e.getMessage());
			 }
		 }
		 
		 double x = -b/a;
		 System.out.println("Kết quả: " + x);
	}
	
}
