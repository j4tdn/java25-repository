package Ex04;

public class Employee extends Company {
    private String departmentName;
    private Manager manager;

    public Employee() {}

    public Employee(String fullName, String birthDate, double salaryCoefficient, String departmentName, Manager manager) {
        super(fullName, birthDate, salaryCoefficient);
        this.departmentName = departmentName;
        this.manager = manager;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public double calculateSalary() {
        return getSalaryCoefficient() * 1250000;
    }

    @Override
    public String toString() {
        return "[Employee] " + super.toString() + ", Department: " + departmentName +
               ", Manager: " + manager.getFullName() + ", Salary: " + calculateSalary();
    }
}
