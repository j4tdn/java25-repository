package Ex04;

public class Main {

	public static void main(String[] args) {
	
		Director[] employees = Data();		
		System.out.println("Hiển thị danh sách nhân viên trong công ty.");
		output(employees);
		System.out.println("==========================================");
		salary(employees);
		
		
	}
	
	private static Director[] Data() {
		
		Director d = new Director("Lê Thị Thơm", "23-11-1999",5.0f , 3.2f);
		
		DepartmentHead d1= new DepartmentHead("Trần Văn Thanh", "04-01-1998", 4.0f,3.0f,"Công Nghệ Thông Tin");
		DepartmentHead d2= new DepartmentHead("Trần Văn A", "27-02-1998", 4.0f,3.0f,"Marketing");
		
		Staff s1 = new Staff("Nguyễn Văn A","15-01-2004",2.0f,"Công Nghệ Thông Tin",d1);
		Staff s2 = new Staff("Nguyễn Văn B","28-09-2010",1.5f,"Công Nghệ Thông Tin",d1);
		Staff s3 = new Staff("Nguyễn Văn C","17-07-2009",2.5f,"Công Nghệ Thông Tin",d1);
		
		
		
		Staff s4 = new Staff("Nguyễn Văn D","09-03-2000",1.2f,"Marketing",d2);
		Staff s5 = new Staff("Nguyễn Văn E","19-01-2005",3.1f,"Marketing",d2);
		Staff s6 = new Staff("Nguyễn Văn F","30-01-2010",1.4f,"Marketing",d2);
		
		
		Director[] employees = {d,d1,d2,s1,s2,s3,s4,s5,s6};
				
		return employees;
		
	}
	
	
	private static void output(Director[] employees) {
	    for (Director e : employees) {
	        System.out.println(e);
	    }
	}
	
	private static void salary(Director[] employees) {
	    for (Director e : employees) {
	        System.out.println(e+" Lương: "+e.getSalary());
	    }
	
	}
}