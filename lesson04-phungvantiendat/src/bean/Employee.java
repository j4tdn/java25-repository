package bean;

public abstract class Employee {
	protected String fullName;
	protected String dateOfBirth;
	
	
	public Employee(String fullName, String dateOfBirth) {
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
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
	
	public abstract double getSalary();
	
	@Override
	public String toString() {
		return "Employee [fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}
