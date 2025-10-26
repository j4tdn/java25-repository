package bean;

import java.time.LocalDate;

public class DepartmentHead extends AllEmployee {
	private Double role;
	private String room;
	
	public DepartmentHead() {
	}

	public DepartmentHead(String name, LocalDate birthDay, Double salary, Double role, String room) {
		super(name, birthDay, salary);
		this.role = role;
		this.room = room;
	}

	public Double getRole() {
		return role;
	}

	public void setRole(Double role) {
		this.role = role;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
	@Override
	public double calcSalary() {
		return (this.salary + this.role) * 2200000;
	}

	@Override
	public String toString() {
		return "Department Head [Name=" + getName() + ", Birth Day=" + getBirthDay()
		+ ", Salary=" + getSalary() + ", Role=" + role + ", Room= " + room + "]";
	}
	
}
