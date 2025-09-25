package ex02Vehicle;

public class App {

	public static void main(String[] args) {
		
		Vehicles v1 = new Vehicles("Nguyên Thu Loan", "  Vinfas", 100, 35000000);
		Vehicles v2 = new Vehicles("Lê Minh Tính", "	   BMW  ",    3000, 35000000);
		Vehicles v3 = new Vehicles("Nguyên Minh Triết", "Honda",  1500, 25000000);
		Vehicles v4 = new Vehicles("Trần Văn Thanh", "   Toyota", 5000, 25000000);

		System.out.println("	Tên chủ xe	" + "Loại xe"+"	 Dung tích"+" Trị giá 	"+"Thuế phải nộp"	);
		System.out.println("=========================================================================================");

		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		
	}
	
}
