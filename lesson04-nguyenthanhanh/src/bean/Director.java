package bean;

public class Director extends Employee {

	protected double positionCoefficient;
	
	public Director() {
		
	}
	
	public Director(String fullName, String dateOfBirth, double salaryCoefficient, double positionCoefficient) {
		super(fullName, dateOfBirth, salaryCoefficient);
		this.positionCoefficient = positionCoefficient;
	}

	public double getPositionCoefficient() {
		return positionCoefficient;
	}

	public void setPositionCoefficient(double positionCoefficient) {
		this.positionCoefficient = positionCoefficient;
	}
	
	@Override
	public double getSalary() {
		return (salaryCoefficient + positionCoefficient) * 3000000;
	}

	@Override
	public String toString() {
		return "Director [positionCoefficient=" + positionCoefficient + ", fullName=" + fullName + ", dateOfBirth="
				+ dateOfBirth + ", salaryCoefficient=" + salaryCoefficient + "]";
	}
	
}
