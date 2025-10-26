package ex04;

public class Director extends Employee {
	private double positionCoefficient;
	
	public Director() {
	}

	public Director(String fullName, String birthDate, double salaryCoefficient, double positionCoefficient) {
		super(fullName, birthDate, salaryCoefficient);
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
		return (getSalaryCoefficient() + positionCoefficient)*3000000;
	}

	
}
