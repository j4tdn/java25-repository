package lesson04;

import java.time.LocalDate;

public class Director extends People {
	private double position;
	
	public Director() {
	}

	public Director(String name, LocalDate birthday, double salary, double position) {
		super(name, birthday, salary);
		this.position = position;
	}

	public double getPosition() {
		return position;
	}

	public void setPosition(double position) {
		this.position = position;
	}
	
	@Override
	public void showInfo() {
		System.out.println("\n=== Giám đốc ===");
		super.showInfo();
		System.out.println("CHUC VU: " + position);
		System.out.println("MUC LUONG: " + calcSalary());
	}
	
	@Override
	public double calcSalary() {
		return (getSalary() + position) * 3000000;
	}

	@Override
	public String toString() {
		return "Manager [getName()=" + getName() + ", getBirthday()=" + getBirthday()
				+ ", getSalary()=" + getSalary() + "position=" + position + "]";
	}
	
	
	
	
	
	

}
