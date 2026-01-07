package ex01;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		Student[] students = {
				new Student("102", "Nam", Equivalent.C),
				new Student("103", "Bảo", Equivalent.F),
				new Student("104", "Hoàng", Equivalent.D),
				new Student("105", "Nguyên", Equivalent.B),
				new Student("107", "Vũ", Equivalent.F),
				new Student("109", "Lan",Equivalent.A),
				new Student("202", "Đạt", Equivalent.C),
				new Student("103", "Bảo", Equivalent.F),
				new Student("107", "Vũ", Equivalent.C),
				new Student("104", "Hoàng", Equivalent.B)
		};
		
		
		System.out.println("Danh sach sinh vien tung dat loai A trong nam 2024 ");
		Student[] s1 = getStudents(students, Equivalent.B);
		prinStudent(s1);
		
		System.out.println("\nDanh sach sinh vien da tham gia hoc lai mon cau truc du lieu trong nam 2024");
		Student[] s2 = getStudents(students, Equivalent.F);
		prinStudent(s2);
	}
	
	private static void prinStudent(Student[] student) {
		for (Student i : student) {
			System.out.println(i);
		}
	}
	
	private static Student[] getStudents(Student[] students, Equivalent equivalent) {
		Student[] result = new Student[students.length];
		int index = 0;
		for (Student s : students) {
			if (s.getEquivalent() == equivalent) {
				result[index++] = s;
			}
		}
		
		return Arrays.copyOfRange(result, 0, index);
	}
	


}
