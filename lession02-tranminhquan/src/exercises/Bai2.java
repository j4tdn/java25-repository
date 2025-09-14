package exercises;

import java.util.Scanner;

public class Bai2 {
	
	public static void main(String[] args) {
		Bai2.run();
	}
	public static void run() {
		Scanner sc = new Scanner(System.in);
		int count = 0; // MẶc định lần nhập =0
		int N ;

		while (count < 5) {
			System.out.print("Nhập số nguyên dương N: ");

			if (sc.hasNextInt()) { // nếu đúng số nguyên -> trả về true 
				N = sc.nextInt();  // true -> gán giá trị cho N

				if (N > 0) {
					boolean result = true;

					while (N > 1) {
						if (N % 2 != 0) {
							result = false;
							break;
						}
						N /= 2;
					}

					System.out.println("Result: " + result);
					return;
				} else {
					System.out.println("N phải > 0! Nhập lại: ");
					count++;
				}
			} else {
				System.out.println("Nhập số nguyên(N>0).");
				sc.next(); // bỏ dữ liệu sai, nếu k sẽ xuát hiện kết quả dựa trên lần nhập đầu tiên
				count++;
			}
		}
		System.out.println("Sai quá 5 lần, dừng chương trình");
	}
}
