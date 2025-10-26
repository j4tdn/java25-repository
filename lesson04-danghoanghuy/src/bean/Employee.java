package bean;

import java.time.LocalDate;

public class Employee extends AllEmployee {
	private String room;
	private DepartmentHead departmentHead;
	
	public Employee() {
	}

	public Employee(String name, LocalDate birthDay, Double salary, String room, DepartmentHead departmentHead) {
		super(name, birthDay, salary);
		this.room = room;
		this.departmentHead = departmentHead;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public DepartmentHead getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(DepartmentHead departmentHead) {
		this.departmentHead = departmentHead;
	}

	@Override
	public double calcSalary() {
		return (this.salary + 0) * 1250000;
	}
	
	@Override
	public String toString() {
		return "Employee [Name=" + getName() + ", Birth Day=" + getBirthDay()
				+ ", Salary=" + getSalary() + ", Room=" + room + ", Department Head= " + departmentHead + "]";
	}
	
}
