package bai2;

import java.util.Random;


/*
 * Cho một dãy số nguyên ngẫu nhiên gồm n(5 <= n <= 100) chữ số, viết chương trình:
Gom tất cả các số chia hết cho 7 về đầu dãy và tất cả các số chia hết cho 5 về cuối dãy. Các số
vừa chia hết cho 5 vừa chia hết cho 7 và các số còn lại đưa ra giữa với yêu cầu format sử dụng
dấu , | như ví dụ bên dưới
Input: 12, 21, 25, 19, 32, 35, 49, 10, 33, 14, 18
Output: 21, 49, 14 | 12, 19, 32, 35, 33, 18 | 25, 10
 */
public class FindMatchingNums {
		public static void main(String[] args) {
		
		Random rd = new Random();
		int n = rd.nextInt(5,100);
		int[] numbers = new int[n];
		
		for (int i = 0; i < n; ) {
            int value = rd.nextInt(101); 
            boolean check = false;

            for (int j = 0; j < i; j++) {
                if (numbers[j] == value) {
                    check = true;
                    break;
                }
            }

            if (check == false) {
                numbers[i] = value;
                i++; 
            }
        }
		System.out.println("Dãy số ngẫu nhiên có " + n +" phần tử  ");
		for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ,");
        }
		System.out.println("-----------------------");
		
		System.out.print("Các số chia hết cho 7: ");
		countElements(numbers, nb ->nb%7==0 && nb%5!=0 );
		System.out.println("\n");
		
		System.out.print("Các số vừa chia hết cho 5 vừa chia hết cho 7: ");
		countElements(numbers, nb -> nb%5==0 && nb%7==0);
		System.out.println("\n");
		
		System.out.print("Các số chia hết cho 5: ");
		countElements(numbers, nb ->nb%5==0 && nb%7!=0 );
	}
	private static void countElements(int[] elements, Numbertest ntest) {
		
		for(int element : elements) {
			if(ntest.checking(element)) {
				System.out.print(element +" ");
			}
		}
		
	}
}
