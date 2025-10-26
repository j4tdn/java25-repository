package lab3;

import java.time.LocalDate;

public class Employee extends Staff {
	private String departmentName;
	private String managerName;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String username, LocalDate dateOfBirth, Double salary_Coefficient, String departmentName,
			String managerName) {
		super(username, dateOfBirth, salary_Coefficient);
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
	public String toString() {
		return "[ getUsername()=" + getUsername() + ", getDateOfBirth()=" + getDateOfBirth()
				+ ", getSalaryCoefficient()=" + getSalaryCoefficient() + "Employee departmentName=" + departmentName
				+ ", managerName=" + managerName + "]";
	}

	public void displayInfo() {
		System.out.printf(" %10s %20s %20s %25s %25s\n ", "User Name", "Date Of Birth", "Salary Coefficient",
				"Department Name", "Manager Name");
		System.out.printf("%10s %17s %17.2f %25s %32s\n", getUsername(), getDateOfBirth(), getSalaryCoefficient(),
				getDepartmentName(), getManagerName());
	}

	public void displaySalary() {
		System.out.printf(" %10s %20s %20s %25s %25s %25s\n ", "User Name", "Date Of Birth", "Salary Coefficient",
				"Department Name", "Manager Name", "Salary");
		System.out.printf("%10s %17s %17.2f %25s %32s %25.2f\n", getUsername(), getDateOfBirth(),
				getSalaryCoefficient(), getDepartmentName(), getManagerName(), calSalary());
	}

	@Override
	Double calSalary() {

		return (getSalaryCoefficient() * 1250000);
	}

}
