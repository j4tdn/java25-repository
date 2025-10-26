package lab3;

import java.time.LocalDate;

public class Director extends Staff {
	private Double position_coefficient;

	public Director() {
		// TODO Auto-generated constructor stub
	}

	public Director(String username, LocalDate dateOfBirth, Double salary_Coefficient, Double position_coefficient) {
		super(username, dateOfBirth, salary_Coefficient);
		this.position_coefficient = position_coefficient;
	}

	public Double getPositionCoefficient() {
		return position_coefficient;
	}

	public void setPositionCoefficient(Double positionCoefficient) {
		this.position_coefficient = positionCoefficient;
	}

	@Override
	public String toString() {
		return "[ getUsername()=" + getUsername() + ", getDateOfBirth()=" + getDateOfBirth()
				+ ", getSalaryCoefficient()=" + getSalaryCoefficient() + "Director [positionCoefficient="
				+ position_coefficient + "]";
	}

	public void displayInfo() {
		System.out.printf(" %10s %20s %20s %25s\n ", "User Name", "Date Of Birth", "Salary Coefficient",
				"Position Coefficient");
		System.out.printf("%10s %17s %15.2f %20.2f\n", getUsername(), getDateOfBirth(), getSalaryCoefficient(),
				getPositionCoefficient());
	}

	public void displaySalary() {
		System.out.printf(" %10s %20s %20s %25s %25s\n ", "User Name", "Date Of Birth", "Salary Coefficient",
				"Position Coefficient", "Salary");
		System.out.printf("%10s %17s %15.2f %20.2f %35.2f\n", getUsername(), getDateOfBirth(), getSalaryCoefficient(),
				getPositionCoefficient(), calSalary());
	}

	@Override
	Double calSalary() {

		return (getPositionCoefficient() + getSalaryCoefficient()) * 3000000;

	}

}
