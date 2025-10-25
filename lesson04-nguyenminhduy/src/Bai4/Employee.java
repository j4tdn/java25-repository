package Bai4;

public class Employee extends Person {
	
	private String department;
	private String HoDName;
	
	public Employee() {
	}

	public Employee(String name, String birthDay, Double salary, String department, String hoDName) {
		super(name, birthDay, salary);
		this.department = department;
		HoDName = hoDName;
	}
	
	public double ESalary() {
		return Salary + 1250000;
	}
	
	public String getHoDName() {
		return HoDName;
	}

	@Override
	public void infor() {
		System.out.println("Employee [department=" + department + ", HoDName=" + HoDName + ", Name=" + Name + ", BirthDay="
				+ BirthDay + ", Salary=" + Salary + ", ESalary()=" + ESalary() + ", getHoDName()=" + getHoDName() + "]");
	}
	
	

}
