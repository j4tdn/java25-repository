package exhomework;

public class Ex08 {
	public static void main(String[] args) {
		int	number = CheckInput.getInput();
		int count = 0;
		for (int i = 1; i <= number; i++) {
			if(number % i ==0) {
				count++;
			}			
		}
		if(count == 2) {
			System.out.println(number + " là số nguyên tố.");
		}else System.out.println(number + " không phải là số nguyên tố.");
	}
}
