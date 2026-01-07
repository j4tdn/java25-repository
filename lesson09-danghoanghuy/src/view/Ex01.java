package view;

import bean.Student;

/*
 Bài 1(20đ):Trong năm 2024 có N sinh viên khoa CNTT đăng ký học phần cấu trúc dữ liệu. Thông
tin mỗi sinh viên được lưu trữ tại hệ thống gồm: Mã sinh viên, Họ tên, Xếp loại
Xếp loại học lực được phân loại: A, B, C, D, E, F
Với sinh viên có học lực loại F bắt buộc phải đăng ký học lại.
Student[] students
{
new Student(102, "Nam", C),
new Student(103, "Bảo", F),
new Student(104, "Hoàng", D),
new Student(105, "Nguyên", B),
new Student(107, "Vũ", F),
new Student(109, "Lan", A),
new Student(202, "Đạt", C),
new Student(103, "Bảo", F),
new Student(107, "Vũ", C),
new Student(104, "Hoàng", B)
}
▪ Tìm danh sách sinh viên từng đạt loại A trong năm 2024.
▪ Tìm danh sách sinh viên đã tham gia học lại(học nhiều hơn 1 lần)môn cấu trúc dữ liệu trong
năm 2024.
Method signature: getStudents(...) >> Student[]
 */

public class Ex01 {

	public static void main(String[] args) {
		
		Student[] students = {
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
		
		System.out.println("Sinh vien dat diem A: ");
		getStudentA(students);
		
		System.out.println("Sinh vien dat diem F phai hoc lai: ");
		getStudentF(students);
	}
	
	private static void getStudentA(Student[] students) {
		
		for(Student s: students) {
			
			if(s.getScope().equalsIgnoreCase("A")) {
				System.out.println(s);
			}
		}
	}
	
	private static void getStudentF(Student[] students) {
			
			for(Student s: students) {
				
				if(s.getScope().equalsIgnoreCase("F")) {
					System.out.println(s);
				}
			}
		}
}
