package function.lambda;

public class LambdaDemo {
		
	
	// anonymous class
	public static void main(String[] args) {
		
	int val = 25;
	NumberTest nt1 = new NumberTest() {
		@Override
		public boolean testing(int number) {
			return number %2 !=0;
		}
	};
	System.out.println("nt1(odd) --> "+nt1.testing(val));
	
	NumberTest nt2 = new NumberTest() {
		@Override
		public boolean testing(int number) {
			return number %2 ==0;
		}
	};
	System.out.println("nt2(even) --> "+nt2.testing(val));
	NumberTest nt3 = new NumberTest() {
		@Override
		public boolean testing(int number) {
			return number %5 ==0;
		}
	};
	System.out.println("nt3 --> "+nt3.testing(val));
	System.out.println("----------------------");
	Shape s1 = new Shape() {
		@Override
		public void calcS() {
			System.out.println("Rectangle --> calcS ...");
		
			}
		};
		s1.calcS();
		
		/* anonymous function (phần override của abstract method bên trong interface)
		 * override
		 * phần khai báo chỉ gồm () và danh sách tham số, k có tên hàm thêm dấu ->
		 * thực thi
		 * với lambda --> k cần ghi KDL của các tham số
		 * 		 	  --> nếu chỉ có 1 tham số, có thể xóa()		
		 */
		Shape s2 = () ->{
			System.out.println("Rectangle2 --> calcS ...");
			
		};
		s2.calcS();
		Shape s3 = () ->{
			System.out.println("Square1 --> calcS ...");
			
		};
		s3.calcS();
		Shape s4 = () ->{
			System.out.println("Square2 --> calcS ...");
			
		};
		s4.calcS();
	}
}
