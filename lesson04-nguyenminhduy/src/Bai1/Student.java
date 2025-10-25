package Bai1;

public class Student {
	
	private int StudentId;
	private String Name;
	private	double TheoryScore;
	private double PracticeScore;
	
	public Student() {
	}

	public Student(int studentId, String name, double theoryScore, double practiceScore) {
		super();
		StudentId = studentId;
		Name = name;
		TheoryScore = theoryScore;
		PracticeScore = practiceScore;
	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getTheoryScore() {
		return TheoryScore;
	}

	public void setTheoryScore(double theoryScore) {
		TheoryScore = theoryScore;
	}

	public double getPracticeScore() {
		return PracticeScore;
	}

	public void setPracticeScore(double practiceScore) {
		PracticeScore = practiceScore;
	}
	
	public double getAverageScore() {
		return (TheoryScore + PracticeScore)/2;
	}

	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", Name=" + Name + ", TheoryScore=" + TheoryScore
				+ ", PracticeScore=" + PracticeScore + "]";
	}
	
	

}
