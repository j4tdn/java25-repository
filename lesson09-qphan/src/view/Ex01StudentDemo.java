package view;

import java.util.Arrays;
import java.util.Objects;

import bean.Pair;
import bean.Student;
import common.Rank;
import model.DataModel;

public class Ex01StudentDemo {

	public static void main(String[] args) {

		Student[] students = DataModel.mockStudents();

		generate("Tìm danh sách sinh viên từng đạt loại A trong năm 2024", findStudents(students, Rank.A));

		generate("Tìm danh sách sinh viên đã tham gia học lại(học nhiều hơn 1 lần) môn cấu trúc dữ liệu trong năm 2024",
				findStudents(students));

	}

	private static Pair get(Student student, Pair[] pairs, int currentLength) {
		Objects.requireNonNull(student, "student should not be null");
		for (int i = 0; i < currentLength; i++) {
			Pair pair = pairs[i];
			if (student.equals(pair.getStudent())) {
				return pair;
			}
		}
		return null;
	}

	private static Pair[] statisticStudentTestings(Student[] students) {
		Pair[] pairs = new Pair[students.length];
		int counter = 0;

		for (Student student : students) {
			Pair found = get(student, pairs, counter);
			if (found != null) {
				found.plusCount();
			} else {
				pairs[counter++] = new Pair(student, 1);
			}
		}

		return Arrays.copyOfRange(pairs, 0, counter);
	}

	private static Student[] findStudents(Student[] students) {
		Pair[] pairs = statisticStudentTestings(students);
		Student[] result = new Student[students.length];
		int counter = 0;
		for (Pair pair : pairs) {
			if (pair.getCount() > 1) {
				result[counter++] = pair.getStudent();
			}
		}
		return Arrays.copyOfRange(result, 0, counter);
	}

	private static Student[] findStudents(Student[] students, Rank rank) {
		Student[] result = new Student[students.length];
		int count = 0;
		for (Student student : students) {
			if (rank == student.getRank()) {
				result[count++] = student;
			}
		}
		return Arrays.copyOfRange(result, 0, count);
	}

	private static void generate(String prefix, Object[] objects) {
		System.out.println(prefix + " { ");
		for (Object student : objects) {
			System.out.println("   - " + student);
		}
		System.out.println("}");
	}
}
