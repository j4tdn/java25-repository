package view;

import java.util.Scanner;

/*
Bài 5(20đ): Số Hạnh Phúc – Happy Number
Một số hạnh phúc được xác định như sau
Với một số nguyên dương bất kì, thay thế số đó bằng tổng bình phương các chữ số của nó
Lặp đi lặp lại qúa trình cho đến khi được số bằng 1 hoặc lặp vô tận trong một chu kì mà không bao
gồm 1.
Những số theo quy kỳ kết thúc bằng 1 là những con số hạnh phúc, trường hợp còn lại lặp vô hạn gọi
là số không hạnh húc
Hãy cùng thử với số 44
Lần 1: 4^2 + 4^2 = 32
Lần 2: 32 + 2
2 = 13
Lần 3: 12 + 3
2 = 10
Lần 4: 12 + 0
2 = 1

Do đó số 44 là số hạnh phúc
-----------------------------------
Viết chương trình kiểm tra một số có phải là số hạnh phúc không(Output: true false)
 */

public class Ex05 {

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhap so: ");
		int n = ip.nextInt();
		
		isHappyNumber(n);
		
		ip.close();
		
	}
	
	private static boolean isHappyNumber(int n) {
		
	
		return true;
	}
}
