package CarRegistration;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
	  Scanner ip = new Scanner(System.in);
	  
	  System.out.println("Nhập số lượng khách hàng: ");
	  
	  int n = ip.nextInt();
	  
	  ip.nextLine();
	  
	  
	  Customer[] list = new Customer[n];
	  
	  for(int i = 0; i < n; i++) {
		  System.out.println("\nNhập thông tin khách hàng: "+ (i+1));
		  System.out.println("Tên khách hàng: ");
		  String owner = ip.nextLine();
		  System.out.println("Loại xe: ");
		  String cartype = ip.nextLine();
		  System.out.println("Dung tích xi lanh(cc): ");
		  int cylinder = ip.nextInt();
		  System.out.println("Giá xe: ");
		  double value = ip.nextDouble();
		  list[i] = new Customer(owner,cartype,cylinder,value);
	  }
	  
	  
	  System.out.printf("%-20s %-15s %-10s %-15s %-15s%n", "Tên KH","Tên xe","Dung Tích","Trị giá","Thuế phải nộp");
	  System.out.println("==========================================================================================");
	  
	  for (Customer c : list) {
		  System.out.printf("%-20s %-15s %-10d %-15.0f %-15.0f%n",c.getOwner(),c.getCartype(),c.getCylinder(),c.getValue(),Taxes.getTaxes(c));
	  }
  
  ip.close();
  } 
}
