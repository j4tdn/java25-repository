package Bai4;

public class HeadofDepartment extends Person {
	
	private double PositionCoefficient;
	private String department;
	
	public HeadofDepartment() {
	}

	public HeadofDepartment(String name, String birthDay, Double salary, double positionCoefficient,
			String department) {
		super(name, birthDay, salary);
		PositionCoefficient = positionCoefficient;
		this.department = department;
	}
	
	public double HoDSalary() {
		return (Salary  + PositionCoefficient) * 2200000;
	}

	@Override
	public void infor() {
		System.out.println("HeadofDepartment [PositionCoefficient=" + PositionCoefficient + ", department=" + department + ", Name="
				+ Name + ", BirthDay=" + BirthDay + ", Salary=" + Salary + ", HoDSalary()=" + HoDSalary() + "]");
	}
	
	public String getdepartment() {
		return department;
	}

}
