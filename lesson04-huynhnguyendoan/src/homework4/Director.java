package homework4;

public class Director extends Person{

	public Director(String fullName, String dateOfBirth, double salaryCoefficient, double positionCoefficent) {
		super(fullName, dateOfBirth, salaryCoefficient, positionCoefficent);
		
	}


	@Override
	public long getSalary() {
		return (long) ((getSalaryCoefficient()+getPositionCoefficent()) *3000000);
	}

	@Override
	public String toString() {
		return "Giam Doc |" + super.toString() + "| Luong: " + getSalary();
	}

	
	
	

}
