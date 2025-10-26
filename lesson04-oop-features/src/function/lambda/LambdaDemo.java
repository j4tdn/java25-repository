package function.lambda;

public class LambdaDemo {
	public static void main(String[] args) {

		// numberTest nt1 = new numberEventest();
		// nt0.testing(...)
		int val = 25;
		NumberTest nt1 = new NumberTest() {

			@Override
			public boolean testing(int number) {
				return number % 2 == 0;
			}
		};
		System.out.println("nt1 --> " + nt1.testing(val));

		NumberTest nt2 = (int number) -> {
			return number % 5 == 0;

		};
		System.out.println("nt2 --> " + nt2.testing(val));

		System.out.println("\n-------------------------------\n");

		// anonymous class
		Shape s1 = new Shape() {

			@Override
			public void calcS() {
				System.out.println();
			}
		};
		s1.calcS();

		// anonymous function(phần override của abstract method bên trong interface
		// override
		// phần khai báo chỉ gồm () và danh sách tham số, ko có tên hàm thêm dấu ->
		// thực thi
		// với lamnda --> ko cần ghi KDl của các tham số
		//            --> nếu chỉ có 1 tham số, có thể xóa ()
		//            --> nêú body chỉ có 1 dòng code, có thể xóa{}
		//            --> khi xóa {} nếu hàm có return
		Shape s2 = () -> {
			System.out.println("Square1 --> calcS ...");
		};
		s2.calcS();

		Shape s3 = () -> {
			System.out.println("Square1 --> calcS ...");
		};
		s3.calcS();
	}

}
