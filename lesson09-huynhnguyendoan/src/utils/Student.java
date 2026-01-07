package utils;

public class Student {
	private int id;
	private String name;
	private char grade;

	public Student(int id, String name, char grade) {

		this.id = id;
		this.name = name;
		this.grade = grade;
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

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return id + " - " + name + " - " + grade;
	}

	public static Student[] getStudentsGradeA(Student[] students) {
		int count = 0;
		for (Student s : students) {
			if (s.getGrade() == 'A') {
				count++;
			}
		}
		Student[] result = new Student[count];
		int index = 0;
		for (Student s : students) {
			if (s.getGrade() == 'A') {
				result[index++] = s;
			}
		}
		return result;

	}

	public static Student[] getStudentRetake(Student[] students) {
		int s = students.length;
		boolean[] add = new boolean[s];
		int count = 0;

		for (int i = 0; i < s; i++) {
			if (students[i].getGrade() == 'F') {
				int timecount = 1;
				for (int j = i + 1; j < s; j++) {
					if (students[i].getId() == students[j].getId() && students[j].getGrade() == 'F') {
						timecount++;
					}
				}
				if (timecount > 1 && !add[i]) {
					count++;
					add[i] = true;
				}
			}
		}
		Student[] result = new Student[count];
		int index = 0;
		for (int i = 0; i < s; i++) {
			if (add[i]) {
				result[index++] = students[i];
			}
		}
		return result;
	}

}
