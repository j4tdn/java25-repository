package persistence;

public class StudentAverage {
	private int id;
	private String name;
	private String className;
	private double average;

	public StudentAverage(int id, String name, String className, double average) {
		this.id = id;
		this.name = name;
		this.className = className;
		this.average = average;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getClassName() {
		return className;
	}

	public double getAverage() {
		return average;
	}

	@Override
	public String toString() {
		return String.format("id=%d | %s | lop %s | diem TB = %.2f", id, name, className, average);
	}
}