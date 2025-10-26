package lesson04;

import java.time.LocalDate;

public class People {
	private String name;
	private LocalDate birthday;
	private double salary;

	public People() {
	}

	public People(String name, LocalDate birthday, double salary) {
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void showInfo() {
		System.out.println("Họ tên: " + name);
		System.out.println("Ngày sinh: " + birthday);
		System.out.println("Hệ số lương: " + salary);
	}

	public double calcSalary() {
		return 0;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", birthday=" + birthday + ", salary=" + salary + "]";
	}

}
