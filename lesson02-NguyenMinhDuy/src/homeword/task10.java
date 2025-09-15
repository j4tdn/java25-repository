package homeword;

import java.util.Random;

/**
 * Bài 10: Viết chương trình in ra 5 số nguyên ngẫu nhiên từ 20 đến 30 → [20,
 * 30] Yêu cầu: 5 số ngẫu nhiên không được trùng nhau
 */
public class task10 {
	
	public static void main(String[] args) {
		Random rd = new Random();
		int[] arrays = new int[5];
		int count = 0;
		while(count < 5) {
			int a = rd.nextInt(20,30);
			Boolean test = false;
			
			for(int i = 0; i < count; i++) {
				if(arrays[i] == a) {
					test = true;
					break;
				}
			}
			
			if(!test) {
				arrays[count] = a;
				count++;
			}
		}
		System.out.println("Số ngẫu nhiên không trùng lặp từ 20 -> 30 là: ");
		
		for(int i = 0; i<arrays.length; i++) {
			System.out.println(arrays[i]);
		}
	}
}
