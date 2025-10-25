package Ex01;

public class Student {
	private Integer id;
	private String fullName;
	private Double theoryPoint;
	private Double practicePoint;
	
	public Student() {
		
	}

	public Student(Integer id, String fullName, Double theoryPoint, Double practicePoint) {
		
		this.id = id;
		this.fullName = fullName;
		this.theoryPoint = theoryPoint;
		this.practicePoint = practicePoint;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Double getTheoryPoint() {
		return theoryPoint;
	}

	public void setTheoryPoint(double theoryPoint) {
		this.theoryPoint = theoryPoint;
	}

	public Double getPracticePoint() {
		return practicePoint;
	}

	public void setPracticePoint(double practicePoint) {
		this.practicePoint = practicePoint;
	}
	
	public Double getCaculateAverage() {
		return (theoryPoint + practicePoint)/2;
	}
	
	@Override
	public String toString() {
		
		return "ID: " + id + ", Full Name: " + getFullName() + ", Theory Point: " + getTheoryPoint() 
				+ ", Practice Point: " + getPracticePoint() + ", Average Point: " + getCaculateAverage();
	}
	
}
