package bt4;

public class Manager extends Staff {

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
	public double calculateSalary() {
		return (getSalaryCoefficient() + positionCoefficient) * 2200000;
	}

	@Override
	public String toString() {
		return "Manager [fullName=" + getFullName() + ", birthDate=" + getBirthDate() + ", salaryCoefficient="
				+ getSalaryCoefficient() + ", positionCoefficient=" + positionCoefficient + ", departmentName="
				+ departmentName + ", salary=" + String.format("%,.0f", calculateSalary()) + "]";
	}
	public void showInfo() {
	    System.out.println("Manager [fullName=" + getFullName() 
	        + ", birthDate=" + getBirthDate() 
	        + ", salaryCoefficient=" + getSalaryCoefficient()
	        + ", positionCoefficient=" + positionCoefficient 
	        + ", departmentName=" + departmentName + "]");
	}

}
