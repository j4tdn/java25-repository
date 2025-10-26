package homework4;

public class Manager extends Person {
	private String departmentName;
	private int employeeCount;
	
	public Manager(String fullName, String dateOfBirth, double salaryCoefficient, double positionCoefficent, String departmentName) {
		super(fullName, dateOfBirth, salaryCoefficient, positionCoefficent);
		 this.departmentName = departmentName;
	}
	

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	@Override
	public long getSalary() {
		
		return (long) ((getSalaryCoefficient() + getPositionCoefficent()) * 2200000);
	}
	public int getEmplyeeCount() {
		return employeeCount;
	}
	
	public void increaseEmployeeCount() {
		employeeCount++;
		
	}


	@Override
	public String toString() {
		return "Truong phong |" + super.toString() + "| Đon vi: " + departmentName +"| So nv quan ly: " + employeeCount +"| Luong: " + getSalary();
	}


	
	

}
