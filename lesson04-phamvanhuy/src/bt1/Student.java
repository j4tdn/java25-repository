package bt1;

import java.util.Scanner;

public class Student {
	
	private Integer studentId;
	private String fullName;
	private Double theoryScore;
	private Double practiceScore;
	
	public Student() {
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
	public Double averageScore() {
		return (theoryScore + practiceScore) / 2;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", fullName=" + fullName + ", theoryScore=" + theoryScore
				+ ", practiceScore=" + practiceScore + ", averageScore()=" + averageScore() + "]";
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã số sinh viên: ");
		setStudentId(sc.nextInt());
		sc.nextLine();
		System.out.println("Nhập họ và tên: ");
		setFullName(sc.nextLine());
		System.out.println("Nhập điểm lý thuyết: ");
		setTheoryScore(sc.nextDouble());
		System.out.println("Nhập điểm thực hành: ");
		setPracticeScore(sc.nextDouble());
		
	}
}
