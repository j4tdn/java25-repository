package ex01;

public class Student {
	int id;
	String name, grade;
	
	public Student() {
	}
	
	public Student(int id, String name, String grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}

}
