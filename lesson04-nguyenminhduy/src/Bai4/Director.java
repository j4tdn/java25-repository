package Bai4;

public class Director extends Person {
	
	private double PositionCoefficient;
	
	public Director() {
	}

	public Director(String name, String birthDay, Double salary, double positionCoefficient) {
		super(name, birthDay, salary);
		PositionCoefficient = positionCoefficient;
	}
	
	public double DirectorSalary() {
		return (Salary  + PositionCoefficient) * 3000000;
	}

	@Override
	public void infor() {
		System.out.println("Director [PositionCoefficient=" + PositionCoefficient + ", Name=" + Name + ", BirthDay=" + BirthDay
				+ ", Salary=" + Salary + ", DirectorSalary()=" + DirectorSalary() + "]");
	}
}
