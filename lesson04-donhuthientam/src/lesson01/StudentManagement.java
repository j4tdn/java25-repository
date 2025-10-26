package lesson01;

public class StudentManagement {
	private int number;
	private String name;
	private double Theoretical;
	private double Practice;
	
	public StudentManagement() {
	}

	public StudentManagement(int number, String name, double theoretical, double practice) {
		super();
		this.number = number;
		this.name = name;
		Theoretical = theoretical;
		Practice = practice;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTheoretical() {
		return Theoretical;
	}

	public void setTheoretical(double theoretical) {
		Theoretical = theoretical;
	}

	public double getPractice() {
		return Practice;
	}

	public void setPractice(double practice) {
		Practice = practice;
	}
	
	public double avg() {
		return (Theoretical + Practice) / 2;
	}

	@Override
	public String toString() {
		return "StudentInfo [number=" + number + ", name=" + name + ", Theoretical=" + Theoretical + ", Practice="
				+ Practice + "]";
	}
	
	
	

}
