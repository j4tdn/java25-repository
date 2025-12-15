package loop;

public class Ex02BreakContinue {
	
	public static void main(String[] args) {
		
		// Cấu trúc vòng lặp sử dụng từ khóa break, continue để điều khiển lặp
		
		// break: vòng lặp gặp từ khóa break, thoát khỏi toàn bộ vòng lặp đó
		// continue: vòng lặp gặp từ khóa continue, bỏ qua vòng lặp thứ i hiện tại mà nhảy qua vòng lặp thứ i+1
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("start block " + i);
			
			if (i == 4) {
				continue;
			}
			
			System.out.println("statements");
			System.out.println("end block " + i + "\n");
		}
		
	}
	
}