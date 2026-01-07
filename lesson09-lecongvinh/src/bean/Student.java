package bean;

public class Student {
	private int id;
	private String name;
	private char mark;
	public Student(int id, String name, char mark) {
		
		this.id = id;
		this.name = name;
		this.mark = mark;
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
	public char getMark() {
		return mark;
	}
	public void setMark(char mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "Student: " + name + ", ID: " + id + ", Point: " + mark;
	}
	
	
}
