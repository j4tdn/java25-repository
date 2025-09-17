package exericise;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int wrongTime =0;
		int n=0;
		do {
			System.out.println("Nhap so nguyen: ");
			if(!sc.hasNextInt()) {
				sc.next();
				System.out.println("Day kh phai so nguyen");
				wrongTime ++;
			}else {
				n = sc.nextInt();
				if(isPowerOfTwo(n)) {
					System.out.println("Day la luy thua cua 2!!");
					break;
				}else {
					System.out.println("Day kh phai luy thua cau 2");
					wrongTime++;
				}
			}
			if(wrongTime == 5) {
				System.out.println("Nhap qua 5 lan");
				break;
			}
		}while(true);
		sc.close();
		
	}
	private static boolean isPowerOfTwo(int n) {
		if(n <=0 ) return false;
		while(n %2 == 0) {
			n /= 2;
		}
		return n == 1;
	}
}
