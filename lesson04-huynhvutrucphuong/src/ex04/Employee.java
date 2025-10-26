package ex04;

public class Employee {
	protected String fullName;
    protected String birthDate;
    protected double salary;
    protected double position;
	public Employee() {
	
	}
	public Employee(String fullName, String birthDate, double salary, double position) {
		super();
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.salary = salary;
		this.position = position;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getPosition() {
		return position;
	}
	public void setPosition(double position) {
		this.position = position;
	}
	public double calculateSalary() {
        return (salary + position) * 1_250_000;
    }
	@Override
	public String toString() {
		return "Employee [fullName=" + fullName + ", birthDate=" + birthDate + ", salary=" + salary + ", position="
				+ position + "]";
	}
    
    
}
