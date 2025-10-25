package bean;

public class Staff extends Employee{
    
    
    private double salaryCoefficient;
    private String department;
    private DepartmentHead departmentHead;
    
    
    
    public Staff(String fullName, String dateOfBirth, double salaryCoefficient, String department,
			DepartmentHead departmentHead) {
		super(fullName, dateOfBirth);
		this.salaryCoefficient = salaryCoefficient;
		this.department = department;
		this.departmentHead = departmentHead;
	}
    

	public double getSalaryCoefficient() {
		return salaryCoefficient;
	}


	public void setSalaryCoefficient(double salaryCoefficient) {
		this.salaryCoefficient = salaryCoefficient;
	}



	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public DepartmentHead getDepartmentHead() {
		return departmentHead;
	}


	public void setDepartmentHead(DepartmentHead departmentHead) {
		this.departmentHead = departmentHead;
	}


	@Override
    public String toString() {
        return "Staff [fullName=" + fullName 
                + ", dateOfBirth=" + dateOfBirth
                + ", salaryCoefficient=" + salaryCoefficient
                + ", department=" + department
                + ", departmentHead=" + departmentHead + "]";
    }


	@Override
	public double getSalary() {
		return salaryCoefficient * 1250000;

	}
}
