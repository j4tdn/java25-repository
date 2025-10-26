package Ex04;

public class Director extends Company {
    private double positionCoefficient;

    public Director() {}

    public Director(String fullName, String birthDate, double salaryCoefficient, double positionCoefficient) {
        super(fullName, birthDate, salaryCoefficient);
        this.positionCoefficient = positionCoefficient;
    }

    public double getPositionCoefficient() {
        return positionCoefficient;
    }

    public void setPositionCoefficient(double positionCoefficient) {
        this.positionCoefficient = positionCoefficient;
    }

    @Override
    public double calculateSalary() {
        return (getSalaryCoefficient() + positionCoefficient) * 3000000;
    }

    @Override
    public String toString() {
        return "[Director] " + super.toString() + ", Position Coefficient: " + positionCoefficient +
               ", Salary: " + calculateSalary();
    }
}
