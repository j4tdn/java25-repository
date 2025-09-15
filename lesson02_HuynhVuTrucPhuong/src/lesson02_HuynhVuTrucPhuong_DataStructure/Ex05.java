package lesson02_HuynhVuTrucPhuong_DataStructure;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while(true){
			System.out.println("Nhap so nguyen duong n(toi thieu 2 chu so): ");
			String a = sc.nextLine();
			if(!a.matches("\\d+")) {
				System.out.println("Loi vui long nhap so nguyen duong: ");
				continue;
			}
			n = Integer.parseInt(a);
			if(n<10) {
				System.out.println("Loi phai nhap toi thieu 2 chu so");
				continue;
			}
			break;
		}
		String s = String.valueOf(n);
		String daochuoi = new StringBuilder(s).reverse().toString();
		if(s.equals(daochuoi)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}

}
