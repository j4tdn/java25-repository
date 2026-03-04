package function.lamda;

public class LambdaDemo {
public static void main(String[] args) {
	
	//NumberTest nt0 = new NumberEvenTest();
	//nt0.testing(..)
	int val =10;
	NumberTest nt1 = new NumberTest() {

		@Override
		public boolean testing(int number) {
			return number % 2 != 0;
		}
		
		
	};
	System.out.println("nt1(odd) --> " + nt1.testing(val));
	NumberTest nt2 = (int number) -> {
		return number % 2 != 0;
	};
	System.out.println("nt2(odd) --> " + nt2.testing(val));
	
	NumberTest nt3 = (int number) -> {
		return number % 5 == 0;
	};
	System.out.println("nt3(odd) --> " + nt3.testing(val));
	
	System.out.println("\n---------------------------------\n");
	Shape s1 = new Shape() {
		@Override
		public void calcS() {
			System.out.println("Rectangle --> calcS ..");
			
		}
	};
	s1.calcS();
	
	//anonymous function(phần override của abstract method bên trong interface)
	Shape s2 = () -> {
		System.out.println("Rectangle --> calcS ...");
	};
	s2.calcS();
	
	Shape s3 = () -> {
		System.out.println("Square1 --> calcS ...");
	};
	s3.calcS();
	
	Shape s4 = () -> {
		System.out.println("Square2 --> calcS ...");
	};
	s4.calcS();
}
}
