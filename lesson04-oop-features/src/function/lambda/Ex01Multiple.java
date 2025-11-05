package function.lambda;

public class Ex01Multiple {

	public static void main(String[] args) {
		
		Integer n = NumberUtils.inputNumber("Enter N(N > 0): ", val -> val > 0, 5);
		
	}
	
}
