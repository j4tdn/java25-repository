package persistence;

public class ClassSummary {
	private String className;
	private int total;
	private String studentNames;

	public ClassSummary(String className, int total, String studentNames) {
		this.className = className;
		this.total = total;
		this.studentNames = studentNames;
	}

	public String getClassName() {
		return className;
	}

	public int getTotal() {
		return total;
	}

	public String getStudentNames() {
		return studentNames;
	}

	@Override
	public String toString() {
		return "Lop " + className + " | so hoc sinh: " + total + (studentNames != null ? " | " + studentNames : "");
	}
}