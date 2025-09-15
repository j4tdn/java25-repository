package loop;

public class Ex02BreakContinue {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Start block: " + i);
			if (i == 4) {
				continue;
			}
			System.out.println("statements: " + i);
			System.out.println("End block: " + i);

		}
	}

}
