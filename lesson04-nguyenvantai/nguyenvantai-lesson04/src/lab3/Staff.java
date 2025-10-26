package lab3;

import java.time.LocalDate;

public class Staff {
	private String username;
	private LocalDate dateOfBirth;
	private Double salary_Coefficient;

	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public Staff(String username, LocalDate dateOfBirth, Double salary_Coefficient) {
		this.username = username;
		this.dateOfBirth = dateOfBirth;
		this.salary_Coefficient = salary_Coefficient;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Double getSalaryCoefficient() {
		return salary_Coefficient;
	}

	public void setSalaryCoefficient(Double salary_Coefficient) {
		this.salary_Coefficient = salary_Coefficient;
	}

	@Override
	public String toString() {
		return "Staff [username=" + username + ", dateOfBirth=" + dateOfBirth + ", salaryCoefficient="
				+ salary_Coefficient + "]";
	}

	Double calSalary() {
		return null;
	}

}
