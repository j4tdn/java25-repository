package bean;

import java.time.LocalDate;

public abstract class AllEmployee {
	protected String name;
	protected LocalDate birthDay;
	protected Double salary;
	
	public AllEmployee() {
	}

	public AllEmployee(String name, LocalDate birthDay, Double salary) {
		super();
		this.name = name;
		this.birthDay = birthDay;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public abstract double calcSalary();

	@Override
	public String toString() {
		return "AllEmployee [name=" + name + ", birthDay=" + birthDay + ", salary=" + salary + "]";
	}
	
	
}
