package ex01;

public class Student {
	private String id;
	private String name;
	private Equivalent equivalent;

	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public Student(String id, String name, Equivalent equivalent) {
		super();
		this.id = id;
		this.name = name;
		this.equivalent = equivalent;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Equivalent getEquivalent() {
		return equivalent;
	}


	public void setEquivalent(Equivalent equivalent) {
		this.equivalent = equivalent;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", equivalent=" + equivalent + "]";
	}
	
	
	
}
