package Ex04;

public abstract class Company {
    private String fullName;
    private String birthDate;
    private double salaryCoefficient;

    public Company() {}

    public Company(String fullName, String birthDate, double salaryCoefficient) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.salaryCoefficient = salaryCoefficient;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public double getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setSalaryCoefficient(double salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Full Name: " + getFullName() + ", Birth Date: " + getBirthDate() +
               ", Salary Coefficient: " + getSalaryCoefficient();
    }
}
