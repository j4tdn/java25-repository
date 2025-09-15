package view;

public class Ex05IOOperattion {
public static void main(String[] args) {
	Scanner ip = new Scanner (System. in) ;
	System.out.print("Nhập MaMH: ");
	String id = ip. nextLine();
	System.out.print( "Nhập TenMH: ");
	String name = ip. nextLine();
	System.out.print("Nhập SoLuong: ");
	int amount = Integer.parseInt(ip.nextLine());
	System.out.print("Nhập GiaBan: ");
	float salesPrice = Float.parseFloat(ip.nextLine());
	System.out.print("Nhập MoTa: ");
	String description = ip.nextLine();
	System.out.printf("\nThông tin mặt hàng: %s", (id + ""
	+ name + " , " + amount + ", " + salesPrice + " , " + description);
	ip. close();
}
}
