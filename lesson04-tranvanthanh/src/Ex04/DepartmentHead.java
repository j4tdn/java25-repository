package Ex04;

public class DepartmentHead extends Director {

	protected String departmentname;
	
	
	public DepartmentHead() {
		
	}


	public DepartmentHead(String name, String dateOfBirth, Float salarycoefficient, Float positioncoefficient, String departmentname) {
		super(name, dateOfBirth, salarycoefficient, positioncoefficient);
		this.departmentname = departmentname;
	}


	public String getDepartmentname() {
		return departmentname;
	}


	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	
	public double getSalary() {
		return (salarycoefficient + positioncoefficient) * 2200000;
	}

	@Override
	public String toString() {
		return "DepartmentHead: Họ và tên: " + name+ " Năm sinh: "+dateOfBirth+" Hệ số lương: "+salarycoefficient+" Hệ số chức vụ: "+ positioncoefficient+" Tên đơn vị/phòng ban: "+departmentname;
	}


	
	
	
}
