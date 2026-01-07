package ex01;

import java.util.ArrayList;
import java.util.List;

public class FindStudents {
	
	public static Student[] getStudentsA(Student[] students) {
		List<Student> result = new ArrayList<>();
		for(Student s: students) {
			if(s.grade.equals("A")) result.add(s);
		}
		return result.toArray(new Student[0]);
	}
	
	public static Student[] getStudentsRestu(Student[] students) {
		List<Student> result = new ArrayList<>();
		for(int i = 0; i<students.length; i++) {
			int count = 0;
			for(int j = 0; j < students.length; j++) {
				if(students[i].id == students[j].id) count++;
			}
			if(count>1 && !contains(result, students[i].id)) {
				result.add(students[i]);
			}
		}
		
		return result.toArray(new Student[0]);
	}
	
	private static boolean contains(List<Student> list, int id) {
		for(Student s: list) {
			if(s.id == id) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
		Student[] students =
		{
		new Student(102, "Nam", "C"),
		new Student(103, "Bảo", "F"),
		new Student(104, "Hoàng", "D"),
		new Student(105, "Nguyên", "B"),
		new Student(107, "Vũ", "F"),
		new Student(109, "Lan", "A"),
		new Student(202, "Đạt", "C"),
		new Student(103, "Bảo", "F"),
		new Student(107, "Vũ", "C"),
		new Student(104, "Hoàng", "B")
		};
		
		System.out.println("Sinh viên từng đạt loại A trong năm 2024 là: ");
		for(Student s: getStudentsA(students)) System.out.println(s);
		
		System.out.println("Danh sách sinh viên đã tham gia học lại(học nhiều hơn 1 lần)môn cấu trúc dữ liệu trong năm 2024 là: ");
		for(Student a: getStudentsRestu(students)) System.out.println(a);
		
	}
	
}
