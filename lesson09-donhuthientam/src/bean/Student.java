package bean;

public class Student {
	private int id;
	private String name;
	private char rank;
	
	public Student() {
	}

	public Student(int id, String name, char rank) {
		super();
		this.id = id;
		this.name = name;
		this.rank = rank;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getRank() {
		return rank;
	}

	public void setRank(char rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "StudentList [id=" + id + ", name=" + name + ", rank=" + rank + "]";
	}
	
	

}
