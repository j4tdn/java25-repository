package Ex04;

public class Manager extends Company {
    private double positionCoefficient;
    private String departmentName;

    public Manager() {}

    public Manager(String fullName, String birthDate, double salaryCoefficient, double positionCoefficient, String departmentName) {
        super(fullName, birthDate, salaryCoefficient);
        this.positionCoefficient = positionCoefficient;
        this.departmentName = departmentName;
    }

    public double getPositionCoefficient() {
        return positionCoefficient;
    }

    public void setPositionCoefficient(double positionCoefficient) {
        this.positionCoefficient = positionCoefficient;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public double calculateSalary() {
        return (getSalaryCoefficient() + positionCoefficient) * 2200000;
    }

    @Override
    public String toString() {
        return "[Manager] " + super.toString() + ", Position Coefficient: " + positionCoefficient +
               ", Department: " + departmentName + ", Salary: " + calculateSalary();
    }
}
