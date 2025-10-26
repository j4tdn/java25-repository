package function.lambda;

public class LambdaDemo {
	public static void main(String[] args) {
		Shape s1 = new Shape() {
			
			@Override
			public void calcS() {
				// TODO Auto-generated method stub
				System.out.println("Rectangle --> calcS ...");
			}
		};
		s1.calcS();
		
	//anonymous function(phần override của abstract method bên trong interface)
	// phần khai báo chỉ gồm () và danh sách tham số kho có tên hàm 
	// thực thi 
		Shape s2 = () -> {
		System.out.println("\"Rectangle --> calcS ...");
		};
		s2.calcS();
		Shape s3 = () -> {
			System.out.println("\"Square --> calcS ...");
			};
			s3.calcS();
	}
	
}
