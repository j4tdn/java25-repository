package function.lamda;

public class Ex01ArrayCounter {
	public static void main(String[] args) {
		int[] numbers = {1,5,2,8,10,20,7,18};
		
		System.out.println("So chan: " + countEvenElements(numbers));
		System.out.println("So le: " + countOddElements(numbers));
		System.out.println("So chia het cho 5: " + countM5Elements(numbers));
		System.out.println("So nguyen to: " + countPrimeElements(numbers));
		
		System.out.println("\n-------------------\n");
		
		System.out.println("So chan: " + countElements(numbers, nb -> nb % 2 == 0));
		System.out.println("So le: " + countElements(numbers, nb -> nb % 2 != 0));
		System.out.println("So chia het cho 5: " + countElements(numbers, nb -> nb % 5 == 0));
		System.out.println("So nguyen to: " + countElements(numbers, nb -> nb % 2 == 0));
		
	}
	
	// Tu cac logic khac nhau
	// Tim cong thuc chung(strategy): input va output 
	
	// Bai toan: boolean ?(int element) dat ten ham gi cung dc(logic)
	// Tao interface chua ham truu tuong nhu cong thuc chung do
	
	//Tao method duoi dang strategy pattern co tham so la @FI do
	// Trong method, luc compile thi se chua biet ham truu tuong se lam gi
	// Luc goi method moi truyen phan thuc thi vao
	
	
	private static int countElements(int[] elements, NumberTest nTest) {
		int count = 0;
		for(int element: elements) {
			if(nTest.testing(element)) {
				count++;
			}
		}
		return count;
	}
	
	// Dem so chan
	private static int countEvenElements(int[] elements) {
		int count = 0;
		for(int element: elements) {
			if(element % 2 == 0) {
				count++;
			}
		}
		return count;
	}
	
	// Dem so le
	private static int countOddElements(int[] elements) {
		int count = 0;
			for(int element: elements) {
				if(element % 2 != 0) {
					count++;
				}
			}
		return count;
	}
	
	// Dem so ngto
		private static int countPrimeElements(int[] elements) {
			int count = 0;
			for(int element: elements) {
				if(isPrime(element)) {
					count++;
				}
			}
			return count;
		}
		
		// Dem so chan
		private static int countM5Elements(int[] elements) {
			int count = 0;
			for(int element: elements) {
				if(element % 5 == 0) {
					count++;
				}
			}
			return count;
		}
	
	private static boolean isPrime(int number) {
		if(number < 2) return false;
		if(number >= 2) {
			for(int i = 2; i < number; i++) {
				if(number % i == 0) return false;
			}
		}
		return true;
	}
}
