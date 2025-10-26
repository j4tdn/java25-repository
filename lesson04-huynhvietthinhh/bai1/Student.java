
public class Student {
    // Các thuộc tính
    private Integer studentId;
    private String fullName;
    private Double theoryScore;
    private Double practiceScore;

    public Student() {
    }

 
    public Student(Integer studentId, String fullName, Double theoryScore, Double practiceScore) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.theoryScore = theoryScore;
        this.practiceScore = practiceScore;
    }

 
    public Integer getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public Double getTheoryScore() {
        return theoryScore;
    }

    public Double getPracticeScore() {
        return practiceScore;
    }


    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setTheoryScore(Double theoryScore) {
        this.theoryScore = theoryScore;
    }

    public void setPracticeScore(Double practiceScore) {
        this.practiceScore = practiceScore;
    }

  
    public Double calculateAverageScore() {
        if (theoryScore == null || practiceScore == null) {
            return null;
        }
        return (theoryScore + practiceScore) / 2.0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                ", theoryScore=" + theoryScore +
                ", practiceScore=" + practiceScore +
                ", averageScore=" + calculateAverageScore() +
                '}';
    }
}


