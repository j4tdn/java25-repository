package lesson04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager extends People {
	private double position;
	private String office;
	List<Staff> staffList = new ArrayList<>();

	public Manager() {
	}

	public Manager(String name, LocalDate birthday, double salary, double position, String office) {
		super(name, birthday, salary);
		this.position = position;
		this.office = office;
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

	public List<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

	public void Add(Staff nv) {
		staffList.add(nv);
	}

	public int isStaff() {
		return staffList.size();
	}

	@Override
	public void showInfo() {
		System.out.println("\n=== TRUONG PHONG ===");
		super.showInfo();
		System.out.println("CHUC VU: " + position);
		System.out.println("PHONG BAN: " + office);
		System.out.println("MUC LUONG: " + calcSalary());
	}

	@Override
	public double calcSalary() {
		return (getSalary() + position) * 2200000;
	}

	@Override
	public String toString() {
		return "Manager [ getName()=" + getName() + ", getBirthday()=" + getBirthday() + ", getSalary()=" + getSalary()
				+ "position=" + position + ", office=" + office + ", staffList=" + staffList + "]";
	}

}
