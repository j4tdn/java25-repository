package bt4;

public class Director extends Staff {
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
	public double calculateSalary() {
		return (getSalaryCoefficient() + positionCoefficient) * 3000000;
	}

	@Override
	public String toString() {
		return "Director [fullName=" + getFullName() + ", birthDate=" + getBirthDate() + ", salaryCoefficient="
				+ getSalaryCoefficient() + ", positionCoefficient=" + positionCoefficient + ", salary="
				+ String.format("%,.0f", calculateSalary()) + "]";
	}
	public void showInfo() {
	    System.out.println("Director [fullName=" + getFullName() 
	        + ", birthDate=" + getBirthDate()
	        + ", salaryCoefficient=" + getSalaryCoefficient()
	        + ", positionCoefficient=" + positionCoefficient + "]");
	}

}
