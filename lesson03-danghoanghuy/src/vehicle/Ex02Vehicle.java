package vehicle;

public class Ex02Vehicle {
	public static void main(String[] args) {
		
		Vehicle v1 = new Vehicle("Future Neo", 100, 35000000);
		Vehicle v2 = new Vehicle("Ford Ranger", 3000, 250000000);
		Vehicle v3 = new Vehicle("Landscape", 1500, 1000000000);
		
		Owner o1 = new Owner("Nguyen Thu Loan", v1);
		Owner o2 = new Owner("Le Minh Tinh", v2);
		Owner o3 = new Owner("Nguyen Minh Triet", v3);
		
		 System.out.printf("%-20s %-20s %-20s %-20s %-20s%n",
	                "Tên chủ xe", "Loại xe", "Dung tích", "Trị giá", "Thuế phải đóng");
		System.out.println("======================================================================================================================");
		System.out.printf("%-20s %-20s %9s %18.2f %27.2f%n",
				o1.getName(), v1.getModel(), v1.getCapacity(), v1.getPrice(), TaxUtils.taxPaid(o1));
		System.out.printf("%-20s %-20s %9s %18.2f %27.2f%n",
				o2.getName(), v2.getModel(), v2.getCapacity(), v2.getPrice(), TaxUtils.taxPaid(o2));
		System.out.printf("%-20s %-20s %9s %18.2f %27.2f%n",
				o3.getName(), v3.getModel(), v3.getCapacity(), v3.getPrice(), TaxUtils.taxPaid(o3));
		
	}
}
