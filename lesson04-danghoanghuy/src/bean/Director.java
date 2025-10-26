package bean;

import java.time.LocalDate;

public class Director extends AllEmployee{
	private Double role;
	
	public Director() {
	}

	public Director(String name, LocalDate birthDay, Double salary, Double role) {
		super(name, birthDay, salary);
		this.role = role;
	}

	public Double getRole() {
		return role;
	}

	public void setRole(Double role) {
		this.role = role;
	}
	
	@Override
	public double calcSalary() {
		return (this.salary + this.role) * 3000000;
	}

	@Override
	public String toString() {
		return "Director [Name=" + getName() + ", Birth Day=" + getBirthDay()
				+ ", Salary=" + getSalary() + ", Role=" + role + "]";
	}
	
	
}
