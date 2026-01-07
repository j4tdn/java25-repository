package ex01;

public class Ex01 {

	public static void main(String[] args) {
		Student[] students = {
				new Student(102, "Nam", 'C'),
				new Student(103, "Bảo", 'F'),
				new Student(104, "Hoàng", 'D'),
				new Student(105, "Nguyên", 'B'),
				new Student(107, "Vũ", 'F'),
				new Student(109, "Lan", 'A'),
				new Student(202, "Đạt", 'C'),
				new Student(103, "Bảo", 'F'),
				new Student(107, "Vũ", 'C'),
				new Student(104, "Hoàng", 'B')
				};
		System.out.println("Sinh viên từng đạt loại A : ");
		Student[] listA = StudentManager.getStudents(students);
		for(Student s: listA) {
			System.out.println(s);
		}
	}
}
