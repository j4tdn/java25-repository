package Ex04;

public class Director {

	protected String name;
	protected String dateOfBirth;
	protected Float salarycoefficient;
	protected Float positioncoefficient;

	public Director() {
		
	}

	public Director(String name, String dateOfBirth, Float salarycoefficient, Float positioncoefficient) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.salarycoefficient = salarycoefficient;
		this.positioncoefficient = positioncoefficient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Float getSalarycoefficient() {
		return salarycoefficient;
	}

	public void setSalarycoefficient(Float salarycoefficient) {
		this.salarycoefficient = salarycoefficient;
	}

	public Float getPositioncoefficient() {
		return positioncoefficient;
	}

	public void setPositioncoefficient(Float positioncoefficient) {
		this.positioncoefficient = positioncoefficient;
	}

	public double getSalary() {
		return (salarycoefficient + positioncoefficient) * 3000000;
	}
	
	@Override
	public String toString() {
		return "Director: Họ và tên: " + name +" Năm sinh: "  + dateOfBirth + " Hệ số lương: " + salarycoefficient +" Hệ số chức vụ: " + positioncoefficient ;
	}
	
	
	
	
}
