package bean;

import java.math.BigDecimal;

public class Student {
	
	private long studentId;
	private String fullName;
	private BigDecimal theoryPoint;
	private BigDecimal practicePoint;
	
	public Student() {
		
	}

	public Student(long studentId, String fullName, BigDecimal theoryPoint, BigDecimal practicePoint) {
		this.studentId = studentId;
		this.fullName = fullName;
		this.theoryPoint = theoryPoint;
		this.practicePoint = practicePoint;
	}
	
	public double getAvgPoint() {
		return (this.practicePoint.doubleValue() + this.theoryPoint.doubleValue()) / 2;
	}
	
	public boolean isAvgPointGreaterThanEight() {
		return getAvgPoint() > 8.5d;
	}
	
	public boolean isTheoryGreaterThanPractice() {
		return this.theoryPoint.doubleValue() > this.practicePoint.doubleValue();
	}
	

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public BigDecimal getTheoryPoint() {
		return theoryPoint;
	}

	public void setTheoryPoint(BigDecimal theoryPoint) {
		this.theoryPoint = theoryPoint;
	}

	public BigDecimal getPracticePoint() {
		return practicePoint;
	}

	public void setPracticePoint(BigDecimal practicePoint) {
		this.practicePoint = practicePoint;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", fullName=" + fullName + ", theoryPoint=" + theoryPoint
				+ ", practicePoint=" + practicePoint + ", avgPoint= "+ getAvgPoint() + "]";
	}
	
	
	
}
