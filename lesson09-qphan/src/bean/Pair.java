package bean;

public class Pair {
	
	private Student student;
	private int count;
	
	public Pair(Student student, int count) {
		this.student = student;
		this.count = count;
	}

	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}

	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public void plusCount() {
		this.count++;
	}

	@Override
	public String toString() {
		return "Student([" + student.getId() + "-" + student.getName() + "], " + count + ")";
	}
	
	
	
}
