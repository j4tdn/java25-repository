package ex04;

public class Staff extends Employee {
	
	private String departmentName;
	private String managerName;
	
	public Staff() {
	}

	public Staff(String fullName, String birthDate, double salaryCoefficient, String departmentName,
			String managerName) {
		super(fullName, birthDate, salaryCoefficient);
		this.departmentName = departmentName;
		this.managerName = managerName;
	}
	
	



	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Override
	public double getSalary() {
		return (getSalaryCoefficient())*1250000;
	}

}
