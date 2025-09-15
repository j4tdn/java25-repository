package nghoangminh_lesson02exercise;

import java.util.Random;

public class bai10 {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] nums = new int[5];

		for (int i = 0; i < 5; i++) {
			int temp;
			boolean duplicate; // cờ kiểm tra trùng
			do {
				temp = rand.nextInt(11) + 20; // random số [20,30]
				duplicate = false;
				// Kiểm tra trùng với các số trước đó
				for (int j = 0; j < i; j++) {
					if (nums[j] == temp) {
						duplicate = true;
						break; // đã trùng thì thoát vòng for
					}
				}
			} while (duplicate); // nếu trùng thì random lại

			nums[i] = temp; // gán số hợp lệ vào mảng
		}

		
		System.out.println("5 số ngẫu nhiên không trùng nhau từ 20 đến 30:");
		for (int n : nums) {
			System.out.print(n + " ");
		}
	}
}
