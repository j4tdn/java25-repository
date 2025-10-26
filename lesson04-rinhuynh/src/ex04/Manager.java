package ex04;

public class Manager extends Employee {
	
	private double positionCoefficient;
	private String departmentName;
	
	
	public Manager() {
	}
	
	

	public Manager(String fullName, String birthDate, double salaryCoefficient, double positionCoefficient,
			String departmentName) {
		super(fullName, birthDate, salaryCoefficient);
		this.positionCoefficient = positionCoefficient;
		this.departmentName = departmentName;
	}





	public double getPositionCoefficient() {
		return positionCoefficient;
	}



	public void setPositionCoefficient(double positionCoefficient) {
		this.positionCoefficient = positionCoefficient;
	}



	public String getDepartmentName() {
		return departmentName;
	}



	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	

	@Override
	public double getSalary() {
		return (getSalaryCoefficient() + positionCoefficient) *2200000;
	}

	

}
