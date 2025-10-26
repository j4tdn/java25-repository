package ex04;

public class Manager extends Employee {
	protected String nameOfUnit;

	public Manager() {
		
	}

	public Manager(String fullName, String birthDate, double salary, double position,String nameOfUnit) {
		super(fullName,birthDate,salary,position);
		this.nameOfUnit = nameOfUnit;
	}
	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		return (salary+position)*2200000;
	}

	@Override
	public String toString() {
		return  "Manager [nameOfUnit=" + nameOfUnit +"fullName" + fullName + ", birthDate=" + birthDate + ", salary=" + salary + ", position="
				+ position+ "]";
	}
	
	
	
	
}
