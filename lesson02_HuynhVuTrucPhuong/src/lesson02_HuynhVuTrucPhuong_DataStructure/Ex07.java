package lesson02_HuynhVuTrucPhuong_DataStructure;

import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so nguyen n(n>=0) ");
        while (!sc.hasNextInt()) {
            System.out.print("Sai dinh dang vui long nhap lai");
            sc.next();
        }
        int N = sc.nextInt();
        while (N < 0) {
            System.out.print("N phải >= 0, nhập lại: ");
            N = sc.nextInt();
        }
        if (N == 0) {
            System.out.println("Ket qua: 0");
        } else {
            StringBuilder binary = new StringBuilder();
            int temp = N;
            while (temp > 0) {
                binary.insert(0, temp % 2); 
                temp /= 2; 
            }
            System.out.println("Ket qua: " + binary);
        }
        
        sc.close();
	}

}