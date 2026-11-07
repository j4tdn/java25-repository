package persistence;

public class Student {
	private int id;
	private String name;
	private boolean gender;
	private int cid;

	public Student(int id, String name, boolean gender, int cid) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.cid = cid;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isGender() {
		return gender;
	}

	public int getCid() {
		return cid;
	}

	@Override
	public String toString() {
		return "Student{id=" + id + ", name=" + name + ", gender=" + (gender ? 1 : 0) + ", cid=" + cid + "}";
	}
}