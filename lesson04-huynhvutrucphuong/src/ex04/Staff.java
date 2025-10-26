package ex04;

public class Staff extends Employee {
	private String nameOfUnit;
	private String nameManagement;
	public Staff() {
		
	}
	public Staff(String fullName, String birthDate, double salary,double positon,String nameOfUnit, String nameManagement) {
		super(fullName,birthDate,salary,positon);
		this.nameOfUnit = nameOfUnit;
		this.nameManagement = nameManagement;
	}
	@Override
	public String toString() {
		return "Staff [nameOfUnit=" + nameOfUnit + ", nameManagement=" + nameManagement +  fullName + ", birthDate=" + birthDate + ", salary=" + salary + ", position="
				+ position+ "]";
	}
	
	
}
