package exhomework;

public class Ex07 {
		public static void main(String[] args) {
		int number = CheckInput.getInput();
		int n = number;	
		String a = "";
		while(n>0) {
			if(n % 2 == 0) {
			a = 0 + a;
			}else {
				a = 1 + a;
			}
			n = n / 2;
			}
		System.out.println("Chuyển đổi "+ number +" sang nhị phân ta được số: "+ a);
		}
}
