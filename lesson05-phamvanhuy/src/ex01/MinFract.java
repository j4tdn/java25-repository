package ex01;
import java.util.Scanner;

public class MinFract {
	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		int dem = 0;
		double x = 0;
		while (dem < 3) {
			System.out.println("Nhập số thực có phần thập phân: ");
			x = sc.nextDouble();
			if(x % 1 != 0) break;
			System.out.println("sai, vui lòng nhập lại");
			dem++;
		}
	
	}
//	String getMinFract(double num) {
	
	}




