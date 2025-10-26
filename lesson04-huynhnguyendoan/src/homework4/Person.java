package homework4;

public abstract class Person {
	private String fullName;
	private String dateOfBirth;
	private double salaryCoefficient;
	private double positionCoefficent;
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getPositionCoefficent() {
		return positionCoefficent;
	}

	public void setPositionCoefficent(long positionCoefficent) {
		this.positionCoefficent = positionCoefficent;
	}

	public Person(String fullName, String dateOfBirth, double salaryCoefficient2, double positionCoefficent2) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.salaryCoefficient = salaryCoefficient2;
		this.positionCoefficent = positionCoefficent2;
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

	public void setSalaryCoefficient(long salaryCoefficient) {
		this.salaryCoefficient = salaryCoefficient;
	}
	
	public abstract long getSalary();
	
	

	@Override
	public String toString() {
		return "Ho ten: " + fullName +"| Ngay sinh: " + dateOfBirth +"| He so luong: " + salaryCoefficient +"| He so chuc vu: " + positionCoefficent;
	}
	


	
	
	
	
}
