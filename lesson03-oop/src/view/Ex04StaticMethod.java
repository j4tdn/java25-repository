package view;

public class Ex04StaticMethod {
	private int a,b;
	public Ex04StaticMethod(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public static void main(String[] args) {
		System.out.println("sm1: "+Ex04StaticMethod.sum(1,2));
		Ex04StaticMethod sm2 = new Ex04StaticMethod(5, 4);
		System.out.println("sm2: "+ sm2.sub());
		
	}
	// ham sum khong phu thuoc vao doi tuong dang goi
	private static int sum(int a,int b) {
		return a+b;
	}
	 public int sub() {
		 return a - b;
	 }
	 
}
