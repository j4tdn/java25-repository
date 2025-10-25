package bean;

public class Staff extends Employee {
	
	private String department;
    private DepartmentHead departmentHead;
    
    public Staff() {
    	
    }
    
    public Staff(String fullName, String dateOfBirth, double salaryCoefficient, String department) {
		super(fullName, dateOfBirth, salaryCoefficient);
		this.department = department;
	}
    
    public Staff(String fullName, String dateOfBirth, double salaryCoefficient, String department,
			DepartmentHead departmentHead) {
		super(fullName, dateOfBirth, salaryCoefficient);
		this.department = department;
		this.departmentHead = departmentHead;
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
	public double getSalary() {
		return salaryCoefficient * 1250000;
	}

	@Override
	public String toString() {
		return "Staff [department=" + department + ", departmentHead=" + departmentHead + ", fullName=" + fullName
				+ ", dateOfBirth=" + dateOfBirth + ", salaryCoefficient=" + salaryCoefficient + "]";
	}
	
}
