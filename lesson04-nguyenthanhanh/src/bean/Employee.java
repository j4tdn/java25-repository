package bean;

public abstract class Employee {
	
	protected String fullName;
	protected String dateOfBirth;
	protected double salaryCoefficient;
	
	public Employee() {
		
	}

	public Employee(String fullName, String dateOfBirth, double salaryCoefficient) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.salaryCoefficient = salaryCoefficient;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getSalaryCoefficient() {
		return salaryCoefficient;
	}

	public void setSalaryCoefficient(double salaryCoefficient) {
		this.salaryCoefficient = salaryCoefficient;
	}
	
	public abstract double getSalary();

	@Override
	public String toString() {
		return "Employee [fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", salaryCoefficient="
				+ salaryCoefficient + "]";
	}
	
}
