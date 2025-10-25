package bean;

import java.math.BigDecimal;

public class Student {

	private long id;
	private String fullName;
	private BigDecimal theoryPoint;
	private BigDecimal practicePoint;
	
	public Student() {
		
	}

	public Student(long id, String fullName, BigDecimal theoryPoint, BigDecimal practicePoint) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.theoryPoint = theoryPoint;
		this.practicePoint = practicePoint;
	}
	
	public double getAvgPoint() {
		return (this.practicePoint.doubleValue() + this.theoryPoint.doubleValue()) / 2;
	}
	
	public boolean isAvgPointGreaterThanEightAHalf() {
		return this.getAvgPoint() > 8.5d;
	}
	
	public boolean isTheoryGreaterThanPractice() {
		return this.theoryPoint.doubleValue() > this.practicePoint.doubleValue();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return "Student [id=" + id + ", fullName=" + fullName + ", theoryPoint=" + theoryPoint + ", practicePoint="
				+ practicePoint + "]";
	}
	
}
