package Bai4;

public class Main {
	
	public static void main(String[] args) {
		Director d1 = new Director("Nguyễn Bảo Bằng", "1/2/1997",5.0 , 6.0);
		
		HeadofDepartment h1  = new HeadofDepartment("Vũ Mạnh Quỳnh","3/5/1995",2.5 ,1.5,"SL");
		HeadofDepartment h2  = new HeadofDepartment("TRần Tiến","6/3/1995",3.5 ,1.2,"HR");
		
		Employee e1 = new Employee("Nguyễn Văn B","4/6/2000",2.0,"SL","Vũ Mạnh Quỳnh");
		Employee e2 = new Employee("Nguyễn Văn H","8/9/2005",2.8,"HR","TRần Tiến");
		Employee e3 = new Employee("TRần Văn C","2/10/1996",2.3,"HR","Vũ Mạnh Quỳnh");
		Employee e4 = new Employee("Hoàng Thị L","4/5/1999",2.5,"Sl","TRần Tiến");
		
		Person[] staff = {d1, h1, h2, e1, e2, e3, e4};
		
		System.out.println("=====Thông Tin Toàn Bộ Nhân Viên=====");
		for(Person p : staff) {
			p.infor();
		}
		
		System.out.println("=====Số Lượng Nhân Viên Được Quản Lý Bởi Từng Trưởng Phòng=====");
		System.out.println(h1.getdepartment() + " - " + h1.Name + ": " + countEmployeeByManager(staff, h1.Name));
		System.out.println(h2.getdepartment() + " - " + h2.Name + ": " + countEmployeeByManager(staff, h2.Name));
		
	}

	private static int countEmployeeByManager(Person[] list, String HoDName) {
		int count = 0;
		for(Person p : list) {
			if(p instanceof Employee) {
				Employee e = (Employee) p;
				if(e.getHoDName().equals(HoDName)) {
					count++;
				}
			}
		}
		return count;
	}
}
