package ex04;

public class Director extends Employee {

	public Director() {
	}

	public Director(String fullName, String birthDate, double salary, double position) {
		super(fullName,birthDate,salary,position);
	}
	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		return (salary+position)*3000000;
	}
	@Override
	public String toString() {
		return "Director [fullName=" + fullName + ", birthDate=" + birthDate + ", salary=" + salary + ", position="
				+ position + "]";
	}
	
}
