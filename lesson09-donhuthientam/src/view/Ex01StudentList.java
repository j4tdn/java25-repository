package view;

import bean.Student;

public class Ex01StudentList {
	public static void main(String[] args) {
		Student[] student = { new Student(102, "Nam", 'C'), new Student(103, "Bảo", 'F'),
				new Student(104, "Hoàng", 'D'), new Student(105, "Nguyên", 'B'), new Student(107, "Vũ", 'F'),
				new Student(109, "Lan", 'A'), new Student(202, "Đạt", 'C'), new Student(103, "Bảo", 'F'),
				new Student(107, "Vũ", 'C'), new Student(104, "Hoàng", 'B') };

		System.out.println("=== Sinh viên đạt loại A trong năm 2024 ===");
		Student[] listA = getStudentsA(student);
		for (Student st : listA) {
			System.out.println(st);
		}

		System.out.println("==================");

		System.out.println("=== danh sách sinh viên đã tham gia học lại ===");

		Student[] listRank = getStudentRank(student);
		for (Student st : listRank) {
			System.out.println(st);
		}
	}

	private static Student[] getStudentRank(Student[] students) {
		Student[] list = new Student[students.length];
		int size = 0;
		

		for (int i = 0; i < students.length; i++) {
			int count = 0;
			for (int j = 0; j < students.length; j++) {
					if (students[i].getId() == students[j].getId()) {
						count++;
					}

			}
			if ((count > 1 || students[i].getRank() == 'F') && !check(list, size, students[i].getId())) {
				list[size++] = students[i];
			}

		}

		Student[] result = new Student[size];
		System.arraycopy(list, 0, result, 0, size);
		return result;
	}

	private static Student[] getStudentsA(Student[] students) {
		Student[] list = new Student[students.length];
		int count = 0;

		for (int i = 0; i < students.length; i++) {
			if (students[i].getRank() == 'A') {
				if (!check(list, count, students[i].getId())) {
					list[count++] = students[i];
				}
			}
		}
		Student[] result = new Student[count];
		System.arraycopy(list, 0, result, 0, count);
		return result;
	}

	private static boolean check(Student[] arr, int length, int id) {
		for (int i = 0; i < length; i++) {
			if (arr[i].getId() == id) {
				return true;
			}
		}
		return false;
	}

}
