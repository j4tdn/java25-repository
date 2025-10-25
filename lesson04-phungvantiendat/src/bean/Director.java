package bean;

public class Director extends Employee {

	protected double positionCoefficient;
	protected double salaryCoefficient;

	public Director(String fullName, String dateOfBirth, double positionCoefficient, double salaryCoefficient) {
		super(fullName, dateOfBirth);
		this.positionCoefficient = positionCoefficient;
		this.salaryCoefficient = salaryCoefficient;
	}

	public double getPositionCoefficient() {
		return positionCoefficient;
	}

	public void setPositionCoefficient(double positionCoefficient) {
		this.positionCoefficient = positionCoefficient;
	}

	

	public double getSalaryCoefficient() {
		return salaryCoefficient;
	}

	public void setSalaryCoefficient(double salaryCoefficient) {
		this.salaryCoefficient = salaryCoefficient;
	}

	@Override
	public String toString() {
	    return "Director [fullName=" + getFullName() + ", dateOfBirth=" + getDateOfBirth()
	            + ", positionCoefficient=" + positionCoefficient +  ", salaryCoefficient=" + salaryCoefficient + "]";
	}

	@Override
	public double getSalary() {
		return (salaryCoefficient + positionCoefficient) * 3000000;
	}

}
