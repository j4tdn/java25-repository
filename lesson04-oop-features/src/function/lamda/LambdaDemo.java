package function.lamda;

public class LambdaDemo {
	public static void main(String[] args) {
		
		// NumberTest nt1 = new NumberEventest();
		// nt0.testing(...)
		
		int val = 25;
		
		NumberTest nt1 = new NumberTest() {
			
			@Override
			public boolean testing(int number) {
				return number % 2 != 0;
			}
		};
		System.out.println("nt1(odd) --> " + nt1.testing(val));
		
		NumberTest nt2 = new NumberTest() {
			
			@Override
			public boolean testing(int number) {
				return number % 2 != 0;
			}
		};
		System.out.println("nt2(odd) --> " + nt2.testing(val));
		
		
		System.out.println("\n---------------------------\n");
		
		// implements class
		// Shape s0 = new Rectangle;
		
		// anonymous class
		Shape s1 = new Shape() {
			
			@Override
			public void calcS() {
				System.out.println("Rectangle --> calcS...");
			}
		};
		s1.calcS();
		
		
		// anonymous function(phan override cua abstract mthod ben trong interface)
		// override
		// phan khai bao chi gom () va danh sach tham so, k co ten ham
		// thuc thi
		// voi lamda --> k can ghi KDL cua cac tham so
		//			 --> neu chi co 1 tham so, co the xoa ()
		//			 --> neu body chi co 1 dong, co the xoa {}
		//			 --> khi xoa {} neu ham co return data thi xoa lun tu khoa return
		Shape s2 = () -> {
			System.out.println("Circle --> calcS...");
		};
		s2.calcS();
		
		Shape s3 = () -> {
			System.out.println("Square --> calcS...");
		};
		s3.calcS();
	}
}
