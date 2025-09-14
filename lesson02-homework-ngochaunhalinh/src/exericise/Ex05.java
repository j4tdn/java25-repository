package exericise;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		do {
			System.out.println("Nhap ptu n: " );
			if(!sc.hasNextInt()) {
				sc.next();
				System.out.println("day kh phai so nguyen: ");
			}else {
				n = sc.nextInt();
				if(n > 10 && isSymmetricalNumber(n)) {
						System.out.println("day la so dao nguoc");
						break;
				
				}else {
					
					System.out.println("kh phai so dao nguoc (hoac phai nhap so co 2 chu so)");
					
				}
			}
			
		}while(true);
		
				
	}
	private static boolean isSymmetricalNumber(int n) {
		int tamp = n;
		int result = 0;
		while(tamp!=0) {
			result = result*10 + tamp%10;
			tamp = tamp / 10;
		}return result == n;
	}
}