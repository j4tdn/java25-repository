package bean;

public class DepartmentHead extends Director {

	private String department;
	
	public DepartmentHead() {
		
	}
	
	public DepartmentHead(String fullName, String dateOfBirth, double positionCoefficient, double salaryCoefficient,
			String department) {
		super(fullName, dateOfBirth, positionCoefficient, salaryCoefficient);
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public double getSalary() {
		return (salaryCoefficient + positionCoefficient) * 2200000;
	}

	@Override
	public String toString() {
		return "DepartmentHead [department=" + department + ", positionCoefficient=" + positionCoefficient
				+ ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", salaryCoefficient=" + salaryCoefficient
				+ "]";
	}
	
}
