package assignments;

import java.math.BigDecimal;
import java.util.Scanner;

import bean.Student;

public class Ex01 {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Student sv1 = new Student(1L,"Phung Van Tien Dat", point("10"),point("9.5"));
		Student sv2 = new Student(2L,"Dang Chau Thy", point("8"),point("8.5"));
		Student sv3 = input();
		
		Student[] students = new Student[3];
		students[0] = sv1;
		students[1] = sv2;
		students[2] = sv3;
		
//		findStudentMatchedCondition(students);
		findStudentWTheoryGreaterThanPractice(students);

	}
	
	private static BigDecimal point(String value) {
		return new BigDecimal(value);
	}
	
	private static Student input() {
		Student sv = new Student();
		System.out.println("-- Nhap thong tin cho sv3 --");
		System.out.println("-- Nhap ma sinh vien cho sv3 --");
		long studentId = Long.parseLong(sc.nextLine());
		System.out.println("-- Nhap ten sinh vien --");
		String fullName = sc.nextLine();
		System.out.println("-- Nhap diem ly thuyet cho sinh vien --");
		String theoryPoint = sc.nextLine();
		System.out.println("-- Nhap diem thuc hanh cho sinh vien --");
		String practicePoint = sc.nextLine();

		sv.setStudentId(studentId);
		sv.setFullName(fullName);
		sv.setTheoryPoint(point(theoryPoint));
		sv.setPracticePoint(point(practicePoint));
		return sv;
	}
	
	private static void findStudentMatchedCondition(Student[] students) {
		for(int i = 0;i<students.length;++i) {
			if(students[i].isAvgPointGreaterThanEight()) {
				System.out.println(students[i]);
			}
		}
	}
	
	private static void findStudentWTheoryGreaterThanPractice(Student[] students) {
		for(int i = 0;i<students.length;++i) {
			if(students[i].isTheoryGreaterThanPractice()) {
				System.out.println(students[i]);
			}
		}
	}
}
