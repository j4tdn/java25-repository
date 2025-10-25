package Ex04;

public class Staff extends  Director{

	protected String departmentname;
	protected DepartmentHead manager;;
	
	
	public Staff() {
		
	}


	public Staff(String name, String dateOfBirth, Float salarycoefficient, String departmentname, DepartmentHead manager) {
		
		super(name, dateOfBirth, salarycoefficient, salarycoefficient);
		this.departmentname = departmentname;
		this.manager = manager ;
		
	}


	public String getDepartmentname() {
		return departmentname;
	}


	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}


	public DepartmentHead getNamemanager() {
		return manager;
	}


	public void setNamemanager(String namemanager) {
		this.manager = manager;
	}

	public double getSalary() {
		return salarycoefficient * 1250000;
	}

	@Override
	public String toString() {
		return "Staff: Họ và tên: " + name+ " Năm sinh: "+dateOfBirth+" Hệ số lương: "+salarycoefficient+ " Tên đơn vị: "+ departmentname +" Tên trưởng phòng: "+manager;
	}
	
	
	
}
