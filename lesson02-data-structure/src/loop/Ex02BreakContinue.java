package loop;

public class Ex02BreakContinue {
	public static void main(String[] args) {
		
		// Cau truc vong lap su dung tu khoa break, continue de dieu khien vong lap
		
		// break: vong lap gap tu khoa break, thoat khoi toan bo vong lap do
		// continue: vong lap gap tu khoa continue, bo qua vong lap thu i+1
		
		for(int i = 1; i <= 10; i++) {
			System.out.println("start block: " + i);
			
			if(i == 4) {
				continue;
			}
			
			System.out.println("statements");
			System.out.println("end block: " + i + "\n");
		}
	}
}
