package homework1;

public class Student {
	private Integer StudentID;
	private String FullName;
	private Double theoryScore;
	private Double practiceScore;
	
	public Student() {
		
	}

	public Student(Integer studentID, String fullName, Double theoryScore, Double practiceScore) {
		super();
		StudentID = studentID;
		FullName = fullName;
		this.theoryScore = theoryScore;
		this.practiceScore = practiceScore;
	}

	public Integer getStudentID() {
		return StudentID;
	}

	public void setStudentID(Integer studentID) {
		StudentID = studentID;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
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
	public Double getAverageScore() {
		return (theoryScore + practiceScore) /2;
	}
	public static void findStudentWithHighAverage(Student[] students) {
		for(Student s : students) {
			if(s.getAverageScore() > 8.5) {
				System.out.println(s);
			}
		}
	}
	public static void findStudentTheoryHigher(Student[] students) {
		for(Student s : students) {
			if(s.getTheoryScore() > s.getPracticeScore()) {
				System.out.println(s);
			}
		}
	}

	@Override
	public String toString() {
		return "Student [StudentID=" + StudentID + ", FullName=" + FullName + ", theoryScore=" + theoryScore
				+ ", practiceScore=" + practiceScore + "]";
	}
	
}
