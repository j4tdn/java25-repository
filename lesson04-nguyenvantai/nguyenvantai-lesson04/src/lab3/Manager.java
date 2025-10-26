package lab3;

import java.time.LocalDate;

public class Manager extends Staff {
	private Double position_coefficient;
	private String departmentName;

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(String username, LocalDate dateOfBirth, Double salary_Coefficient, Double position_coefficient,
			String departmentName) {
		super(username, dateOfBirth, salary_Coefficient);
		this.position_coefficient = position_coefficient;
		this.departmentName = departmentName;
	}

	public Double getPosition_coefficient() {
		return position_coefficient;
	}

	public void setPosition_coefficient(Double position_coefficient) {
		this.position_coefficient = position_coefficient;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "[ getUsername()=" + getUsername() + ", getDateOfBirth()=" + getDateOfBirth()
				+ ", getSalaryCoefficient()=" + getSalaryCoefficient() + "Manager position_coefficient="
				+ getPosition_coefficient() + "Department Name: " + getDepartmentName() + "]";
	}

	public void displayInfo() {
		System.out.printf(" %10s %20s %20s %25s %25s\n ", "User Name", "Date Of Birth", "Salary Coefficient",
				"Position Coefficient", "Department Name");
		System.out.printf("%10s %17s %15.2f %20.2f %35s\n", getUsername(), getDateOfBirth(), getSalaryCoefficient(),
				getPosition_coefficient(), getDepartmentName());
	}

	public void displaySalary() {
		System.out.printf(" %10s %20s %20s %25s %25s %30s\n ", "User Name", "Date Of Birth", "Salary Coefficient",
				"Position Coefficient", "Department Name", "Salary");
		System.out.printf("%10s %17s %15.2f %20.2f %35s %30.2f\n", getUsername(), getDateOfBirth(),
				getSalaryCoefficient(), getPosition_coefficient(), getDepartmentName(), calSalary());
	}

	@Override
	Double calSalary() {
		return (getPosition_coefficient() + getSalaryCoefficient()) * 2200000;
	}

}
