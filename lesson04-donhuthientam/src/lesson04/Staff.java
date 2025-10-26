package lesson04;

import java.time.LocalDate;

public class Staff extends People {
	private double position;
	private String office;
	private Manager manager;

	public Staff() {
	}

	public Staff(String name, LocalDate birthday, double salary, double position, String office, Manager manager) {
		super(name, birthday, salary);
		this.position = position;
		this.office = office;
		this.manager = manager;
	}

	public double getPosition() {
		return position;
	}

	public void setPosition(double position) {
		this.position = position;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public void showInfo() {
		System.out.println("\n=== NHAN VIEN ===");
		super.showInfo();
		System.out.println("CHUC VU: " + position);
		System.out.println("MUC LUONG: " + calcSalary());
		System.out.println("TRUONG PHONG : " + super.getName());
	}

	@Override
	public double calcSalary() {
		return (getSalary() + position) * 1250000;
	}

	@Override
	public String toString() {
		return "Staff [ getName()=" + getName() + ", getBirthday()=" + getBirthday() + ", getSalary()=" + getSalary()
				+ "position=" + position + ", office=" + office + ", manager=" + manager + "]";
	}

}
