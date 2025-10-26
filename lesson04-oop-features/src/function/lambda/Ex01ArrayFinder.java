package function.lambda;

public class Ex01ArrayFinder {
	public static void main(String[] args) {

		int[] numbers = { 1, 5, 2, 8, 10, 20, 7, 18 };
		
		//System.out.println("so chan: " + countEvenElements(numbers));
		//System.out.println("so le: " + countOldElements(numbers));
	    //	System.out.println("so chia het cho 5: " + countm5Elements(numbers));
		// System.out.println("so nguyen to: " + countPrimeElements(numbers));
		
		System.out.println("\n--------------------------\n");
		System.out.println("so chan: " + countElements(numbers, nb -> nb % 2 == 0));
		System.out.println("so le: " + countElements(numbers, nb -> nb % 2 != 0));
		// System.out.println("so chia het cho 5: " + countm5Elements(numbers));
		System.out.println("so nguyen to: " + countElements(numbers, nb -> nb % 5 == 0));

	}
	
	// Tìm công thức chung(strategy): input và output
	
	// Bài toán: boolean ?(int element) đặt tên hàm gì cũng được
	// tạo interface chứa hàm trừu tượng như công thức chung đó
	
	// Tao method dưới dạng strategy pattern có tham số là @FI đó
	// trong method, lúc compile thì sẽ chưa biết hàm trừu tượng sẽ làm gì
	// Lúc gọi method mới truyền phần thực thi vào

	private static int countElements (int[] elements, NumberTest nTest) {
		int count = 0;
		for (int element : elements) {
			if (nTest.testing(element)) {
				count++;
			}
		}
		return count;
	}

	

}
