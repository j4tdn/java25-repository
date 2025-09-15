package exercises;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0;
		int temp = 0;
		System.out.print(" Nhap so nguyen duong N: ");
		while (temp < 5) {

			try {
				N = sc.nextInt();

				if (N >= 10) {
					break;
				} else {
					System.out.print("N khong hop le, nhap lai N: ");
				}

			} catch (Exception e) {
				System.out.print("N khong hop le, nhap lai N: ");
				sc.nextLine();
			}

			temp++;

			if (temp == 5) {
				System.out.println("Qua so lan nhap, ket thuc chuong trinh!");
				sc.close();
				return;
			}
		}

        int original = N; 
        int reverse = 0;

        while (N > 0) {
            int digit = N % 10; 
            reverse = reverse * 10 + digit; 
            N = N / 10; 
        }

        if (original == reverse) {
            System.out.println(original + " là số đối xứng.");
        } else {
            System.out.println(original + " không phải là số đối xứng.");
        }
    }
}
