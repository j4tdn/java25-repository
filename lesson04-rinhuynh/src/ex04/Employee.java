package ex04;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public abstract class Employee {
	private String fullName;
	private LocalDate birthDate;
	private double salaryCoefficient;
	
	private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String fullName, String birthDate, double salaryCoefficient) {
		super();
		this.fullName = fullName;
		this.birthDate = LocalDate.parse(birthDate, DF);
		this.salaryCoefficient = salaryCoefficient;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = LocalDate.parse(birthDate, DF);
	}

	public double getSalaryCoefficient() {
		return salaryCoefficient;
	}

	public void setSalaryCoefficient(double salaryCoefficient) {
		this.salaryCoefficient = salaryCoefficient;
	}

	public static DateTimeFormatter getDf() {
		return DF;
	}
	
    public int getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    public abstract double getSalary();

	@Override
	public String toString() {
		return "Employee ["
				+ "fullName=" + fullName 
				+ ", birthDate=" + birthDate.format(DF) 
				+ ", Age()=" + getAge() 
				+ ", salaryCoefficient=" + salaryCoefficient 
				+ "]";
	}

}
