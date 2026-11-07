package dto;

public class StudentAvgDto {

    private int studentId;
    private String studentName;
    private String className;
    private double avgScore;

    public StudentAvgDto() {
    }

    public StudentAvgDto(int studentId, String studentName, String className, double avgScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.className = className;
        this.avgScore = avgScore;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public String toString() {
        return String.format("StudentAvgDto [studentId=%d, studentName=%s, className=%s, avgScore=%.2f]",
                studentId, studentName, className, avgScore);
    }
}
