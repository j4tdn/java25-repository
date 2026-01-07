package view;

import java.util.Arrays;

import bean.Student;

public class Ex01Student {
	public static void main(String[] args) {
		Student[]students = {
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
		System.out.println(" Danh sách sinh viên từng đạt loại A trong năm 2024 là: \n" + Arrays.toString(foundStudentA(students)));
		System.out.println("Danh sách sinh viên đã tham gia học lại môn cấu trúc dữ liệu năm 2024 là: \n" + Arrays.toString(getStudents(students)));
	}
	
	private static Student[]
	foundStudentA(Student[] students) {
		Student[] result = new Student[students.length];
		int count = 0;
		
		for (Student student: students) {
			if (student.getXeploai() == 'A') {
				result[count++] = student;
			}
		}
		return Arrays.copyOfRange(result, 0, count);
		
	}
	private static Student[]
	getStudents(Student[]students) {
		Student[] result = new Student[students.length];
		int count = 0;
		int a = 0;
		
		for (int i = 0; i <= students.length - 1; i++) {
			for (int j = i+1; j< students.length; j++) {
				if (students[i].getId() == students[j].getId()) {
					result[count++] = students[i];
					a++;
				}
			}
			if (a>1) {
				break;
			}
			
			}
		return Arrays.copyOfRange(result, 0, count);
		
	}


}
