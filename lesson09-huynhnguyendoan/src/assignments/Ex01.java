package assignments;

import utils.Student;

public class Ex01 {
	public static void main(String[] args) {
		Student[] students = { new Student(102, "Nam", 'C'), new Student(103, "Bảo", 'F'),
				new Student(104, "Hoàng", 'D'), new Student(105, "Nguyên", 'B'), new Student(107, "Vũ", 'F'),
				new Student(109, "Lan", 'A'), new Student(202, "Đạt", 'C'), new Student(103, "Bảo", 'F'),
				new Student(107, "Vũ", 'C'), new Student(104, "Hoàng", 'B'), };
		System.out.println(" === Sinh viên loại A trong năm 2024 ===");
		Student[] listA = utils.Student.getStudentsGradeA(students);
		for (Student s : listA) {
			System.out.println(s);
		}

		System.out.println(" === sinh viên đã tham gia học lại nhiều hơn 1 lần === ");
		Student[] retake = utils.Student.getStudentRetake(students);
		for (Student s : retake) {
			System.out.println(s);
		}
	}
}
