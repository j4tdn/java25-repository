package view;

import java.math.BigDecimal;
import java.util.Scanner;

import bean.Student;

public class Bai1 {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Student s1 = new Student(1L,"Nguyen Thanh Anh", toPoint("8.5"),toPoint("9.5"));
		Student s2 = new Student(2L,"Vu Nhat Tan", toPoint("8.5"),toPoint("8.5"));
		Student s3 = inputStudent();
		
		Student[] students = new Student[3];
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		
		findStudentHashPointGreaterThanEightAHalf(students);
		System.out.println("=========================================");
		findStudentWTheoryGreaterThanPractice(students);
	}
	
	private static BigDecimal toPoint(String value) {
		return new BigDecimal(value);
	}
	
	private static Student inputStudent() {
		Student student = new Student();
		System.out.println("--- Đang nhập thông tin cho sinh viên ---");
		System.out.print("Nhập mã sinh viên: ");
		long studentId = Long.parseLong(sc.nextLine());
		System.out.print("Nhập tên sinh viên: ");
		String fullName = sc.nextLine();
		System.out.print("Nhập điểm lý thuyết: ");
		String theoryPoint = sc.nextLine();
		System.out.print("Nhập điểm thực hành: ");
		String practicePoint = sc.nextLine();

		student.setId(studentId);
		student.setFullName(fullName);
		student.setTheoryPoint(toPoint(theoryPoint));
		student.setPracticePoint(toPoint(practicePoint));
		
		return student;
	}
	
	private static void findStudentHashPointGreaterThanEightAHalf(Student[] students) {
		for(int i = 0;i<students.length;++i) {
			if(students[i].isAvgPointGreaterThanEightAHalf()) {
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
