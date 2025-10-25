package Bai4;

public class Person {
	
	public String Name;
	public String BirthDay;
	public Double Salary;
	
	public Person() {
	}

	public Person(String name, String birthDay, Double salary) {
		super();
		Name = name;
		BirthDay = birthDay;
		Salary = salary;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBirthDay() {
		return BirthDay;
	}

	public void setBirthDay(String birthDay) {
		BirthDay = birthDay;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

	public void infor() {
		System.out.println( "Person [Name=" + Name + ", BirthDay=" + BirthDay + ", Salary=" + Salary + "]");
	}
	
}
