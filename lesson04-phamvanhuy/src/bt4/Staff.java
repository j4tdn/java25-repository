package bt4;

public class Staff {
    private String fullName;
    private String birthDate;
    private double salaryCoefficient;

    public Staff() {
    }

    public Staff(String fullName, String birthDate, double salaryCoefficient) {
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

    public double calculateSalary() {
        return salaryCoefficient * 1000000;
    }

    @Override
    public String toString() {
        return "Staff [fullName=" + fullName + ", birthDate=" + birthDate
                + ", salaryCoefficient=" + salaryCoefficient + "]";
    }
}

