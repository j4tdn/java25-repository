package homework4;

public class Employee extends Person {
	private String departmentName;
	private Manager manager;
	public Employee(String fullName, String dateOfBirth, double salaryCoefficient, double positionCoefficent,String departmentName, Manager manager) {
		super(fullName, dateOfBirth, salaryCoefficient, positionCoefficent);
		 this.departmentName = departmentName;
	        this.manager = manager;
	        manager.increaseEmployeeCount();
		
	}

	@Override
	public long getSalary() {
		
		return (long) ((getSalaryCoefficient() + getPositionCoefficent()) * 1250000);
	}

	@Override
	public String toString() {
		return "Nhan vien |" + super.toString() +"| Đon vv: " + departmentName +"| Truong phong: " + manager.getFullName() +"| Luong: " + getSalary();
	}

}
