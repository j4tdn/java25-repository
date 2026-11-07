package dto;

public class ClassMaxAvgStudentDto {

    private int classId;
    private String className;
    private int studentId;
    private String studentName;
    private double maxAvgScore;

    public ClassMaxAvgStudentDto() {
    }

    public ClassMaxAvgStudentDto(int classId, String className, int studentId, String studentName, double maxAvgScore) {
        this.classId = classId;
        this.className = className;
        this.studentId = studentId;
        this.studentName = studentName;
        this.maxAvgScore = maxAvgScore;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public double getMaxAvgScore() {
        return maxAvgScore;
    }

    public void setMaxAvgScore(double maxAvgScore) {
        this.maxAvgScore = maxAvgScore;
    }

    @Override
    public String toString() {
        return String.format("ClassMaxAvgStudentDto [classId=%d, className=%s, studentId=%d, studentName=%s, maxAvgScore=%.2f]",
                classId, className, studentId, studentName, maxAvgScore);
    }
}
