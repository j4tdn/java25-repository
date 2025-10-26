package lab1;

public class Students {
	private Integer id;
	private String name;
	private Double theoryScore;
	private Double practiceScore;

	public Students() {
		// TODO Auto-generated constructor stub
	}

	public Students(Integer id, String name, Double theoryScore, Double practiceScore) {
		super();
		this.id = id;
		this.name = name;
		this.theoryScore = theoryScore;
		this.practiceScore = practiceScore;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Students [id=" + id + ", name=" + name + ", theoryScore=" + theoryScore + ", practiceScore="
				+ practiceScore + "]";
	}

	public Double calculateAverageScore() {
		return (theoryScore + practiceScore) / 2;
	}

}
