package homework;

import java.util.Random;

public class BT10 {

	/*
	 * Viết chương trình in ra 5 số nguyên ngẫu nhiên từ 20 đến 30 → [20, 30]
Yêu cầu: 5 số ngẫu nhiên không được trùng nhau
	 */
	
	public static void main(String[] args) {
		
		Random rd = new Random();
		
		int[] numbers = new int[5];
		
		for(int i=0;i<5;i++) {
			int newNum;
			boolean check;
			do {
				newNum= rd.nextInt(20,31);
				
				for(int j=0;j<i;j++) {
				if(numbers[j]==newNum) {
					check =true;
					break;
					}
				}
				check =false;
			} while(check);
				numbers[i]= newNum;
			
		}
		
		System.out.println("5 số ngẫu nhiên không trùng nhau là: ");
		for(int number :numbers) {
			System.out.print(number +", ");
		}
	}
}
