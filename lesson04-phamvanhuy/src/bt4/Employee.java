package bt4;

public class Employee extends Staff {

	private String departmentName;
	private Manager manager;

	public Employee() {
	}

	public Employee(String fullName, String birthDate, double salaryCoefficient, String departmentName,
			Manager manager) {
		super(fullName, birthDate, salaryCoefficient);
		this.departmentName = departmentName;
		this.manager = manager;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public double calculateSalary() {
		return getSalaryCoefficient() * 1250000;
	}

	@Override
	public String toString() {
		return "Employee [fullName=" + getFullName() + ", birthDate=" + getBirthDate() + ", salaryCoefficient="
				+ getSalaryCoefficient() + ", departmentName=" + departmentName + ", manager=" + manager.getFullName()
				+ ", salary=" + String.format("%,.0f", calculateSalary()) + "]";
	}
	public void showInfo() {
	    System.out.println("Employee [fullName=" + getFullName() 
	        + ", birthDate=" + getBirthDate() 
	        + ", salaryCoefficient=" + getSalaryCoefficient() 
	        + ", departmentName=" + departmentName 
	        + ", manager=" + manager.getFullName() + "]");
	}

}
