package bai2;

public class App {
	public static void main(String[] args) {
		Vehicle o1 = new Vehicle("Nguyễn Thu Loan", "Vinfast",100,35000000);
		Vehicle o2 = new Vehicle("Lê Minh Tính", "BMW",3000,35000000);
		Vehicle o3 = new Vehicle("Nguyễn Minh Triết", "Honda",1500,25000000);
		
		System.out.println("Tên chủ xe  "+ "  Loại xe  "+"  Dung tích  "+"  Trị giá  "+"  Thuế phải nộp  ");
		
		System.out.println("===============================================================");
	
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o3);
		
	}
}
