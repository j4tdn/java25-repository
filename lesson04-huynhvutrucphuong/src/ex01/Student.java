package ex01;

public class Student {
	private Integer studentId;
    private String fullName;
    private Double theoryScore;
    private Double practiceScore;
	public Student() {
		super();
	}
	public Student(Integer studentId, String fullName, Double theoryScore, Double practiceScore) {
		super();
		this.studentId = studentId;
		this.fullName = fullName;
		this.theoryScore = theoryScore;
		this.practiceScore = practiceScore;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Double getTheoryScore() {
		return theoryScore;
	}
	public void setTheoryScore(Double theoryScore) {
		this.theoryScore = theoryScore;
	}
	public Double getPracticeScore() {
		return practiceScore;
	}
	public void setPracticeScore(Double practiceScore) {
		this.practiceScore = practiceScore;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", fullName=" + fullName + ", theoryScore=" + theoryScore
				+ ", practiceScore=" + practiceScore + " Average: " + String.format("%.2f", getAverageScore()) + "]";
	}
	public Double getAverageScore() {
        return (theoryScore + practiceScore) / 2;
    }
}
